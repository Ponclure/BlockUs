package com.github.amongus.game.sabatoge;

import com.github.amongus.AmongUs;
import com.github.amongus.arena.Doors;
import com.github.amongus.game.Game;
import com.github.amongus.player.Imposter;
import com.github.amongus.utility.ItemBuilder;
import com.github.amongus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.util.BoundingBox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SabatogeMenu {

    private final Game game;
    private final PersistentGui gui;
    private final Imposter imposter;

    private Map<Doors, Boolean> canCloseDoor;
    private boolean canSabatogeMain;

    public SabatogeMenu(Game game, Imposter imp) {
        this.game = game;
        this.gui = new PersistentGui(5, "Sabatoge Menu");
        this.imposter = imp;
        this.canCloseDoor = new HashMap<>();
        this.canSabatogeMain = false;
    }

    private Doors get = null;
    public void initDoors() {
        List<Integer> doorSlots = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16);
        Doors[] doors = game.getArena().getDoors();
        int index = 0;
        for (Doors door : doors) {
            GuiItem item = new GuiItem(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).withName(ChatColor.RED + door.getDoorName()).get(), event -> {
                Doors[] allDoors = game.getArena().getDoors();
                for (Doors d : allDoors) {
                    if (gui.getGuiItem(event.getSlot()).getItemStack().getItemMeta().getDisplayName().contains(d.getDoorName())) {
                        get = d;
                    }
                }
                if (canCloseDoor.get(get)) {
                    get.shutDoors();
                    canCloseDoor.put(get, false);
                    AmongUs.plugin().getServer().getScheduler().scheduleSyncDelayedTask(AmongUs.plugin(), new Runnable() {
                        public void run() {
                            canCloseDoor.put(get, true);
                        }
                    }, 100);
                }
            });
            gui.setItem(doorSlots.get(index), item);
        }
    }

    public void initMain() {
        // TODO: Finish Sabatoge GUI
        List<Integer> doorSlots = Arrays.asList(18, 19, 20, 21, 22, 23);
    }

    private enum SabatogeType {

        OXYGEN(30, false), REACTOR_MELTDOWN(30, false),
        COMMUNICATIONS(30, false), LIGHTS(30, false),
        DOORS(10, true);

        private final int cooldown;
        private final boolean canUseOther;

        private SabatogeType(int seconds, boolean canUseOther) {
            this.cooldown = seconds * 20;
            this.canUseOther = canUseOther;
        }

        public int getCooldown() {
            return cooldown;
        }

        public boolean isCanUseOther() {
            return canUseOther;
        }

    }

}


