package com.github.ponclure.blockus.game.tasks;

import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OxygenFilter extends Task {

    private final PersistentGui gui;

    public OxygenFilter(Game game, Location loc, Participant p) {
        super(game, "Oxygen Filter", loc, p);
        this.gui = new PersistentGui(6, "Oxygen Filter");
        init();
    }

    private void init() {
        GuiItem garbage = new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.RED + "Garbage Disposal").build(), event -> {
            if (event.getCursor() == null) {
                return;
            }
            event.setCancelled(true);
            event.getWhoClicked().setItemOnCursor(null);
            if (allEmpty()) {
                callComplete((Player) event.getWhoClicked(), gui);
            }
        });
        Random rand = new Random();
        int number = rand.nextInt(54);
        for (int i = 0; i < number; i++) {
            boolean type = rand.nextBoolean();
            int amount = rand.nextInt(65);
            if (true) {
                gui.setItem(number, new GuiItem(dustItemStack(amount)));
            } else {
                gui.setItem(number, new GuiItem(webItemStack(amount)));
            }
        }
    }

    private boolean allEmpty() {
        for (ItemStack item : gui.getInventory()) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }

    private ItemStack dustItemStack(int amount) {
        ItemStack dust = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = dust.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Dust");
        meta.setLore(selectRandom(Arrays.asList("Ewww Stinky", "Dirty Mess", "Dusty!")));
        dust.setItemMeta(meta);
        dust.setAmount(amount);
        return dust;
    }

    private ItemStack webItemStack(int amount) {
        ItemStack web = new ItemStack(Material.COBWEB);
        ItemMeta meta = web.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Cobweb");
        meta.setLore(selectRandom(Arrays.asList("Ewww Sticky", "Spider?", "Dirty!")));
        web.setItemMeta(meta);
        web.setAmount(amount);
        return web;
    }

    private List<String> selectRandom(List<String> pick) {
        String str = pick.get(new Random().nextInt(pick.size()));
        return Arrays.asList(str);
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }
}
