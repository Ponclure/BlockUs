<<<<<<< HEAD
package com.github.amongus.reflection;

import org.bukkit.Bukkit;

import com.github.amongus.packet.PacketHandler;

public class NMSVersionHandler {
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
=======
package com.github.amongus.reflection;

import org.bukkit.Bukkit;

import com.github.amongus.packet.PacketHandler;

public class NMSVersionHandler {
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
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
