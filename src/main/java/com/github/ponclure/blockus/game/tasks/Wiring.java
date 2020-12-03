package com.github.ponclure.blockus.game.tasks;

import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wiring extends Task implements Listener {

    private final PersistentGui gui;
    private Color lastColor;
    private int lastSlot;

    public Wiring(Game game, Location loc, Participant p) {
        super(game, "Fix Wiring", loc, p);
        this.gui = new PersistentGui(4, "Fix Wiring");
        init();
        setEmpty(gui);
    }

    private void init() {
        List<GuiItem> stacks = generateWiring();
        gui.setItem(2, stacks.get(0));
        gui.setItem(11, stacks.get(1));
        gui.setItem(20, stacks.get(2));
        gui.setItem(29, stacks.get(3));

        Collections.shuffle(stacks);
        gui.setItem(6, stacks.get(0));
        gui.setItem(15, stacks.get(1));
        gui.setItem(24, stacks.get(2));
        gui.setItem(33, stacks.get(3));

        gui.setDefaultClickAction(event -> {
            event.setCancelled(true);
            Color nextColor = null;
            switch (event.getCurrentItem().getType()) {
                case RED_STAINED_GLASS_PANE:
                    nextColor = Color.RED;
                    break;
                case BLUE_STAINED_GLASS_PANE:
                    nextColor = Color.BLUE;
                    break;
                case YELLOW_STAINED_GLASS_PANE:
                    nextColor = Color.YELLOW;
                    break;
                case PINK_STAINED_GLASS_PANE:
                    nextColor = Color.PINK;
                    break;
                default:
                    break;
            }
            if (lastColor == null || lastColor != nextColor) {
                switch (event.getCurrentItem().getType()) {
                    case RED_STAINED_GLASS_PANE:
                        lastColor = Color.RED;
                        lastSlot = event.getSlot();
                        dragWire(Color.RED);
                        break;
                    case BLUE_STAINED_GLASS_PANE:
                        lastColor = Color.BLUE;
                        lastSlot = event.getSlot();
                        dragWire(Color.BLUE);
                        break;
                    case YELLOW_STAINED_GLASS_PANE:
                        lastColor = Color.YELLOW;
                        lastSlot = event.getSlot();
                        dragWire(Color.YELLOW);
                        break;
                    case PINK_STAINED_GLASS_PANE:
                        lastColor = Color.PINK;
                        lastSlot = event.getSlot();
                        dragWire(Color.PINK);
                        break;
                    default:
                        break;
                }
            } else if (lastColor == nextColor) {
                ItemStack lime = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
                ItemMeta limeMeta = lime.getItemMeta();
                limeMeta.setDisplayName(ChatColor.GREEN + "Wire Connected");
                lime.setItemMeta(limeMeta);
                event.getInventory().setItem(event.getSlot(), lime);
                event.getInventory().setItem(lastSlot, lime);
                lastColor = null;
                lastSlot = event.getSlot();
                if (allComplete(event.getInventory())) {
                    callComplete(Bukkit.getPlayer(event.getWhoClicked().getName()), gui);
                }
            }
        });
    }

    private List<GuiItem> generateWiring() {
        List<GuiItem> stacks = new ArrayList<>();
        stacks.add(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.DARK_RED + "Red Wire").asGuiItem());
        stacks.add(ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName(ChatColor.DARK_BLUE + "Blue Wire").asGuiItem());
        stacks.add(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.YELLOW + "Yellow Wire").asGuiItem());
        stacks.add(ItemBuilder.from(Material.PINK_STAINED_GLASS_PANE).setName(ChatColor.LIGHT_PURPLE + "Pink Wire").asGuiItem());
        Collections.shuffle(stacks);
        return stacks;
    }

    private boolean allComplete(Inventory inv) {
        Material m = Material.LIME_STAINED_GLASS_PANE;
        return inv.getItem(2).getType() == m && inv.getItem(11).getType() == m && inv.getItem(20).getType() == m
                && inv.getItem(29).getType() == m && inv.getItem(6).getType() == m && inv.getItem(15).getType() == m
                && inv.getItem(24).getType() == m && inv.getItem(33).getType() == m;
    }

    private void dragWire(Color c) {
        List<Integer> index = Arrays.asList(4, 13, 22, 31);
        switch (c) {
            case RED:
                gui.setItem(index, ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.DARK_RED + "Select Second Slot").asGuiItem());
                break;
            case BLUE:
                gui.setItem(index, ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName(ChatColor.DARK_BLUE + "Select Second Slot").asGuiItem());
                break;
            case YELLOW:
                gui.setItem(index, ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.YELLOW + "Select Second Slot").asGuiItem());
                break;
            case PINK:
                gui.setItem(index, ItemBuilder.from(Material.PINK_STAINED_GLASS_PANE).setName(ChatColor.LIGHT_PURPLE + "Select Second Slot").asGuiItem());
                break;
        }
    }

    private enum Color {
        RED, BLUE, YELLOW, PINK
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }

}
