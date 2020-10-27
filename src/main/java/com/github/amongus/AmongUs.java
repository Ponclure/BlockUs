package com.github.amongus;

import com.github.amongus.arena.ArenaManager;
import com.github.amongus.game.GameManager;
import com.github.amongus.packet.DummyPacketHandler;
import com.github.amongus.packet.PacketHandler;
import com.github.amongus.reflection.NMSVersionHandler;
import com.github.amongus.reflection.TinyProtocol;

import io.netty.channel.Channel;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class AmongUs {

    private static final AmongUsPlugin PLUGIN;
    private static final ArenaManager ARENA_MANAGER;
    private static final GameManager GAME_MANAGER;
    private static final Logger LOGGER;
    private static final File DATA_FOLDER;
    
    private static PacketHandler handler;
    private static TinyProtocol protocol;

    static boolean isAvailable;

    static {
        PLUGIN = JavaPlugin.getPlugin(AmongUsPlugin.class);
        ARENA_MANAGER = new ArenaManager();
        GAME_MANAGER = new GameManager();
        LOGGER = PLUGIN.getLogger();
        DATA_FOLDER = PLUGIN.getDataFolder();
        handler = NMSVersionHandler.getNewPacketHandlerInstance();
		if (handler == null) {
			LOGGER.severe(NMSVersionHandler.VERSION + " is not supported!");
			handler = new DummyPacketHandler();
		}
		setProtocol((new TinyProtocol(AmongUs.plugin()) {
			@Override
			public Object onPacketOutAsync(Player player, Channel channel, Object packet) {
				return handler.onPacketInterceptOut(player, packet);
			}

			@Override
			public Object onPacketInAsync(Player player, Channel channel, Object packet) {
				return handler.onPacketInterceptIn(player, packet);
			}
		}));
    }

    public static AmongUsPlugin plugin() {
        return checkAvailability(PLUGIN);
    }

    public static ArenaManager arenaManager() {
        return checkAvailability(ARENA_MANAGER);
    }

    public static GameManager gameManager() {
        return checkAvailability(GAME_MANAGER);
    }

    public static Logger logger() {
        return checkAvailability(LOGGER);
    }

    public static File dataFolder() {
        return checkAvailability(DATA_FOLDER);
    }
    
	public static TinyProtocol getProtocol() {
		return protocol;
	}

	public static void setProtocol(TinyProtocol protocol) {
		AmongUs.protocol = protocol;
	}

    private static <T> T checkAvailability(T t) {
        if (!isAvailable) throw new IllegalStateException("Among Us hasn't been loaded yet.");
        return t;
    }

	public static PacketHandler getHandler() {
		return handler;
	}

}
