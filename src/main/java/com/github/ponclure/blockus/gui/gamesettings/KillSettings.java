package com.github.ponclure.blockus.gui.gamesettings;

import com.github.ponclure.blockus.game.GameSettings;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class KillSettings {

    public final PersistentGui gui;
    private final PersistentGui parent;
    private final GameSettings.Builder builder;

    public KillSettings(PersistentGui parent, GameSettings.Builder builder) {
        this.gui = new PersistentGui(6, "Kill Settings");
        this.parent = parent;
        this.builder = builder;
        init();
    }

    private void init() {
        GuiItem killCooldown = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Kill Cooldown: " + builder.getCrewmateVision() + " Second(s)"));
        GuiItem killDistance = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Kill Distance: " + builder.getImpostorVision() + " Block(s)"));
        GuiItem increase = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Increase by 1"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 10:
                    builder.setKillCooldown(builder.getKillCooldown() + 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Kill Cooldown: " + builder.getKillCooldown() + " Second(s)")));
                    break;
                case 12:
                    builder.setKillDistance(builder.getKillDistance() + 1);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Kill Distance: " + builder.getKillDistance() + " Block(s)")));
                    break;
            }
        });
        GuiItem decrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_DOWN.getData(), ChatColor.GOLD + "Decrease by 1"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 28:
                    builder.setKillCooldown(builder.getKillCooldown() - 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Kill Cooldown: " + builder.getKillCooldown() + " Second(s)")));
                    break;
                case 30:
                    builder.setKillDistance(builder.getKillDistance() - 1);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Kill Distance: " + builder.getKillDistance() + " Block(s)")));
                    break;
            }
        });
        gui.setItem(19, killCooldown);
        gui.setItem(21, killDistance);
        gui.setItem(Arrays.asList(10, 12), increase);
        gui.setItem(Arrays.asList(28, 30), decrease);
        gui.setItem(49, new GuiItem(Utils.getSkull(SettingsHeads.BACK.getData(), ChatColor.RED + "Go Back"), event -> {
            parent.open(event.getWhoClicked());
        }));
    }

}
