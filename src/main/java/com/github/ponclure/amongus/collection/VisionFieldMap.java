package com.github.ponclure.amongus.collection;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class VisionFieldMap extends ConcurrentHashMap<UUID, Set<UUID>> {

    private final Game game;
    private final HashSet<UUID> imposters;
    private final double distSquaredImposter;
    private final double distSquaredCrewmate;

    public VisionFieldMap(Game game) {
        this.game = game;
        this.imposters = new HashSet(game.getImposters().stream().map(uuid -> uuid.getUuid()).collect(Collectors.toSet()));
        this.distSquaredImposter = Math.pow(game.getSettings().getImpostorVision(), 2);
        this.distSquaredCrewmate = Math.pow(game.getSettings().getCrewmateVision(), 2);
        for (UUID uuid : game.getParticipants().keySet()) {
            Set<UUID> uuids = new HashSet<>();
            super.put(uuid, uuids);
        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(AmongUsPlugin.getAmongUs().plugin(), new BukkitRunnable() {
            @Override
            public void run() {
                if (!game.isValid()) {
                    cancel();
                }
                for (UUID uuid : VisionFieldMap.this.keySet()) {
                    for (UUID visible : VisionFieldMap.this.get(uuid)) {
                        if (imposters.contains(uuid)) {
                            if (Bukkit.getPlayer(uuid).getLocation().distanceSquared(Bukkit.getPlayer(visible).getLocation()) > distSquaredImposter) {
                                Bukkit.getPlayer(uuid).hidePlayer(AmongUsPlugin.getAmongUs().plugin(), Bukkit.getPlayer(visible));
                            }
                        } else {
                            if (Bukkit.getPlayer(uuid).getLocation().distanceSquared(Bukkit.getPlayer(visible).getLocation()) > distSquaredCrewmate) {
                                Bukkit.getPlayer(uuid).hidePlayer(AmongUsPlugin.getAmongUs().plugin(), Bukkit.getPlayer(visible));
                            }
                        }
                    }
                }
            }
        }, 20L, 20L);
    }

    public void put(UUID uuid, List<Entity> entities) {
        Player player = Bukkit.getPlayer(uuid);
        entities.forEach(entity -> {
            if (entity instanceof Player) {
                super.get(uuid).add(entity.getUniqueId());
                player.showPlayer(AmongUsPlugin.getAmongUs().plugin(), (Player)entity);
            }
        });
    }

    public void addUUID(UUID uuid, UUID visible) {
        super.get(uuid).add(visible);
        Bukkit.getPlayer(uuid).showPlayer(AmongUsPlugin.getAmongUs().plugin(), Bukkit.getPlayer(visible));
    }

    public void removeUUID(UUID uuid, UUID notVisible) {
        super.get(uuid).remove(notVisible);
        Bukkit.getPlayer(uuid).hidePlayer(AmongUsPlugin.getAmongUs().plugin(), Bukkit.getPlayer(notVisible));
    }

    public void forceDefaults() {
        for (UUID uuid : super.keySet()) {
            super.get(uuid).forEach(x -> removeUUID(uuid, x));
        }
    }

}
