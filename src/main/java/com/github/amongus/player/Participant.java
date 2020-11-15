package com.github.amongus.player;

import org.bukkit.Bukkit;

import java.util.UUID;

public class Participant {

	private final UUID uuid;
	private final String nick;
	private final PlayerColor color;
	
	private boolean isDead;
	private boolean isDisconnected;

	public Participant(UUID player, PlayerColor color) {
		this.uuid = player;
		this.nick = Bukkit.getPlayer(uuid).getName();
		this.color = color;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean dead) {
		isDead = dead;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getNick() { return nick; }

	public boolean isDisconnected() {
		return isDisconnected;
	}

	public void setDisconnected(boolean disconnected) {
		isDisconnected = disconnected;
	}
	
	public boolean isImposter() {
		return (this instanceof Imposter);
	}

	public PlayerColor getColor() { return color; }

	public enum PlayerColor {
		RED, BLUE, GREEN, YELLOW, ORANGE, BLACK, WHITE, PURPLE, CYAN, BROWN, LIME, FORTEGREEN;
	}

}
