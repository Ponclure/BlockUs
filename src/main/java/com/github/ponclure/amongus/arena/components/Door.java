package com.github.ponclure.amongus.arena.components;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.utility.Utils;
import com.github.ponclure.amongus.utility.container.AABB;
import org.bukkit.Bukkit;
import org.bukkit.Material;

public class Door {

    // Used to store the location of a door

    private final AABB[] entry;
    private final String doorName;

    public Door(String name, AABB[] entries) {
        this.entry = entries;
        this.doorName = name;
    }

    public AABB[] getEntry() {
        return entry;
    }

    public String getDoorName() {
        return doorName;
    }

    public void shutDoors() {
        for (AABB box : entry) {
            Utils.setBlock(box, Material.IRON_BLOCK);
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(AmongUsPlugin.getAmongUs().plugin(), new Runnable() {
            public void run() {
                for (AABB box : entry) {
                    Utils.setBlock(box, Material.AIR);
                }
            }
        }, 100);
    }

}
