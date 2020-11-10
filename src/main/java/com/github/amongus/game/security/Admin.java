package com.github.amongus.game.security;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.github.amongus.arena.Room;
import com.github.amongus.game.Game;
import com.github.amongus.game.tasks.Task;
import com.github.amongus.player.Participant;

import net.md_5.bungee.api.ChatColor;

public class Admin extends Task {
	
	public Admin(Game game, Location loc) {
		super(game, "Admin", loc);
	}

	@Override
	public void execute(Player p) {
		Map<Room, Integer> counts = getCounts();
		p.sendMessage(ChatColor.GOLD + "---------------------------------------------");
		p.sendMessage(ChatColor.RED + "Crewmates in Rooms:");
		p.sendMessage(ChatColor.GOLD + "---------------------------------------------");
		for (Room room : counts.keySet()) {
			p.sendMessage(ChatColor.AQUA + room.getName() + ": " + counts.get(room));
		}
		p.sendMessage(ChatColor.GOLD + "---------------------------------------------");
	}

	public Map<Room, Integer> getCounts() {
		Map<Room, Integer> counts = new HashMap<>();
		Game game = this.getGame();
		for (Participant p : game.getPrePlayers()) {
			if (!p.isDead()) {
				Room r = getClosest(game.getArena().getRooms(), p.getPlayer().getLocation().toVector());
				if (counts.get(r) == null) {
					counts.put(r, 1);
				} else {
					counts.put(r, counts.get(r) + 1);
				}

//              OLD METHOD
//				for (Room r : game.getArena().getRooms()) {
//					Vector btm = r.getBottom();
//					Vector top = r.getTop();
//					if (matchesX(loc, btm, top) && matchesY(loc, btm, top) && matchesZ(loc, btm, top)) {
//						if (counts.get(r) == null) {
//							counts.put(r, 1);
//						} else {
//							counts.put(r, counts.get(r) + 1);
//						}
//					}
//				}
				
			}
		}
		return counts;
	}
	
	private Room getClosest(Room[] rooms, Vector player) {
		Room closest = null;
		double current = 0;
		for (Room r : rooms) {
			double dist = r.getMiddle().distance(player);
			if (dist < current) {
				current = dist;
				closest = r;
			}
		}
		return closest;
	}
	
	@Deprecated
	@SuppressWarnings("unused")
	private boolean matchesX(Location loc, Vector btm, Vector top) {
		int coord = loc.getBlockX();
		return coord >= btm.getBlockX() && coord <= top.getBlockX();
	}
	
	@Deprecated
	@SuppressWarnings("unused")
	private boolean matchesY(Location loc, Vector btm, Vector top) {
		int coord = loc.getBlockY();
		return coord >= btm.getBlockY() && coord <= top.getBlockY();
	}
	
	@Deprecated
	@SuppressWarnings("unused")
	private boolean matchesZ(Location loc, Vector btm, Vector top) {
		int coord = loc.getBlockZ();
		return coord >= btm.getBlockZ() && coord <= top.getBlockZ();
	}

}
