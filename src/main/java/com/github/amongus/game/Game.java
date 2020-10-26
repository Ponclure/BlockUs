package com.github.amongus.game;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import com.github.amongus.AmongUs;
import com.github.amongus.arena.Arena;
import com.github.amongus.utility.Countdown;
import com.github.amongus.utility.Toggler;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.amongus.player.Participant;

import net.md_5.bungee.api.ChatColor;

public class Game {

	private final Toggler<State> state;

	private final Arena arena;
	private final Set<Participant> players;
	private final UUID host;

	public Game(Arena arena, UUID host) {

		Pre pre = new Pre(arena.getFallBackSettings());
		Running running = new Running(pre);

		this.arena = arena;
		this.state = new Toggler<>(pre, running);
		this.players = new HashSet<>();
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
			players.forEach(p -> p.getPlayer().sendMessage(ChatColor.RED + "Game not started, not enough players."));
			return false;
		}
		
		Bukkit.getScheduler().runTaskTimer(AmongUs.plugin(), new Countdown(5, players), 20L, 20L);
		state.toggle();
		
		players.forEach(p -> p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 4, 255, true, false)));
		
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

	public Set<Participant> getPrePlayers() {
		return players;
	}

	interface State {
	}

	private static class Pre implements State {

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