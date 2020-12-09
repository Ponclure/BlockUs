package com.github.ponclure.blockus.gui.gamesettings;

import com.github.ponclure.blockus.game.GameSettings;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class MiscSettings {

    public final PersistentGui gui;
    private final PersistentGui parent;
    private final GameSettings.Builder builder;

    public MiscSettings(PersistentGui parent, GameSettings.Builder builder) {
        this.gui = new PersistentGui(6, "Miscellaneous Settings");
        this.parent = parent;
        this.builder = builder;
        init();
    }

    private void init() {
        GuiItem impostorCount = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Imposter Count: " + builder.getImpostorCount()));
        GuiItem confirmEjections = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Confirm Ejections: " + builder.isConfirmingEjections()));
        GuiItem velocity = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Player Speed: " + builder.getVelocity()));
        GuiItem increase = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Increase by 1 or Toggle True"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 10:
                    builder.setImpostorVision(builder.getImpostorCount() + 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Imposter Count: " + builder.getImpostorCount())));
                    break;
                case 12:
                    builder.setConfirmingEjections(true);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Confirm Ejections: " + builder.isConfirmingEjections())));
                    break;
                case 14:
                    builder.setVelocity(builder.getVelocity() + 1);
                    gui.setItem(23, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Player Speed: " + builder.getVelocity())));
                    break;
            }
        });
        GuiItem decrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_DOWN.getData(), ChatColor.GOLD + "Decrease by 1 or Toggle False"), event -> {
            switch (event.getSlot()) {
                case 10:
                    builder.setImpostorVision(builder.getImpostorCount() - 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Imposter Count: " + builder.getImpostorCount())));
                    break;
                case 12:
                    builder.setConfirmingEjections(false);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Confirm Ejections: " + builder.isConfirmingEjections())));
                    break;
                case 14:
                    builder.setVelocity(builder.getVelocity() - 1);
                    gui.setItem(23, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Player Speed: " + builder.getVelocity())));
                    break;
            }
        });
        gui.setItem(19, impostorCount);
        gui.setItem(21, confirmEjections);
        gui.setItem(23, velocity);
        gui.setItem(Arrays.asList(10, 12, 14), increase);
        gui.setItem(Arrays.asList(28, 30, 32), decrease);
        gui.setItem(49, new GuiItem(Utils.getSkull(SettingsHeads.BACK.getData(), ChatColor.RED + "Go Back"), event -> {
            parent.open(event.getWhoClicked());
        }));
    }

}
