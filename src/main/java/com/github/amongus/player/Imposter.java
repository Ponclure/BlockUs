package com.github.amongus.player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.github.amongus.game.Game;
import com.github.amongus.game.tasks.Task;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

// TOOD: Finish Venting
public class Imposter extends Participant implements Listener {
	
	private Set<Task> fakeTasks; 
	private Set<Crewmate> killedCrewmates; 

	public Imposter(Game game, UUID p, PlayerColor color) {
		super(game, p, color);
		this.fakeTasks = new HashSet<>();
		this.killedCrewmates = new HashSet<>();
	}

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (player.getUniqueId() != getUuid()) {
			return;
		}


		if (player.getLocation().distance())
	}
	
	public Set<Task> getFakeTasks() {
		return fakeTasks;
	}

	public void setFakeTasks(Set<Task> fakeTasks) {
		this.fakeTasks = fakeTasks;
	}

	public Set<Crewmate> getKilledCrewmates() {
		return killedCrewmates;
	}

	public void setKilledCrewmates(Set<Crewmate> killedCrewmates) {
		this.killedCrewmates = killedCrewmates;
	}


}
