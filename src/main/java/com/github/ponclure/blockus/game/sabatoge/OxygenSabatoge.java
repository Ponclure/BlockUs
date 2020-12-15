package com.github.ponclure.blockus.game.sabatoge;

import com.github.ponclure.blockus.game.Game;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OxygenSabatoge extends Sabatoge {

    private final PersistentGui gui;
    private Map<ArmorStand, Boolean> fixed;
    private final String correct;
    private String current;

    public OxygenSabatoge(Game game, String name, Map<ArmorStand, PersistentGui> fix, int time) {
        super(game, "Oxygen", fix, time);
        this.gui = new PersistentGui(6, "Fix Oxygen");
        this.fixed = new HashMap<>();
        for (ArmorStand as : fix.keySet()) {
            fixed.put(as, false);
        }
        this.correct = generateId();
        this.current = "";
    }

    private void init() {
        GuiItem currentId = new GuiItem(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.GOLD + current).build());
        List<Integer> index = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 0; i < 10; i++) {
            int numeral = i;
            GuiItem keypad = new GuiItem(ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "" + numeral).build(), event -> {
                event.setCancelled(true);
                current += numeral;
                gui.setItem(26, new GuiItem(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.GOLD + current).build()));
            });
            gui.setItem(index, keypad);
        }
        GuiItem cancel = new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.RED + "Cancel").build(), event -> {
            event.setCancelled(true);
            gui.close(event.getWhoClicked());
            current = "";
        });
        GuiItem check = new GuiItem(ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).setName(ChatColor.RED + "Enter").build(), event -> {
            event.setCancelled(true);
            if (current.equals(correct)) {
                HumanEntity he = event.getWhoClicked();
                gui.close(he);
                ((Player) he).sendTitle(ChatColor.GREEN + "Fixed this part of Oxygen!", "", 40, 40, 40);
                if (sabatogeFixed()) {
                    callComplete();
                }
            } else {
                HumanEntity he = event.getWhoClicked();
                gui.close(he);
                ((Player) he).sendTitle(ChatColor.RED + "Failed to fix this part of Oxygen!", "", 40, 40, 40);
                current = "";
            }
        });
    }

    private boolean sabatogeFixed() {
        return fixed.values().stream().allMatch(x -> true);
    }

    private String generateId() {
        String str = "";
        Random rand = new Random();
        while (str.length() != 5) {
            str += rand.nextInt(10);
        }
        return str;
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }
}
