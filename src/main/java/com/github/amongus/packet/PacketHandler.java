package com.github.amongus.packet;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface PacketHandler {
	void display( UUID[] viewers, int map, int mapWidth, int mapHeight, ByteBuffer rgb, int videoWidth, int xOffset, int yOffset );
	void display( UUID[] viewers, int map, int mapWidth, int mapHeight, ByteBuffer rgb, int videoWidth );
	void display( UUID[] viewers, Entity[] entities, int[] data, int width );
	void registerPlayer( Player player );
	void unregisterPlayer( Player player );
	/**
	 * Check if the id provided is a Cartographer2 map.
	 * 
	 * @param id
	 * The id of a Bukkit MapView.
	 * @return
	 * If the MapView with the given id is currently being used for Cartographer2.
	 */
	boolean isMapRegistered( int id );
	
	/**
	 * Unregister a MapView with Cartographer2.
	 * 
	 * @param id
	 * The id of a Bukkit MapView.
	 */
	void unregisterMap( int id );
	
	/**
	 * Register a MapView with Cartographer2.
	 * 
	 * @param id
	 * The id of a Bukkit MapView
	 */
	void registerMap( int id );
	Object onPacketInterceptOut( Player viewer, Object packet );
	Object onPacketInterceptIn( Player viewer, Object packet );
}
