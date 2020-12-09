package com.github.ponclure.blockus.game;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.arena.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class GameManager implements Listener {

    private static final int MINIMUM_PLAYER_COUNT;

    static {
        MINIMUM_PLAYER_COUNT = 4;
    }

    private final BlockUsPlugin pluginInstance = BlockUsPlugin.getBlockUs().plugin();
    private final Map<Arena, ArenaHolder> gameMap;

    public GameManager() {
        pluginInstance.getServer().getPluginManager().registerEvents(this, pluginInstance);
        gameMap = new HashMap<>();
    }

    public Lobby openLobby(Arena arena,
                           UUID leader) throws IllegalStateException {
        if (gameMap.containsKey(arena)) {
            throw new IllegalStateException("Arena " + arena.getName() + " is already in use!");
        }
        Lobby lobby = new Lobby(arena, leader, true);
        gameMap.put(arena, lobby);
        return lobby;
    }

    public boolean canStartGame(Lobby lobby) {
        return lobby.set.size() >= MINIMUM_PLAYER_COUNT;
    }

    public Game startGame(Lobby lobby) throws IllegalStateException {
        if (isArenaCurrentlyUsed(lobby.arena)) {
            throw new IllegalStateException("Arena " + lobby.arena.getName() + " is already in use!");
        }
        if (!canStartGame(lobby)) {
            throw new IllegalStateException("Game needs at least 4 players");
        }
        lobby.terminate();
        Game game = new Game(lobby, null);
        gameMap.put(game.arena, game);
        return game;
    }

    public boolean isArenaCurrentlyUsed(Arena arena) {
        return gameMap.containsKey(arena);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (ArenaHolder arenaHolder : gameMap.values()) {
            arenaHolder.onPlayerJoin(event);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        for (ArenaHolder arenaHolder : gameMap.values()) {
            arenaHolder.onPlayerQuit(event);
        }
    }
}
