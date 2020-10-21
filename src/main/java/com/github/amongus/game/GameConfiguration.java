package com.github.amongus.game;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.craftbukkit.libs.jline.internal.Nullable;

public class GameConfiguration {

	/*
	 * Recommended default settings for a game
	 * 
	 */

	private Map<String, Object> settings;

	public GameConfiguration() {

		this.settings = new HashMap<>();
		settings.put("imposters", 2);
		settings.put("confirmEjections", false);
		settings.put("emergencyMeetings", 2);
		settings.put("emergencyCooldown", 20);
		settings.put("playerSpeed", 1.25);
		settings.put("discussionTime", 30);
		settings.put("votingTime", 60);
		settings.put("crewmateVision", 1.20);
		settings.put("imposterVision", 1.60);
		settings.put("killCooldown", 25);
		settings.put("killDistance", 0); // 0 -> short, 1 -> medium, 2 -> long
		settings.put("visualTasks", true);
		settings.put("commonTasks", 1);
		settings.put("longTasks", 2);
		settings.put("shortTasks", 2);

	}
	
	public boolean setValue(String name, Object value) {
		if (settings.get(name) != null) {
			settings.put(name, value);
			return true;
		} else {
			return false;
		}
	}
	
	@Nullable
	public Object getValue(String name) {
		return settings.get(name);
	}
	
	public Map<String, Object> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}

}
