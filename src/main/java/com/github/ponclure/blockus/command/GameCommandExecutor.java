package com.github.ponclure.blockus.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GameCommandExecutor implements CommandExecutor {

    // Unfinished
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be an in game player to execute this command");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "================================");
            sender.sendMessage(ChatColor.GOLD + "         List of Commands       ");
            sender.sendMessage(ChatColor.AQUA + "================================");
            sender.sendMessage(formatCommand("/blockus create", "Creates a Fresh Block Us Game"));
            sender.sendMessage(formatCommand("/blockus join [username]", "Joins a game"));
            sender.sendMessage(formatCommand("/blockus leave", "Leaves the game"));
            sender.sendMessage(formatCommand("/blockus gui", "Opens a gui of available games to join"));
            sender.sendMessage(formatCommand("/blockus forcestop", "Forces the current game to stop"));
            sender.sendMessage(ChatColor.AQUA + "================================");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("create")) {

            } else if (args[0].equalsIgnoreCase("leave")) {

            } else if (args[0].equalsIgnoreCase("list")) {

            } else if (args[0].equalsIgnoreCase("forcestop")) {

            }
        }


        return false;
    }

    private String formatCommand(String command, String description) {
        return ChatColor.GOLD + command + ChatColor.LIGHT_PURPLE + " <-> " + ChatColor.AQUA + description;
    }
}
