package com.github.ponclure.blockus.game;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.arena.Arena;
import com.github.ponclure.blockus.collection.IdentitySet;
import com.github.ponclure.blockus.collection.MapHashSet;
import com.google.common.collect.ImmutableSet;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public abstract class ArenaHolder {

    final BlockUsPlugin pluginInstance = BlockUsPlugin.getBlockUs().plugin();
    final BukkitScheduler scheduler = pluginInstance.getServer().getScheduler();
    final IdentitySet<UUID> set = new MapHashSet<>();
    final Arena arena;
    final BukkitTask task;

    protected ArenaHolder(Arena arena) {
        this.arena = arena;
        task = scheduler.runTaskTimerAsynchronously(pluginInstance, this::asyncTick, 0L, 0L);
    }

    public Set<UUID> getSet() {
        return ImmutableSet.copyOf(set);
    }

    public boolean contains(UUID uuid) {
        return set.contains(uuid);
    }

    public boolean isValid() {
        try {
            return !scheduler.callSyncMethod(pluginInstance, task::isCancelled).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public Arena getArena() {
        return arena;
    }

    protected abstract void asyncTick();

    void terminate() {
        scheduler.runTask(pluginInstance, () -> {
            if (!task.isCancelled()) {
                task.cancel();
            }
        });
    }

    void onPlayerJoin(PlayerJoinEvent event) {

    }

    void onPlayerQuit(PlayerQuitEvent event) {

    }

}
