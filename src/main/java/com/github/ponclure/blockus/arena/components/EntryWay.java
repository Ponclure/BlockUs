package com.github.ponclure.blockus.arena.components;

import org.bukkit.Location;

public class EntryWay {

    private final Location[] entry;

    public EntryWay(Location... locations) {
        this.entry = locations;
    }

    public Location[] getEntry() {
        return entry;
    }

}
