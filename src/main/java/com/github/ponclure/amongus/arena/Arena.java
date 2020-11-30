package com.github.ponclure.amongus.arena;

import com.github.ponclure.amongus.arena.components.Door;
import com.github.ponclure.amongus.arena.components.Room;
import com.github.ponclure.amongus.arena.components.Vent;
import com.github.ponclure.amongus.game.GameSettings;
import com.github.ponclure.amongus.utility.Utils;
import com.github.ponclure.amongus.utility.container.AABB;
import com.github.ponclure.amongus.utility.container.Vec3;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public final class Arena {

    private final GameSettings fallBackSettings;
    private final UUID world;
    private final String name;
    private final AABB boundingBox;
    private final int hashCode;
    private final Vec3 gamespawn, lobbySpawn;
    private final Room[] rooms;
    private final Door[] doors;
    private final Vent[] vents;

    private Arena(Builder builder) {
        this.fallBackSettings = builder.fallBackSettings;
        this.world = builder.world;
        this.name = Utils.color(builder.name);
        this.boundingBox = builder.boundingBox;
        this.hashCode = builder.hashCode;
        this.lobbySpawn = builder.lobbySpawn;
        this.gamespawn = builder.gameSpawn;
        this.rooms = builder.rooms;
        this.doors = builder.doors;
        this.vents = builder.vents;
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

    public AABB getBoundingBox() {
        return boundingBox;
    }

    public Vec3 getLobbySpawn() {
        return lobbySpawn;
    }

    public Vec3 getGamespawn() {
        return gamespawn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return hashCode == ((Arena) o).hashCode;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Door[] getDoors() {
        return doors;
    }

    public Vent[] getVents() {
        return vents;
    }

    static class Builder {

        private GameSettings fallBackSettings;
        private UUID world;
        private String name;
        private AABB boundingBox;
        private int hashCode;
        private Vec3 gameSpawn, lobbySpawn;
        private Room[] rooms;
        private Door[] doors;
        private Vent[] vents;

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

        public Builder setBoundingBox(AABB boundingBox) {
            this.boundingBox = boundingBox;
            return this;
        }

        public Builder setHashCode(int hashCode) {
            this.hashCode = hashCode;
            return this;
        }

        public Builder setLobbySpawn(Vec3 vector) {
            lobbySpawn = vector;
            return this;
        }

        public Builder setGameSpawn(Vec3 vector) {
            gameSpawn = vector;
            return this;
        }

        public Builder setRooms(Room... room) {
            this.rooms = room;
            return this;
        }

        public Builder setDoors(Door... door) {
            this.doors = door;
            return this;
        }

        public Builder setVents(Vent... vent) {
            this.vents = vents;
            return this;
        }

        public Arena build() {
            return new Arena(this);
        }
    }
}
