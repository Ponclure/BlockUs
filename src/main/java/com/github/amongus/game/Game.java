package com.github.amongus.game;

import java.util.Set;

import org.bukkit.Bukkit;

import com.github.amongus.player.GameParticipant;

import net.md_5.bungee.api.ChatColor;

public class Game {

	private GameConfiguration configuration;
	private Set<GameParticipant> players;
	private GameParticipant leader;
	
	private boolean started;
	
	public Game(GameConfiguration config, GameParticipant owner, Set<GameParticipant> list) {
		this.configuration = config;
		this.leader = owner;
		this.players = list;
	}
	
	public boolean start() {
		if (2 * players.size() < (int)configuration.getValue("imposters") + 1) {
			for (GameParticipant p : players) {
				Bukkit.getPlayer(p.getPlayer()).sendMessage(ChatColor.RED + "Game not started, not enough players."); 
			}
		}
		started = true;
		
		
		return true;
	}
	
	public GameConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(GameConfiguration configuration) {
		this.configuration = configuration;
	}

	public Set<GameParticipant> getPlayers() {
		return players;
	}

	public void setPlayers(Set<GameParticipant> players) {
		this.players = players;
	}

	public GameParticipant getLeader() {
		return leader;
	}

	public void setLeader(GameParticipant leader) {
		this.leader = leader;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

}
