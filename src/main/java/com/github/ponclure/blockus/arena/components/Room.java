package com.github.ponclure.blockus.arena.components;

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

