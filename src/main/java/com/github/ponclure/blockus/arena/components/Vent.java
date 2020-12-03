package com.github.ponclure.blockus.arena.components;

import org.bukkit.block.Block;

public class Vent {

    private final Block vent;

    public Vent(Block b) {
        this.vent = b;
    }

    public Block getVent() {
        return vent;
    }

}
