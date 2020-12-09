package com.github.ponclure.blockus.gui.gamesettings;

import com.github.ponclure.blockus.game.GameSettings;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class TaskSettings {

    public final PersistentGui gui;
    private final PersistentGui parent;
    private final GameSettings.Builder builder;

    public TaskSettings(PersistentGui parent, GameSettings.Builder builder) {
        this.gui = new PersistentGui(6, "Task Settings");
        this.parent = parent;
        this.builder = builder;
        init();
    }

    private void init() {
        GuiItem shortTaskCount = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Short Task Count: " + builder.getShortTaskCount()));
        GuiItem longTaskCount = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Long Task Count: " + builder.getLongTaskCount()));
        GuiItem commonTaskCount = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Common Task Count: " + builder.getCommonTaskCount()));
        GuiItem increase = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Increase by 10"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 10:
                    builder.setShortTaskCount(builder.getShortTaskCount() + 10);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Short Task Count: " + builder.getShortTaskCount())));
                    break;
                case 12:
                    builder.setLongTaskCount(builder.getLongTaskCount() + 10);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Long Task Count: " + builder.getLongTaskCount())));
                    break;
                case 14:
                    builder.setCommonTaskCount(builder.getCommonTaskCount() + 10);
                    gui.setItem(23, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Common Task Count: " + builder.getCommonTaskCount())));
                    break;
            }
        });
        GuiItem decrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_DOWN.getData(), ChatColor.GOLD + "Decrease by 10"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 28:
                    builder.setShortTaskCount(builder.getShortTaskCount() - 10);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Short Task Count: " + builder.getShortTaskCount())));
                    break;
                case 30:
                    builder.setLongTaskCount(builder.getLongTaskCount() - 10);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Long Task Count: " + builder.getLongTaskCount())));
                    break;
                case 32:
                    builder.setCommonTaskCount(builder.getCommonTaskCount() - 10);
                    gui.setItem(23, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Common Task Count: " + builder.getCommonTaskCount())));
                    break;
            }
        });
        gui.setItem(19, shortTaskCount);
        gui.setItem(21, longTaskCount);
        gui.setItem(23, commonTaskCount);
        gui.setItem(Arrays.asList(10, 12, 14), increase);
        gui.setItem(Arrays.asList(28, 30, 32), decrease);
        gui.setItem(49, new GuiItem(Utils.getSkull(SettingsHeads.BACK.getData(), ChatColor.RED + "Go Back"), event -> {
            parent.open(event.getWhoClicked());
        }));
    }

}
