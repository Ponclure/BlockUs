package com.github.ponclure.amongus.game;

import com.github.ponclure.amongus.utility.container.Vec3;

public class SpawnLocation {

    public Vec3[] getSpawnLocations(MapType type) {
        switch (type) {
            case Skeld:
                return initSpawns(Vec3.at(-255.5, 76.5, -271), Vec3.at(-255.5, 76.5, -273),
                        Vec3.at(-255.5, 76.5, -274), Vec3.at(-257.5, 76.5, -271), Vec3.at(-258.5, 76.5, -271),
                        Vec3.at(-260.5, 76.5, -273), Vec3.at(-260.5, 76.5, -274), Vec3.at(-250.5, 76.5, -276),
                        Vec3.at(-258.5, 76.5, -276), Vec3.at(-257.5, 76.5, -276));
            case Mirahq:
                return initSpawns(Vec3.ZERO);
            case Polus:
                return initSpawns(Vec3.ZERO);
            default:
                return null;
        }
    }

    public Vec3[] initSpawns(Vec3... array) {
        return array;
    }

    public enum MapType {
        Skeld, Mirahq, Polus
    }

}
