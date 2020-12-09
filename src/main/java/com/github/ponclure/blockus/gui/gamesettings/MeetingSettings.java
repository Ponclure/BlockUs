package com.github.ponclure.blockus.gui.gamesettings;

import com.github.ponclure.blockus.game.GameSettings;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;

import java.util.Arrays;

public class MeetingSettings {

    public final PersistentGui gui;
    private final PersistentGui parent;
    private final GameSettings.Builder builder;

    public MeetingSettings(PersistentGui parent, GameSettings.Builder builder) {
        this.gui = new PersistentGui(6, "Meeting Settings");
        this.parent = parent;
        this.builder = builder;
        init();
    }

    private void init() {
        GuiItem emergencyMeetingCount = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Emergency Meeting Count: " + builder.getEmergencyMeetingCount()));
        GuiItem emergencyMeetingCooldown = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Emergency Meeting Cooldown: " + builder.getEmergencyMeetingCooldown() + " Seconds"));
        GuiItem discussionTime = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Discussion Time: " + builder.getDiscussionTime() + " Seconds"));
        GuiItem votingTime = new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Voting Time: " + builder.getVotingTime() + " Seconds"));
        GuiItem increase = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Increase by 10"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 12:
                    builder.setEmergencyMeetingCooldown(builder.getEmergencyMeetingCooldown() + 200);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Emergency Meeting Cooldown: " + builder.getEmergencyMeetingCooldown() + " Seconds")));
                    break;
                case 14:
                    builder.setDiscussionTime(builder.getDiscussionTime() + 200);
                    gui.setItem(23, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Discussion Time: " + builder.getDiscussionTime() + " Seconds")));
                    break;
                case 16:
                    builder.setVotingTime(builder.getVotingTime() + 200);
                    gui.setItem(25, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Voting Time: " + builder.getVotingTime() + " Seconds")));
                    break;
            }
        });
        GuiItem decrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_DOWN.getData(), ChatColor.GOLD + "Decrease by 10"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 30:
                    builder.setEmergencyMeetingCooldown(builder.getEmergencyMeetingCooldown() - 10);
                    gui.setItem(21, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Emergency Meeting Cooldown: " + builder.getEmergencyMeetingCooldown() + " Seconds")));
                    break;
                case 32:
                    builder.setDiscussionTime(builder.getDiscussionTime() - 10);
                    gui.setItem(23, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Discussion Time: " + builder.getDiscussionTime() + " Seconds")));
                    break;
                case 34:
                    builder.setVotingTime(builder.getVotingTime() - 10);
                    gui.setItem(25, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Voting Time: " + builder.getVotingTime() + " Seconds")));
                    break;
            }
        });
        GuiItem emergencyMeetingCountIncrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Increase by 1"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 10:
                    builder.setEmergencyMeetingCount(builder.getEmergencyMeetingCount() + 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Emergency Meeting Count: " + builder.getEmergencyMeetingCount())));
                    break;
            }
        });
        GuiItem emergencyMeetingCountDecrease = new GuiItem(Utils.getSkull(SettingsHeads.ARROW_UP.getData(), ChatColor.GOLD + "Decrease by 1"), event -> {
            event.setCancelled(true);
            switch (event.getSlot()) {
                case 28:
                    builder.setEmergencyMeetingCount(builder.getEmergencyMeetingCount() - 1);
                    gui.setItem(19, new GuiItem(Utils.getSkull(SettingsHeads.SETTING.getData(), ChatColor.GOLD + "Emergency Meeting Count: " + builder.getEmergencyMeetingCount())));
                    break;
            }
        });
        gui.setItem(19, emergencyMeetingCount);
        gui.setItem(21, emergencyMeetingCooldown);
        gui.setItem(23, discussionTime);
        gui.setItem(25, votingTime);
        gui.setItem(10, emergencyMeetingCountIncrease);
        gui.setItem(28, emergencyMeetingCountIncrease);
        gui.setItem(Arrays.asList(12, 14, 16), increase);
        gui.setItem(Arrays.asList(30, 32, 34), decrease);
        gui.setItem(49, new GuiItem(Utils.getSkull(SettingsHeads.BACK.getData(), ChatColor.RED + "Go Back"), event -> {
            parent.open(event.getWhoClicked());
        }));
    }

}
