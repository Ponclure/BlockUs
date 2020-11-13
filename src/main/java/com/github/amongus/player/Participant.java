package com.github.amongus.player;

import java.util.UUID;

public class Participant {

	private UUID uuid;
	
	private boolean isDead;
	private boolean isDisconnected;

	public Participant(UUID player) {
		this.uuid = player;
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

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public boolean isDisconnected() {
		return isDisconnected;
	}

	public void setDisconnected(boolean disconnected) {
		isDisconnected = disconnected;
	}
}
