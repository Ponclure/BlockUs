package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import com.github.ponclure.amongus.utility.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

public class UploadData extends Task implements Listener {

    private final PersistentGui gui;
    private final List<Integer> uncompletedIndex = Arrays.asList(20, 21, 22, 23, 24);
    private final List<Integer> borderIndex = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 19, 25, 28, 29, 30, 31, 32, 33, 34);

    public UploadData(Game game, Location loc, Participant p) {
        super(game, "Upload Data", loc, p);
        this.gui = new PersistentGui(6, "Upload Data");
        init();
        setEmpty(gui);
    }

    private void init() {
        GuiItem border = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).setName(ChatColor.DARK_GRAY + "").asGuiItem();
        gui.setItem(borderIndex, border);
        GuiItem start = new GuiItem(Utils.getSkull(
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZlYjM5ZDcxZWY4ZTZhNDI2NDY1OTMzOTNhNTc1M2NlMjZhMWJlZTI3YTBjYThhMzJjYjYzN2IxZmZhZSJ9fX0=",
                ChatColor.GOLD + "Start Upload"), event -> {
            event.setCancelled(true);
            new BukkitRunnable() {
                double counter = 0;

                @Override
                public void run() {
                    gui.setItem(49, ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "" + counter + "% Completed").asGuiItem());
                    if (counter >= 100) {
                        counter = 100;
                        changeMode(counter);
                        cancel();
                    }
                    counter += 17 / 6;
                    changeMode(counter);
                }
            }.runTaskTimer(AmongUsPlugin.getAmongUs().plugin(), 1, 170);
        });
        gui.setItem(49, start);
        GuiItem uncompleted = ItemBuilder.from(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(ChatColor.GRAY + "").asGuiItem();
        gui.setItem(uncompletedIndex, uncompleted);
    }

    private void changeMode(double percent) {
        int slots = (int) percent / 20;
        if (percent >= 0 && percent < 50) {
            GuiItem uncompleted = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).setName(ChatColor.GRAY + "").asGuiItem();
            gui.setItem(uncompletedIndex, uncompleted);
            for (int i = 0; i < uncompletedIndex.size(); i++) {
                if (i > slots - 1) {
                    break;
                }
                gui.setItem(uncompletedIndex.get(i), uncompleted);
            }
        } else if (percent >= 50 && percent < 100) {
            GuiItem progress = ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.YELLOW + "").asGuiItem();
            for (int i = 0; i < uncompletedIndex.size(); i++) {
                if (i > slots - 1) {
                    break;
                }
                gui.setItem(uncompletedIndex.get(i), progress);
            }
        } else if (percent >= 100) {
            GuiItem finished = ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).setName(ChatColor.GREEN + "").asGuiItem();
            for (int i = 0; i < uncompletedIndex.size(); i++) {
                gui.setItem(uncompletedIndex.get(i), finished);
            }
        }
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }

}
