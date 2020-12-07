package com.github.ponclure.blockus.game.security;

import com.github.ponclure.blockus.arena.components.Room;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.game.tasks.Task;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.blockus.utility.container.Vec3;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Admin extends Task {

    public Admin(Game game, String name, Location loc, Participant holder) {
        super(game, name, loc, holder);
    }

    public Map<Room, Integer> getCounts() {
        Map<Room, Integer> counts = new HashMap<>();
        Game game = this.getGame();

        for (Participant p : game.getParticipants().values()) {
            if (!p.isDead()) {
                Room r = getRoom(p.getUuid());
                if (counts.containsKey(r)) {
                    counts.put(r, counts.get(r) + 1);
                } else {
                    counts.put(r, 1);
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

    private Room getRoom(UUID p) {
        return getGame().getPlayerRooms().get(p).getKey();
    }

    @Deprecated
    private boolean matchesX(Location loc, Vec3 btm, Vec3 top) {
        int coord = loc.getBlockX();
        return coord >= btm.getBlockX() && coord <= top.getBlockX();
    }

    @Deprecated
    private boolean matchesY(Location loc, Vec3 btm, Vec3 top) {
        int coord = loc.getBlockY();
        return coord >= btm.getBlockY() && coord <= top.getBlockY();
    }

    @Deprecated
    private boolean matchesZ(Location loc, Vec3 btm, Vec3 top) {
        int coord = loc.getBlockZ();
        return coord >= btm.getBlockZ() && coord <= top.getBlockZ();
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        Player p = e.getPlayer();
        Map<Room, Integer> counts = getCounts();
        p.sendMessage(ChatColor.GOLD + "---------------------------------------------");
        p.sendMessage(ChatColor.RED + "Crewmates in Rooms:");
        p.sendMessage(ChatColor.GOLD + "---------------------------------------------");
        for (Room room : counts.keySet()) {
            p.sendMessage(ChatColor.AQUA + room.getName() + ": " + counts.get(room));
        }
        p.sendMessage(ChatColor.GOLD + "---------------------------------------------");
    }

}
