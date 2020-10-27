package com.github.amongus.implementation.v1_16_R1;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.craftbukkit.v1_16_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.github.amongus.packet.PacketHandler;

import net.minecraft.server.v1_16_R1.ChatComponentText;
import net.minecraft.server.v1_16_R1.ChatHexColor;
import net.minecraft.server.v1_16_R1.DataWatcher.Item;
import net.minecraft.server.v1_16_R1.DataWatcherObject;
import net.minecraft.server.v1_16_R1.DataWatcherRegistry;
import net.minecraft.server.v1_16_R1.IChatBaseComponent;
import net.minecraft.server.v1_16_R1.MapIcon;
import net.minecraft.server.v1_16_R1.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_16_R1.PacketPlayOutMap;
import net.minecraft.server.v1_16_R1.PlayerConnection;

public class NMSHandler implements PacketHandler {
	public static final int PACKET_THRESHOLD_MS = 0;

	private static Field[] MAP_FIELDS = new Field[10];
	private static Field METADATA_ID;
	private static Field METADATA_ITEMS;

	static {
		try {
			MAP_FIELDS[0] = PacketPlayOutMap.class.getDeclaredField("a");
			MAP_FIELDS[1] = PacketPlayOutMap.class.getDeclaredField("b");
			MAP_FIELDS[2] = PacketPlayOutMap.class.getDeclaredField("c");
			MAP_FIELDS[3] = PacketPlayOutMap.class.getDeclaredField("d");
			MAP_FIELDS[4] = PacketPlayOutMap.class.getDeclaredField("e");
			MAP_FIELDS[5] = PacketPlayOutMap.class.getDeclaredField("f");
			MAP_FIELDS[6] = PacketPlayOutMap.class.getDeclaredField("g");
			MAP_FIELDS[7] = PacketPlayOutMap.class.getDeclaredField("h");
			MAP_FIELDS[8] = PacketPlayOutMap.class.getDeclaredField("i");
			MAP_FIELDS[9] = PacketPlayOutMap.class.getDeclaredField("j");

			for (Field field : MAP_FIELDS) {
				field.setAccessible(true);
			}

			METADATA_ID = PacketPlayOutEntityMetadata.class.getDeclaredField("a");
			METADATA_ID.setAccessible(true);
			METADATA_ITEMS = PacketPlayOutEntityMetadata.class.getDeclaredField("b");
			METADATA_ITEMS.setAccessible(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private final Map<UUID, PlayerConnection> playerConnections = new ConcurrentHashMap<UUID, PlayerConnection>();
	private final Map<UUID, Long> lastUpdated = new ConcurrentHashMap<UUID, Long>();
	private final Set<Integer> maps = new TreeSet<Integer>();

	@Override
	public void display(UUID[] viewers, int map, int width, int height, ByteBuffer rgb, int videoWidth) {
		int vidHeight = rgb.capacity() / videoWidth;
		// Get the width and height in pixels of the entire screen
		int pixW = width << 7;
		int pixH = height << 7;
		// Get the difference between the widths and divide by two
		// to find the top left of the video where it should begin from
		int xOff = (pixW - videoWidth) / 2;
		int yOff = (pixH - vidHeight) / 2;
		display(viewers, map, width, height, rgb, videoWidth, xOff, yOff);
	}

	@Override
	public void display(UUID[] viewers, int map, int width, int height, ByteBuffer rgb, int videoWidth, int xOff,
			int yOff) {
		// Get the video height
		int vidHeight = rgb.capacity() / videoWidth;
		// Get the ends of the video bounds
		// May or may not be out of bounds
		int negXOff = xOff + videoWidth;
		int negYOff = yOff + vidHeight;

		// Set the bounds to the size of the screen, if the video is bigger
		// Can't use bitwise because of negative numbers here
		int xLoopMin = Math.max(0, xOff / 128);
		int yLoopMin = Math.max(0, yOff / 128);
		int xLoopMax = Math.min(width, (int) Math.ceil(negXOff / 128.0));
		int yLoopMax = Math.min(height, (int) Math.ceil(negYOff / 128.0));

		// Find the max amount of packets that need to be sent
		PacketPlayOutMap[] packetArray = new PacketPlayOutMap[(xLoopMax - xLoopMin) * (yLoopMax - yLoopMin)];
		int arrIndex = 0;

		for (int y = yLoopMin; y < yLoopMax; y++) {
			// Get the cell's min y
			int relY = y << 7;
			// Get the y of the frame, and cap it at 0
			// Should be 0 unless the top of the frame is within this cell
			int topY = Math.max(0, yOff - relY);
			int yDiff = Math.min(128 - topY, negYOff - (relY + topY));
			for (int x = xLoopMin; x < xLoopMax; x++) {
				int relX = x << 7;
				int topX = Math.max(0, xOff - relX);
				int xDiff = Math.min(128 - topX, negXOff - (relX + topX));

				int xPixMax = xDiff + topX;
				int yPixMax = yDiff + topY;

				byte[] mapData = new byte[xDiff * yDiff];
				for (int iy = topY; iy < yPixMax; iy++) {
					int yPos = relY + iy;
					int indexY = (yPos - yOff) * videoWidth;
					for (int ix = topX; ix < xPixMax; ix++) {
						int val = (iy - topY) * xDiff + ix - topX;
						mapData[val] = rgb.get(indexY + relX + ix - xOff);
					}
				}

				int mapId = map + width * y + x;
				PacketPlayOutMap packet = new PacketPlayOutMap();

				try {
					MAP_FIELDS[0].set(packet, mapId);
					MAP_FIELDS[1].set(packet, (byte) 0);
					MAP_FIELDS[2].set(packet, false);
					MAP_FIELDS[3].set(packet, false);
					MAP_FIELDS[4].set(packet, new MapIcon[0]);
					MAP_FIELDS[5].set(packet, topX);
					MAP_FIELDS[6].set(packet, topY);
					MAP_FIELDS[7].set(packet, xDiff);
					MAP_FIELDS[8].set(packet, yDiff);
					MAP_FIELDS[9].set(packet, mapData);
				} catch (Exception exception) {
					exception.printStackTrace();
				}

				packetArray[arrIndex++] = packet;
			}
		}

		if (viewers == null) {
			for (UUID uuid : playerConnections.keySet()) {
				long val = lastUpdated.getOrDefault(uuid, 0L);
				if (System.currentTimeMillis() - val > PACKET_THRESHOLD_MS) {
					lastUpdated.put(uuid, System.currentTimeMillis());
					PlayerConnection connection = playerConnections.get(uuid);
					for (PacketPlayOutMap packet : packetArray) {
						connection.sendPacket(packet);
					}
				}
			}
		} else {
			for (UUID uuid : viewers) {
				long val = lastUpdated.getOrDefault(uuid, 0L);
				if (System.currentTimeMillis() - val > PACKET_THRESHOLD_MS) {
					lastUpdated.put(uuid, System.currentTimeMillis());
					PlayerConnection connection = playerConnections.get(uuid);
					if (connection != null) {
						for (PacketPlayOutMap packet : packetArray) {
							connection.sendPacket(packet);
						}
					}
				}
			}
		}
	}

	@Override
	public void display(UUID[] viewers, Entity[] entities, int[] data, int width) {
		int height = data.length / width;
		int maxHeight = Math.min(height, entities.length);

		PacketPlayOutEntityMetadata[] packets = new PacketPlayOutEntityMetadata[maxHeight];
		int index = 0;
		for (int i = 0; i < maxHeight; i++) {
			int id = ((CraftEntity) entities[i]).getHandle().getId();

			ChatComponentText component = new ChatComponentText("");
			for (int x = 0; x < width; x++) {
				int c = data[index++];
				ChatComponentText p = new ChatComponentText("█");
				p.setChatModifier(p.getChatModifier().setColor(ChatHexColor.a(c & 0xFFFFFF)));
				component.addSibling(p);
			}

			Item<Optional<IChatBaseComponent>> item = new Item<Optional<IChatBaseComponent>>(
					new DataWatcherObject<Optional<IChatBaseComponent>>(2, DataWatcherRegistry.f),
					Optional.of(component));

			PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata();
			try {
				METADATA_ID.set(packet, id);
				METADATA_ITEMS.set(packet, Arrays.asList(item));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			packets[i] = packet;
		}

		if (viewers == null) {
			for (UUID uuid : playerConnections.keySet()) {
				PlayerConnection connection = playerConnections.get(uuid);
				for (PacketPlayOutEntityMetadata packet : packets) {
					connection.sendPacket(packet);
				}
			}
		} else {
			for (UUID uuid : viewers) {
				PlayerConnection connection = playerConnections.get(uuid);
				if (connection != null) {
					for (PacketPlayOutEntityMetadata packet : packets) {
						connection.sendPacket(packet);
					}
				}
			}
		}
	}

	@Override
	public Object onPacketInterceptOut(Player viewer, Object packet) {
		if (packet instanceof PacketPlayOutMinimap) {
			return ((PacketPlayOutMinimap) packet).packet;
		} else if (packet instanceof PacketPlayOutMap) {
			if (packet.getClass().equals(PacketPlayOutMap.class)) {
				try {
					int id = MAP_FIELDS[0].getInt(packet);
					if (maps.contains(id)) {
//						return null;
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return packet;
	}

	@Override
	public Object onPacketInterceptIn(Player viewer, Object packet) {
		return packet;
	}

	@Override
	public void registerPlayer(Player player) {
		playerConnections.put(player.getUniqueId(), ((CraftPlayer) player).getHandle().playerConnection);
	}

	@Override
	public void unregisterPlayer(Player player) {
		playerConnections.remove(player.getUniqueId());
	}

	@Override
	public boolean isMapRegistered(int id) {
		return maps.contains(id);
	}

	@Override
	public void registerMap(int id) {
		maps.add(id);
	}

	@Override
	public void unregisterMap(int id) {
		maps.remove(id);
	}

	private class PacketPlayOutMinimap extends PacketPlayOutMap {
		protected final PacketPlayOutMap packet;

		@SuppressWarnings("unused")
		protected PacketPlayOutMinimap(PacketPlayOutMap packet) {
			this.packet = packet;
		}
	}

}
