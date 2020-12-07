package com.github.ponclure.blockus.arena.components;

import com.github.ponclure.blockus.utility.container.Vec3;
import org.bukkit.Location;

public class Room {

    // Used to store the "Entry Ways" of a Room. If they pass through, the are officially in
    // the room. When they pass out, they exit.

    private final String name;
    private final EntryWay[] entries;

    public Room(String name, EntryWay... entries) {
        this.name = name;
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public EntryWay[] getEntries() {
        return entries;
    }

}

