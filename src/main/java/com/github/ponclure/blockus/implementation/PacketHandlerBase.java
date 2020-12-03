package com.github.ponclure.blockus.implementation;

import org.bukkit.entity.Player;

public interface PacketHandlerBase {

    public void sendSabatogePacket(Player p, int warningBlocks);

    public void sendFogPacket(Player p);

}
