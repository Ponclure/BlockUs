package com.github.ponclure.blockus.utility;

import com.github.ponclure.blockus.player.Participant;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.Set;

public class Countdown implements Runnable {

    private final Set<Participant> players;
    private boolean run;
    private int time;

    public Countdown(int time, Set<Participant> players) {
        this.run = true;
        this.time = time;
        this.players = players;
        run();
    }

    @Override
    public void run() {
        if (run) {
            switch (time) {
                case 5:
                    players.forEach(p -> Bukkit.getPlayer(p.getUuid()).sendMessage(ChatColor.GOLD + "Starting in 5"));
                    break;
                case 4:
                    players.forEach(p -> Bukkit.getPlayer(p.getUuid()).sendMessage(ChatColor.GOLD + "4"));
                    break;
                case 3:
                    players.forEach(p -> Bukkit.getPlayer(p.getUuid()).sendMessage(ChatColor.GREEN + "3"));
                    break;
                case 2:
                    players.forEach(p -> Bukkit.getPlayer(p.getUuid()).sendMessage(ChatColor.YELLOW + "2"));
                    break;
                case 1:
                    players.forEach(p -> Bukkit.getPlayer(p.getUuid()).sendMessage(ChatColor.RED + "1"));
                    break;

                case 0:
                    stop();
            }
            time--;
        }
    }

    public void stop() {
        run = false;
    }

}
