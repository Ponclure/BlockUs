package com.github.amongus.game;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import com.github.amongus.arena.Arena;
import com.github.amongus.utility.Toggler;
import org.bukkit.Bukkit;

import com.github.amongus.player.Participant;

import net.md_5.bungee.api.ChatColor;
//TODO not done, let me continue later //Conclure
public class Game {

	private final Toggler<State> state;

	private final UUID host;
	private final Arena arena;

	Game(Arena arena,
		 UUID host) {
		this.arena = arena;
		this.host = host;
		Pre pre = new Pre(
				arena.getFallBackSettings()
		);
		Running running = new Running(
				pre
		);
		state = new Toggler<>(pre,running);
	}

	public void ifPreState(Consumer<Pre> consumer) {
		State state = this.state.get();
		if (state instanceof Pre) {
			consumer.accept((Pre)state);
		}
	}

	public void ifRunningState(Consumer<Running> consumer) {
		State state = this.state.get();
		if (state instanceof Running) {
			consumer.accept((Running)state);
		}
	}

	public boolean canStart() {
		return state.get() instanceof Pre;
	}

	public boolean isStarted() {
		return state.isToggled();
	}
	
	public boolean start() {
		if (2 * players.size() < (int)configuration.getValue("imposters") + 1) {
			for (Participant p : players) {
				Bukkit.getPlayer(p.getPlayer()).sendMessage(ChatColor.RED + "Game not started, not enough players."); 
			}
		}
		state.toggle();
		
		
		return true;
	}

	public void stop() {

	}
	
	public GameSettings getConfiguration() {
		return configuration;
	}

	public void setConfiguration(GameSettings configuration) {
		this.configuration = configuration;
	}

	public Set<Participant> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Participant> players) {
		this.players = players;
	}

	public UUID getHost() {
		return host;
	}

	interface State { }

	private static class Pre implements State {

		private final Set<UUID> prePlayers = new HashSet<>();
		private final GameSettings.Builder builder;

		private Pre(GameSettings defaultSettings) {
			builder = GameSettings.Builder.of(defaultSettings);
		}

	}

	private static class Running implements State {

		private final Pre pre;

		private GameSettings settings;

		private Running(Pre pre) {
			this.pre = pre;
		}

		private void start() {
			settings = pre.builder.build();
		}

	}


}
