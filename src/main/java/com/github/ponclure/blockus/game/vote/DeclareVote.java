package com.github.ponclure.blockus.game.vote;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.simplenpcframework.api.NPC;
import com.github.ponclure.simplenpcframework.api.skin.AsyncSkinFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.UUID;

public class DeclareVote {

    private final Game game;

    private final StringBuilder sb;
    private String str;
    private String declaration;
    private int index;

    public DeclareVote(Game g) {
        this.game = g;
        this.sb = new StringBuilder();
        this.str = sb.toString();
    }

    public void prepareEjection(Participant thrown) {
        World w = Bukkit.getPlayer(thrown.getUuid()).getWorld();
        w.setTime(18000);
        for (UUID uuid : game.getParticipants().keySet()) {
            Player player = Bukkit.getPlayer(uuid);
            player.teleport(new Location(w, 600, 600, 600, 180, 180));
        }
        declareVote(thrown);
        moveNPC(thrown, w);
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
            }.runTaskLater(BlockUsPlugin.getBlockUs().plugin(), 5);
        }
    }

    private NPC ejected;

    public void moveNPC(Participant thrown, World w) {
        AsyncSkinFetcher.fetchSkinFromUuidAsync(thrown.getUuid(), skin -> {
            ejected = BlockUsPlugin.getBlockUs().getNpcFramework().createNPC(Arrays.asList(thrown.getNick()));
            ejected.setLocation(new Location(w, 595, 600, 600));
            ejected.create();
        });
        new BukkitRunnable() {
            @Override
            public void run() {
                Location loc = ejected.getLocation();
                double x = loc.getX();
                if (x == 605) {
                    for (Participant p : game.getParticipants().values()) {
                        Bukkit.getPlayer(p.getUuid()).teleport(p.getSpawnLocation().toLocation(w));
                    }
                    cancel();
                }
                loc.setX(x + 1);
                ejected.setLocation(loc);
            }
        }.runTaskTimer(BlockUsPlugin.getBlockUs().plugin(), 5L, 100L);
    }

}
