package com.github.amongus;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AmongUs extends JavaPlugin {
	
	private static AmongUs INSTANCE;
	
	public static Plugin getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void onEnable() {

		INSTANCE = this;
		
		Logger logger = Bukkit.getLogger();
		logger.info("Among Us is Loading Up");
		
		
	}

}
