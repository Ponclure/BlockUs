package com.github.amongus.packet;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class DummyPacketHandler implements PacketHandler {
	@Override
	public void display( UUID[] viewers, int map, int mapWidth, int mapHeight, ByteBuffer rgb, int videoWidth, int xOffset, int yOffset ) {}
	
	@Override
	public void display( UUID[] viewers, int map, int mapWidth, int mapHeight, ByteBuffer rgb, int videoWidth ) {}
	
	@Override
	public void display( UUID[] viewers, Entity[] entities, int[] data, int width ) {}
	
	@Override
	public void registerPlayer( Player player ) {}
	
	@Override
	public void unregisterPlayer( Player player ) {}
	
	@Override
	public boolean isMapRegistered( int id ) {
		return false;
	}

	@Override
	public void unregisterMap(int id) {}

	@Override
	public void registerMap(int id) {}

	@Override
	public Object onPacketInterceptOut( Player viewer, Object packet ) {
		return null;
	}

	@Override
	public Object onPacketInterceptIn( Player viewer, Object packet ) {
		return null;
	}
}
