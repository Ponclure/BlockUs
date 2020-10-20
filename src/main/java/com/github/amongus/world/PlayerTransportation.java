package com.github.amongus.world;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.github.amongus.AmongUs;

import net.md_5.bungee.api.ChatColor;

public class PlayerTransportation {
	
	private Location LOCATION = AmongUs.getWorld().getSpawnLocation();
	
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
