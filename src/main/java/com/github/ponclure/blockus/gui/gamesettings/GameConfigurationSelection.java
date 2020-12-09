package com.github.ponclure.blockus.gui.gamesettings;

import com.github.ponclure.blockus.game.GameSettings;
import com.github.ponclure.blockus.game.Lobby;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GameConfigurationSelection {

    private final PersistentGui gui;
    private final Lobby lobby;
    private final GameSettings.Builder builder;

    public GameConfigurationSelection(Lobby lobby) {
        this.gui = new PersistentGui(4, "Game Settings");
        this.lobby = lobby;
        this.builder = new GameSettings.Builder();
        init();
    }

    private void init() {
        GuiItem taskSettings = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2UyYTUzMGY0MjcyNmZhN2EzMWVmYWI4ZTQzZGFkZWUxODg5MzdjZjgyNGFmODhlYThlNGM5M2E0OWM1NzI5NCJ9fX0=", ChatColor.GOLD + "Tasks"), event -> new TaskSettings(gui, builder).gui.open(event.getWhoClicked()));
        GuiItem meetingSettings = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGUyYzE4YWIzNTk0OWJmOWY5ZTdkNmE2OWI4ODVjY2Q4Y2MyZWZiOTQ3NTk0NmQ3ZDNmYjVjM2ZlZjYxIn19fQ==", ChatColor.RED + "Meetings"), event -> new MeetingSettings(gui, builder).gui.open(event.getWhoClicked()));
        GuiItem killSettings = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY4OTZjMDg4NmJmOTQ4NjIzOWRlODQ0Mzc2ODI4ODgyOWRhNjJmYTJhNGI3ZWJkNzhhZjQxNWQ0N2IyMThjMSJ9fX0=", ChatColor.RED + "Kills"), event -> new KillSettings(gui, builder).gui.open(event.getWhoClicked()));
        GuiItem visionSettings = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2RiODM1ODY1NDI5MzRmOGMzMjMxYTUyODRmMjQ4OWI4NzY3ODQ3ODQ1NGZjYTY5MzU5NDQ3NTY5ZjE1N2QxNCJ9fX0=", ChatColor.AQUA + "Vision Control"), event -> new VisionSettings(gui, builder).gui.open(event.getWhoClicked()));
        GuiItem miscSettings = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGI3ZjY2M2Q2NWNkZWQ3YmQzNjUxYmRkZDZkYjU0NjM2MGRkNzczYWJiZGFmNDhiODNhZWUwOGUxY2JlMTQifX19", ChatColor.LIGHT_PURPLE + "Miscellaneous"), event -> new MiscSettings(gui, builder).gui.open(event.getWhoClicked()));
        GuiItem lobbyLeader = new GuiItem(Utils.getSkull(lobby.getLeader(), ChatColor.GOLD + "Leader: " + Bukkit.getPlayer(lobby.getLeader()).getDisplayName()));
        GuiItem close = new GuiItem(ItemBuilder.from(Material.BARRIER).setName(ChatColor.RED + "Close").build(), event -> gui.close(event.getWhoClicked()));
        gui.setItem(11, taskSettings);
        gui.setItem(12, meetingSettings);
        gui.setItem(13, killSettings);
        gui.setItem(14, visionSettings);
        gui.setItem(15, miscSettings);
        gui.setItem(31, lobbyLeader);
        gui.setItem(49, close);
    }

}
