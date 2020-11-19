package com.github.amongus.game.vote;

import com.github.amongus.AmongUs;
import com.github.amongus.game.Game;
import com.github.amongus.player.Participant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

// Unfinished -Pulse
public class DeclareVote {

    private Game game;

    private StringBuilder sb;
    private String str;
    private String declaration;
    private int index;

    public DeclareVote(Game g) {
        this.game = g;
        this.sb = new StringBuilder();
        this.str = sb.toString();
    }

    /*
    TODO: Set the time of the world to be night, teleport the players
     to a place which is dark. Then create an NPC using the Simple
     NPC Framework which moves from left to right, along with the
     declareVote() method being called for the ejection. Store the
     values of the spawn regions for the players, then teleport them
     back there.
     */
    public void prepareEjection() {
        for (UUID uuid : game.getParticipants().keySet()) {
            Player player = Bukkit.getPlayer(uuid);
            // player.teleport(new Location(0, 0, 0, 180, 180));
        }
    }

    public void declareVote(Participant thrown) {
        declaration = thrown.getNick();
        if (game.getSettings().isConfirmingEjections()) {
            declaration += (thrown.isImposter() ? " was the Imposter" : " was not the Imposter");
        } else {
            declaration += " was ejected";
        }
        while (!str.equals(declaration)) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    str = sb.toString();
                    game.getParticipants().keySet().forEach(uuid -> Bukkit.getPlayer(uuid).sendTitle(str, "", 1, 20, 1));
                    sb.append(declaration.charAt(index));
                    index++;
                }
            }.runTaskLater(AmongUs.plugin(), 5);
        }
    }

}
