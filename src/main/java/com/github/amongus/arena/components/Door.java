package com.github.amongus.arena.components;

import com.github.amongus.AmongUs;
import com.github.amongus.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class Door {

    // Used to store the location of a door

    private final BoundingBox[] entry;
    private final String doorName;

    public Door(String name, BoundingBox[] entries) {
        this.entry = entries;
        this.doorName = name;
    }

    public BoundingBox[] getEntry() {
        return entry;
    }

    public String getDoorName() { return doorName; }

    public void shutDoors() {
        for (BoundingBox box : entry) {
            Utils.setBlock(box, Material.IRON_BLOCK);
        }
        AmongUs.plugin().getServer().getScheduler().scheduleSyncDelayedTask(AmongUs.plugin(), new Runnable() {
            public void run() {
                for (BoundingBox box : entry) {
                    Utils.setBlock(box, Material.AIR);
                }
            }
        }, 100);
    }

}
