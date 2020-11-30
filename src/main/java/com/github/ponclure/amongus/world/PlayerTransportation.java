package com.github.ponclure.amongus.world;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerTransportation {

    private final Location LOCATION = Bukkit.getWorld("skeld").getSpawnLocation();

    public boolean sendPlayer(Player p) {

        p.teleport(LOCATION);
        p.sendMessage(ChatColor.GOLD + "Teleporting you to Skeld");

        return true;

    }

    public boolean kickPlayer(Player p) {

        p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        p.sendMessage(ChatColor.GOLD + "You have left Skeld");

        return true;

    }

}
