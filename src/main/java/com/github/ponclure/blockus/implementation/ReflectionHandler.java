package com.github.ponclure.blockus.implementation;

import org.bukkit.Bukkit;

public class ReflectionHandler {
    public static final String VERSION;

    static {
        VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public static PacketHandlerBase getNewPacketHandlerInstance() {
        try {
            Class<?> clazz = Class.forName("com.github.ponclure.blockus.implementation" + VERSION + ".PacketHandler");
            return (PacketHandlerBase) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
