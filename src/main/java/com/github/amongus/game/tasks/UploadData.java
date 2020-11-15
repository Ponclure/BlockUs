package com.github.amongus.game.tasks;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.amongus.AmongUs;
import com.github.amongus.game.Game;
import com.github.amongus.utility.ItemBuilder;
import com.github.amongus.utility.Utils;

import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;

public class UploadData extends Task implements Listener {

    private final PersistentGui gui;
    private final List<Integer> uncompletedIndex = Arrays.asList(20, 21, 22, 23, 24);
    private final List<Integer> borderIndex = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 19, 25, 28, 29, 30, 31, 32, 33, 34);

    public UploadData(Game game, Location loc) {

        super(game, "Upload Data", loc);
        this.gui = new PersistentGui(6, "Upload Data");

        GuiItem border = new GuiItem(
                new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).withName(ChatColor.DARK_GRAY + "").get());
        gui.setItem(borderIndex, border);

        GuiItem start = new GuiItem(Utils.getSkull(
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZlYjM5ZDcxZWY4ZTZhNDI2NDY1OTMzOTNhNTc1M2NlMjZhMWJlZTI3YTBjYThhMzJjYjYzN2IxZmZhZSJ9fX0=",
                ChatColor.GOLD + "Start Upload"), event -> {
            new BukkitRunnable() {
                double counter = 0;

                @Override
                public void run() {
                    gui.setItem(49, new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).withName(ChatColor.GOLD + "" + counter + "% Completed").get()));
                    if (counter >= 100) {
                        counter = 100;
                        changeMode(counter);
                        cancel();
                    }
                    counter += 17 / 6;
                    changeMode(counter);
                }
            }.runTaskTimer(AmongUs.plugin(), 1, 170);
        });
        gui.setItem(49, start);

        GuiItem uncompleted = new GuiItem(
                new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE).withName(ChatColor.GRAY + "").get());
        gui.setItem(uncompletedIndex, uncompleted);

        setEmpty(gui);

    }

    public void changeMode(double percent) {
        int slots = (int) percent / 20;
        if (percent >= 0 && percent < 50) {
            GuiItem uncompleted = new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).withName(ChatColor.GRAY + "").get());
            gui.setItem(uncompletedIndex, uncompleted);
            for (int i = 0; i < uncompletedIndex.size(); i++) {
                if (i > slots - 1) {
                    break;
                }
                gui.setItem(uncompletedIndex.get(i), uncompleted);
            }
        } else if (percent >= 50 && percent < 100) {
            GuiItem progress = new GuiItem(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).withName(ChatColor.YELLOW + "").get());
            for (int i = 0; i < uncompletedIndex.size(); i++) {
                if (i > slots - 1) {
                    break;
                }
                gui.setItem(uncompletedIndex.get(i), progress);
            }
        } else if (percent >= 100) {
            GuiItem finished = new GuiItem(new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).withName(ChatColor.GREEN + "").get());
            for (int i = 0; i < uncompletedIndex.size(); i++) {
                gui.setItem(uncompletedIndex.get(i), finished);
            }
        }
    }

    @Override
    public void execute(Player p) {
        gui.open(p);
    }

}
