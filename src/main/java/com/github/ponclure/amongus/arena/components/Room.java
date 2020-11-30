package com.github.ponclure.amongus.arena.components;

import com.github.ponclure.amongus.utility.container.Vec3;

public class Room {

    // Used to store the exact coordinates of a Room (which may be an irregular shape)

    private final String name;
    private final Vec3 middle;

    public Room(String name, Vec3 vec) {
        this.name = name;
        this.middle = vec;
    }

    public String getName() {
        return name;
    }

    public Vec3 getMiddle() {
        return middle;
    }

}
