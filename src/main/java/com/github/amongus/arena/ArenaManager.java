package com.github.amongus.arena;

import com.github.amongus.game.GameSettings;
import com.github.amongus.utility.Namespace;
import com.github.amongus.utility.container.AABB;
import com.github.amongus.utility.container.Vec3;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ArenaManager {

    private final Map<String, Arena> arenaMap;

    public ArenaManager() {
        arenaMap = new HashMap<>();
    }

    public Arena loadArena(Namespace namespace,
                           String displayName,
                           GameSettings defaultSettings,
                           AABB boundingBox,
                           UUID world,
                           Vec3 lobbySpawn,
                           Vec3 gameSpawn) {
        String name = namespace.toString();
        if (arenaMap.get(name) != null) {
            throw new IllegalStateException("An arena with the name " + name + " is already registered.");
        }
        Arena arena = new Arena.Builder()
                .setHashCode(name.hashCode())
                .setBoundingBox(boundingBox)
                .setName(displayName)
                .setFallBackSettings(defaultSettings)
                .setWorld(world)
                .setGameSpawn(gameSpawn)
                .setLobbySpawn(lobbySpawn)
                .build();
        arenaMap.put(name,arena);
        return arena;
    }

    public void unloadArena(Namespace namespace) {
        arenaMap.remove(namespace.toString());
    }

    public boolean isLoaded(Namespace namespace) {
        return arenaMap.get(namespace.toString()) != null;
    }

    public Arena getArena(Namespace name) {
        return arenaMap.get(name.toString());
    }

}
