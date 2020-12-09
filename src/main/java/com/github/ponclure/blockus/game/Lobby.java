package com.github.ponclure.blockus.game;

import com.github.ponclure.blockus.arena.Arena;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class Lobby extends ArenaHolder {

    private UUID leader;
    private boolean accessible;
    public final GameSettings.Builder settingsBuilder;

    public Lobby(Arena arena,
                 UUID uuid, boolean accessible) {
        super(arena);
        this.leader = uuid;
        this.accessible = accessible;
        settingsBuilder = new GameSettings.Builder();
    }

    @Override
    protected void asyncTick() {

    }

    @Override
    void onPlayerQuit(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        set.remove(uuid);
    }

    public void setLeader(UUID uuid) {
        leader = uuid;
    }

    public UUID getLeader() {
        return leader;
    }

    public void add(UUID uuid) {
        set.add(uuid);
    }

    public void remove(UUID uuid) {
        set.remove(uuid);
    }

    public void setAccessible(boolean mode) { this.accessible = mode; }

    public boolean isAccessible() { return accessible; }

}
