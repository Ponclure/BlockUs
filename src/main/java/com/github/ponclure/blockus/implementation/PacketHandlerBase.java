package com.github.ponclure.blockus.implementation;

import org.bukkit.entity.Player;

public interface PacketHandlerBase {

    void sendSabatogePacket(Player p, int warningBlocks);

}
