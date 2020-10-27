package com.github.amongus.player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.github.amongus.game.tasks.Task;

public class Imposter extends Participant {
	
	private Set<Task> fakeTasks; 
	private Set<Crewmate> killedCrewmates; 

	public Imposter(UUID p) {
		super(p);
		this.fakeTasks = new HashSet<>();
		this.killedCrewmates = new HashSet<>();
	}
	
	public Imposter(UUID p, String s) {
		super(p, s);
		this.fakeTasks = new HashSet<>();
		this.killedCrewmates = new HashSet<>();
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
