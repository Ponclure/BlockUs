<<<<<<< HEAD
package com.github.amongus.utility;

import java.util.Set;

import com.github.amongus.player.Participant;

import net.md_5.bungee.api.ChatColor;

public class Countdown implements Runnable {

	boolean run;
	int time;
	Set<Participant> players;

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
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.GOLD + "Starting in 5"));
					break;
				case 4:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.GOLD + "4"));
					break;
				case 3:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.GREEN + "3"));
					break;
				case 2:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.YELLOW + "2"));
					break;
				case 1:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.RED + "1"));
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
=======
package com.github.amongus.utility;

import java.util.Set;

import com.github.amongus.player.Participant;

import net.md_5.bungee.api.ChatColor;

public class Countdown implements Runnable {

	boolean run;
	int time;
	Set<Participant> players;

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
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.GOLD + "Starting in 5"));
					break;
				case 4:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.GOLD + "4"));
					break;
				case 3:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.GREEN + "3"));
					break;
				case 2:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.YELLOW + "2"));
					break;
				case 1:
					players.forEach(p -> p.getPlayer().sendMessage(ChatColor.RED + "1"));
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
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
