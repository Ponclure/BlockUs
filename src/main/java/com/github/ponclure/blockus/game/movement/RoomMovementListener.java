package com.github.ponclure.blockus.game.movement;

import com.github.ponclure.blockus.arena.components.EntryWay;
import com.github.ponclure.blockus.arena.components.Room;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.AbstractMap;
import java.util.Map;
import java.util.UUID;

public class RoomMovementListener implements Listener {

    private final Game game;

    public RoomMovementListener(Game game) {
        this.game = game;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Map<UUID, Participant> participants = game.getParticipants();
        Player player = event.getPlayer();
        if (!participants.containsKey(player.getUniqueId())) {
            return;
        }
        Location pLoc = event.getPlayer().getLocation();
        pLoc.setY(pLoc.getY() - 1);
        Room[] rooms = game.getArena().getRooms();
        Map<UUID, Map.Entry<Room, Integer>> playerRooms = game.getPlayerRooms();
        for (Room room : rooms) {
            for (EntryWay way : room.getEntries()) {
                for (Location loc : way.getEntry()) {
                    if (loc.equals(pLoc)) {
                        int originalValue = playerRooms.get(player.getUniqueId()).getValue();
                        if (originalValue == 2) {
                            playerRooms.get(player.getUniqueId()).setValue(0);
                            playerRooms.remove(player.getUniqueId());
                        } else {
                            playerRooms.put(player.getUniqueId(), new AbstractMap.SimpleEntry(room, 1));
                            player.sendTitle(ChatColor.GOLD + room.getName(), "", 20, 20, 20);
                        }
                        break;
                    }
                }
            }
        }
    }

}
