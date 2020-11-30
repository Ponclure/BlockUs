package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InspectSample extends Task {

    private final PersistentGui gui;
    private boolean finished;

    public InspectSample(Game game, Location loc, Participant holder) {
        super(game, "Inspect Sample", loc, holder);
        this.gui = new PersistentGui(6, "Inspect Sample");
        init();
        setEmpty(gui);
    }

    private void init() {
        int[][] slots = new int[][]{new int[]{10, 19}, new int[]{12, 21}, new int[]{14, 23}, new int[]{16, 25}};
        GuiItem capsule = new GuiItem(ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName(ChatColor.BLUE + "").build());
        GuiItem filled = new GuiItem(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.YELLOW + "").build());
        GuiItem button = new GuiItem(ItemBuilder.from(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "Press to Start").build(), event -> {
            for (int[] capsuleSlots : slots) {
                for (int slot : capsuleSlots) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            gui.setItem(slot, filled);
                        }
                    }.runTaskTimer(AmongUsPlugin.getAmongUs().plugin(), 0L, 10L);
                }
            }
            gui.removeItem(40);
            GuiItem after = new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "Wait 30 Seconds").build(), click -> {
                if (finished) {
                    callComplete((Player) event.getWhoClicked(), gui);
                }
            });

            Bukkit.getScheduler().scheduleSyncDelayedTask(AmongUsPlugin.getAmongUs().plugin(), new Runnable() {
                public void run() {
                    finished = true;
                }
            }, 600L);
        });

        for (int[] capsuleSlots : slots) {
            for (int slot : capsuleSlots) {
                gui.setItem(slot, capsule);
            }
        }

        gui.setItem(40, button);

    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }
}
