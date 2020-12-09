package com.github.ponclure.blockus.game.vision;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.collection.VisionFieldMap;
import com.github.ponclure.blockus.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class VisionControl implements Listener {

    private final Game game;
    private final VisionFieldMap vision;

    public VisionControl(Game game) {
        this.game = game;
        this.vision = new VisionFieldMap(game);
        Bukkit.getPluginManager().registerEvents(this, BlockUsPlugin.getBlockUs().plugin());
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
