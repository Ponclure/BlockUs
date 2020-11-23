package com.github.amongus.game.imposter;

import com.github.amongus.AmongUs;
import com.github.amongus.arena.components.Vent;
import com.github.amongus.game.Game;
import com.github.amongus.player.Imposter;
import com.github.amongus.player.Participant;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class PlayerVentManager implements Listener {

    private final Game game;
    private final Set<Imposter> venting;

    public PlayerVentManager(Game game) {
        this.game = game;
        this.venting = new HashSet<>();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Map<UUID, Participant> players = game.getParticipants();
        if (!players.keySet().contains(player.getUniqueId())) {
            return;
        }
        if (!players.get(event.getPlayer()).isImposter()) {
           return;
        }
        Vent[] vents = game.getArena().getVents();
        for (int i = 0; i < vents.length; i++) {
            if (player.getLocation().distance(vents[i].getVent().getLocation()) <= 2.0f) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Press Shift to Vent"));
                break;
            }
        }
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        Map<UUID, Participant> players = game.getParticipants();
        if (!players.keySet().contains(player.getUniqueId())) {
            return;
        }
        if (!players.get(event.getPlayer()).isImposter()) {
            return;
        }
        Vent[] vents = game.getArena().getVents();
        for (int i = 0; i < vents.length; i++) {
            Block vent = vents[i].getVent();
            if (player.getLocation().distance(vent.getLocation()) <= 2.0f) {
                Location ventLocation = vent.getLocation();
                ventLocation.setY(vent.getLocation().getY() - 1);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
                player.teleport(ventLocation);

            }
        }
    }


}
