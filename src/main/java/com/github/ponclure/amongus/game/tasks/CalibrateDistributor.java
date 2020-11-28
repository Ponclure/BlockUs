package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalibrateDistributor extends Task {

    private final PersistentGui gui;
    private final List<List<Integer>> slots;
    private final List<Integer> click;
    private Player player;
    private int dial;

    public CalibrateDistributor(Game game, Location loc, Participant p) {
        super(game, "Callibrate Distrubutor", loc, p);
        this.gui = new PersistentGui(5, "Callibrate Distrubutor");
        this.slots = new ArrayList<>();
        slots.add(Arrays.asList(1, 11, 19, 9));
        slots.add(Arrays.asList(4, 12, 22, 14));
        slots.add(Arrays.asList(7, 17, 25, 15));
        this.click = new ArrayList<>();
        click.add(28);
        click.add(31);
        click.add(34);
        init();
    }

    private void init() {
        for (List<Integer> each : slots) {
            gui.setItem(each, new GuiItem(ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName(ChatColor.BLUE + "").build()));
        }
        gui.setItem(click, new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.BLUE + "Click").build()));
        setUncompleted(1);
        setUncompleted(2);
        GuiItem selected = new GuiItem(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.GREEN + "Click at Bottom Slot").build(), event -> {
            handleClick((Player)event.getWhoClicked(), event.getSlot());
        });
        GuiItem empty = new GuiItem(ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName(ChatColor.BLUE + "").build());
        new BukkitRunnable() {
            private int slot;
            public void run() {
                if (gui.getInventory().getViewers().size() == 0) {
                    cancel();
                } else {
                    if (slot - 1 == -1) {
                        slot = 4;
                    }
                    gui.setItem(slots.get(dial).get(slot - 1), empty);
                    gui.setItem(slots.get(dial).get(slot), selected);
                    slot++;
                }
            }
        }.runTaskTimer(AmongUsPlugin.getAmongUs().plugin(), 10l, Long.MAX_VALUE);
        setEmpty(gui);
    }

    private void handleClick(Player p, int slot) {
        if (!click.contains(slot)) {
            return;
        }
        switch (slot) {
            case 28:
                if (gui.getGuiItem(19).getItemStack().getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                    setCompleted(dial);
                    dial++;
                    return;
                }
            case 31:
                if (gui.getGuiItem(22).getItemStack().getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                    setCompleted(dial);
                    dial++;
                    return;
                }
            case 34:
                if (gui.getGuiItem(25).getItemStack().getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                    setCompleted(dial);
                    callComplete(p, gui);
                    return;
                }
        }
        setWrong();
    }

    private void setUncompleted(int dialIndex) {
        GuiItem uncomplete = new GuiItem(ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).setName(ChatColor.RED + "Complete the One Before First").build());
        for (int slot : slots.get(dialIndex)) {
            gui.setItem(slot, uncomplete);
        }
    }

    private void setCompleted(int dialIndex) {
        GuiItem complete = new GuiItem(ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).setName(ChatColor.GREEN + "Completed!").build());
        for (int slot : slots.get(dialIndex)) {
            gui.setItem(slot, complete);
        }
    }

    private void setWrong() {
        GuiItem wrong = new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.RED + "Oops!").build());
        for (int slot : slots.get(dial)) {
            gui.setItem(slot, wrong);
        }
        dial = 0;
        setUncompleted(1);
        setUncompleted(2);
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        player = e.getPlayer();
        gui.open(player);
    }
}
