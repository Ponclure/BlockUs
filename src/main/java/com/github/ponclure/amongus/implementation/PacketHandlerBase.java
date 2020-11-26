package com.github.ponclure.amongus.implementation;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface PacketHandlerBase {
    public void sendSabatogePacket(Player p, int warningBlocks);
    public void sendGlowPacket(Player p, Entity glowing);
}
