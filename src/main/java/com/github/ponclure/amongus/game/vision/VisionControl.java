package com.github.ponclure.amongus.game.vision;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.collection.VisionFieldMap;
import com.github.ponclure.amongus.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class VisionControl implements Listener {

    private final Game game;
    private VisionFieldMap vision;

    public VisionControl(Game game) {
        this.game = game;
        this.vision = new VisionFieldMap(game);
        Bukkit.getPluginManager().registerEvents(this, AmongUsPlugin.getAmongUs().plugin());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        UUID uuid = p.getUniqueId();
        if (!game.contains(uuid)) {
            return;
        }
        double dist = game.getParticipants().get(uuid).isImposter() ? game.getSettings().getImpostorVision() : game.getSettings().getCrewmateVision();
        vision.put(uuid, p.getNearbyEntities(dist, dist, dist));
    }

}
