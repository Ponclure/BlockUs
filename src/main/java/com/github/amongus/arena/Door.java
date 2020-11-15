package com.github.amongus.arena;

import org.bukkit.util.Vector;

public class Door {

    // Used to store the location of a door

    private final Vector middle;

    public Door(Vector vec) {
        this.middle = vec;
    }

    public Vector getMiddle() {
        return middle;
    }

}
