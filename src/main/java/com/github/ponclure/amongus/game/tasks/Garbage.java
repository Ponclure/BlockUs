package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

public class Garbage extends Task {

    private final Participant participant;
    private int number;
    private int internal;

    public Garbage(Game game, Location loc, Participant p) {
        super(game, "", loc, p);
        this.participant = p;
    }

    public void generateRandomItems() {
        PlayerInventory inv = Bukkit.getPlayer(participant.getUuid()).getInventory();
        Material[] all = Material.values();
        Set<Material> notInclude = EnumSet.of(Material.BARRIER,
                Material.STRUCTURE_BLOCK, Material.STRUCTURE_VOID,
                Material.COMMAND_BLOCK, Material.COMMAND_BLOCK_MINECART,
                Material.CHAIN_COMMAND_BLOCK, Material.REPEATING_COMMAND_BLOCK);
        Random rand = new Random();
        number = rand.nextInt(16);
        for (int i = 0; i < number; i++) {
            int index = rand.nextInt(all.length);
            while (!notInclude.contains(all[index])) {
                index = rand.nextInt(all.length);
            }
            inv.addItem(new ItemStack(all[index]));
        }
    }

    // Just in case
    public void clearInventory() {
        PlayerInventory inv = Bukkit.getPlayer(participant.getUuid()).getInventory();
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, new ItemStack(Material.AIR));
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (event.getPlayer().getUniqueId() == participant.getUuid()) {
            event.setCancelled(true);
            if (internal == number) {
                callComplete(event.getPlayer(), null);
            } else {
                internal++;
            }
        }
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        clearInventory();
        generateRandomItems();
    }
}
