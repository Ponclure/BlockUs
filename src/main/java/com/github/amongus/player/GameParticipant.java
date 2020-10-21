package com.github.amongus.player;

import java.util.UUID;

import org.bukkit.Bukkit;

public class GameParticipant {

	private final UUID player;
	
	private String nick;
	
	private boolean dead;
	
	public GameParticipant(UUID p, String name) {
		this.player = p;
		this.nick = name;
		this.dead = false;
	}
	
	public GameParticipant(UUID p) {
		this.player = p;
		this.nick = Bukkit.getPlayer(p).getDisplayName();
		this.dead = false;
	}
	
	public UUID getPlayer() {
		return player;
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
