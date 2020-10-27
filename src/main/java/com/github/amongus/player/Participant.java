<<<<<<< HEAD
package com.github.amongus.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Participant {
	
	private String nick;
	private UUID uuid;
	
	private boolean dead;
	
	public Participant(UUID player, String name) {
		this.uuid = player;
		this.nick = name;
	}
	
	public Participant(UUID uuid) {
		this(uuid, Bukkit.getPlayer(uuid).getDisplayName());
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}

}
=======
package com.github.amongus.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Participant {
	
	private String nick;
	private UUID uuid;
	
	private boolean dead;
	
	public Participant(UUID player, String name) {
		this.uuid = player;
		this.nick = name;
	}
	
	public Participant(UUID uuid) {
		this(uuid, Bukkit.getPlayer(uuid).getDisplayName());
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}

}
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
