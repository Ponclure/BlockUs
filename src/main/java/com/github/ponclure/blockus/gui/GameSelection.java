package com.github.ponclure.blockus.gui;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GameSelection implements CommandExecutor {

    Inventory gui;

    public GameSelection() {
        this.gui = Bukkit.createInventory(null, 9, "Example");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("blockus.game.join")) {

            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command");
        }
        return true;
    }

}
