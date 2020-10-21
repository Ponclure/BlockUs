package com.github.amongus.player;

import java.util.UUID;

import org.bukkit.Bukkit;

public class Participant {
	
	private String nick;
	
	private boolean dead;
	
	public Participant(String name) {
		this.nick = name;
		this.dead = false;
	}
	
	public Participant(UUID uuid) {
		this(Bukkit.getPlayer(uuid).getDisplayName());
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

}
