package com.github.amongus;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class AmongUsPlugin extends JavaPlugin {

	private static World WORLD;
	
	public static World getWorld() {
		return WORLD;
	}
	
	public static void setWorld(World w) {
		WORLD = w;
	}

	@Override
	public void onEnable() {
		AmongUs.isAvailable = true;
		Logger logger = Bukkit.getLogger();
		logger.info("Among Us is Loading Up");
	}

	@Override
	public void onDisable() {
		AmongUs.isAvailable = false;
	}
}
