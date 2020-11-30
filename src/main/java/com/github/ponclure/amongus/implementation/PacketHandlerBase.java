package com.github.ponclure.amongus.implementation;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface PacketHandlerBase {
    void sendSabatogePacket(Player p, int warningBlocks);

    void sendGlowPacket(Player p, Entity glowing);
}
