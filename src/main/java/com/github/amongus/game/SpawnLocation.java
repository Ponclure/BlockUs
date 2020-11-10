package com.github.amongus.game;

import org.bukkit.util.Vector;

public class SpawnLocation {

	public Vector[] getSpawnLocations(MapType type) {
		switch (type) {
			case Skeld:
				return initSpawns(new Vector(-255.5, 76.5, -271), new Vector(-255.5, 76.5, -273),
						new Vector(-255.5, 76.5, -274), new Vector(-257.5, 76.5, -271), new Vector(-258.5, 76.5, -271),
						new Vector(-260.5, 76.5, -273), new Vector(-260.5, 76.5, -274), new Vector(-250.5, 76.5, -276),
						new Vector(-258.5, 76.5, -276), new Vector(-257.5, 76.5, -276));
			case Mirahq:
				return initSpawns(new Vector(0, 0, 0));
			case Polus:
				return initSpawns(new Vector(0, 0, 0));
			default:
				return null;
		}
	}

	public Vector[] initSpawns(Vector... array) {
		return array;
	}

	public enum MapType {
		Skeld, Mirahq, Polus;
	}

}
