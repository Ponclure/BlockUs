package com.github.amongus.arena;

import org.bukkit.util.Vector;

public class Room {
	
	// Used to store the exact coordinates of a Room (which may be an irregular shape)
	
	private final String name;
	private final Vector middle;
	
	public Room(String name, Vector vec) {
		this.name = name;
		this.middle = vec;
	}	

	public String getName() {
		return name;
	}

	public Vector getMiddle() {
		return middle;
	}

}
