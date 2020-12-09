package com.github.ponclure.blockus.gui.gamesettings;

import com.github.ponclure.blockus.game.GameSettings;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class VisionSettings {

    public final PersistentGui gui;
    private final PersistentGui parent;
    private final GameSettings.Builder builder;

    public VisionSettings(PersistentGui parent, GameSettings.Builder builder) {
        this.gui = new PersistentGui(6, "Vision Settings");
        this.parent = parent;
        this.builder = builder;
        init();
    }

    private void init() {
        GuiItem crewmateVision = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Crewmate Vision: " + builder.getCrewmateVision() + " Blocks"));
        GuiItem imposterVision = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Imposter Vision" + builder.getImpostorVision() + " Blocks"));
        GuiItem increase = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Increase by 1"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 10:
                    builder.setCrewmateVision(builder.getCrewmateVision() + 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Crewmate Vision: " + builder.getCrewmateVision() + " Blocks")));
                    break;
                case 12:
                    builder.setImpostorVision(builder.getImpostorVision() + 1);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Imposter Vision" + builder.getImpostorVision() + " Blocks")));
                    break;
            }
        });
        GuiItem decrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_DOWN.getData(), ChatColor.GOLD + "Decrease by 1"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 28:
                    builder.setCrewmateVision(builder.getCrewmateVision() - 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Crewmate Vision: " + builder.getCrewmateVision() + " Blocks")));
                    break;
                case 30:
                    builder.setImpostorVision(builder.getImpostorVision() - 1);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Imposter Vision" + builder.getImpostorVision() + " Blocks")));
                    break;
            }
        });
        gui.setItem(19, crewmateVision);
        gui.setItem(21, imposterVision);
        gui.setItem(Arrays.asList(10, 12), increase);
        gui.setItem(Arrays.asList(28, 30), decrease);
        gui.setItem(49, new GuiItem(Utils.getSkull(SettingsHeads.BACK.getData(), ChatColor.RED + "Go Back"), event -> {
            parent.open(event.getWhoClicked());
        }));
    }

}
