package com.github.amongus.utility;

import org.bukkit.Bukkit;

import com.github.amongus.packet.PacketHandler;

public class ReflectionUtil {
	public static final String VERSION;

	static {
		VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}

	public static PacketHandler getNewPacketHandlerInstance() {
		try {
			Class<?> clazz = Class.forName("com.gihub.amongus.implementation." + VERSION + ".NMSHandler");
			return (PacketHandler) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}
