package com.github.amongus;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AmongUs extends JavaPlugin {
	
	private static AmongUs INSTANCE;
	private static World WORLD;
	
	public static Plugin getInstance() {
		return INSTANCE;
	}
	
	public static World getWorld() {
		return WORLD;
	}
	
	public static void setWorld(World w) {
		WORLD = w;
	}

	@Override
	public void onEnable() {

		INSTANCE = this;
		
		Logger logger = Bukkit.getLogger();
		logger.info("Among Us is Loading Up");
		
	}

}
