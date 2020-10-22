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

public class Game {

	private final Toggler<State> state;
		
	private final Arena arena;
	private final UUID host;

	public Game(Arena arena, UUID host) {
		
		Pre pre = new Pre(arena.getFallBackSettings());
		Running running = new Running(pre);
		
		this.arena = arena;
		this.state = new Toggler<>(pre, running);
		this.host = host;
		
	}

	public void ifPreState(Consumer<Pre> consumer) {
		State state = this.state.get();
		if (state instanceof Pre) {
			consumer.accept((Pre) state);
		}
	}

	public void ifRunningState(Consumer<Running> consumer) {
		State state = this.state.get();
		if (state instanceof Running) {
			consumer.accept((Running) state);
		}
	}

	public boolean canStart() {
		return state.get() instanceof Pre;
	}

	public boolean isStarted() {
		return state.isToggled();
	}

	public boolean start() {
		if (2 * players.size() < (int) configuration.getImpostorCount() + 1) {
			for (Participant p : players) {
				p.getPlayer().sendMessage(ChatColor.RED + "Game not started, not enough players.");
			}
		}
		state.toggle();

		return true;
	}

	public void stop() {

	}

	public UUID getHost() {
		return host;
	}

	public Arena getArena() {
		return arena;
	}

	interface State {
	}

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

	public Set<Participant> getPlayers() {
		return players;
	}

}