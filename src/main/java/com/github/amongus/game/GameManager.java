package com.github.amongus.game;

import com.github.amongus.arena.Arena;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class GameManager {

    private final Map<Arena, Game> runningGames;

    public GameManager() {
        runningGames = new HashMap<>();
    }

    public Game initGame(Arena arena, UUID host) {
        if (runningGames.get(arena) == null) {
            return null;
        }
        Game game = new Game(arena, host);
        runningGames.put(arena,game);
        return game;
    }

    public void getGame(Arena arena) {
        runningGames.get(arena);
    }

    public boolean isRunning(Arena arena) {
        return runningGames.get(arena) != null;
    }
}
