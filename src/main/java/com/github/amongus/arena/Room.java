package com.github.amongus.arena;

import org.bukkit.util.Vector;

public class Room {
	
	// Used to store the exact coordinates of a Room (which may be an irregular shape)
	
	private final String name;
	private final Vector bottom; // bottom left corner
	private final Vector top; // top right corner
	
	public Room(String name, Vector... vec) {
		this.name = name;
		this.bottom = vec[0];
		this.top = vec[1];
	}	
	
	public Vector getBottom() {
		return bottom;
	}

	public Vector getTop() {
		return top;
	}

	public String getName() {
		return name;
	}

}
