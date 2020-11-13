package com.github.amongus.arena;

import com.github.amongus.game.GameSettings;
import com.github.amongus.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Arena {

    private final GameSettings fallBackSettings;
    private final UUID world;
    private final String name;
    private final BoundingBox boundingBox;
    private final int hashCode;
    private final Vector gamespawn, lobbySpawn;
    private final Room[] rooms;

    private Arena(Builder builder) {
        this.fallBackSettings = builder.fallBackSettings;
        this.world = builder.world;
        this.name = Utils.color(builder.name);
        this.boundingBox = builder.boundingBox;
        this.hashCode = builder.hashCode;
        this.lobbySpawn = builder.lobbySpawn;
        this.gamespawn = builder.gameSpawn;
        this.rooms = builder.rooms;
    }

    public GameSettings getFallBackSettings() {
        return fallBackSettings;
    }

    public World getWorld() {
        return Bukkit.getWorld(world);
    }

    public String getName() {
        return name;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public Vector getLobbySpawn() {
        return lobbySpawn;
    }

    public Vector getGamespawn() {
        return gamespawn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return hashCode == ((Arena)o).hashCode;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    public Room[] getRooms() {
		return rooms;
	}

	static class Builder {
		
		private GameSettings fallBackSettings;
        private UUID world;
        private String name;
        private BoundingBox boundingBox;
        private int hashCode;
        private Vector gameSpawn, lobbySpawn;
        private Room[] rooms;

        public Builder setFallBackSettings(GameSettings fallBackSettings) {
            this.fallBackSettings = fallBackSettings;
            return this;
        }

        public Builder setWorld(UUID world) {
            this.world = world;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBoundingBox(BoundingBox boundingBox) {
            this.boundingBox = boundingBox;
            return this;
        }

        public Builder setHashCode(int hashCode) {
            this.hashCode = hashCode;
            return this;
        }

        public Builder setLobbySpawn(Vector vector) {
            lobbySpawn = vector;
            return this;
        }

        public Builder setGameSpawn(Vector vector) {
            gameSpawn = vector;
            return this;
        }
        
        public Builder setRooms(Room... room) {
        	this.rooms = room;
        	return this;
        }

        public Arena build() {
            return new Arena(this);
        }
    }
}
