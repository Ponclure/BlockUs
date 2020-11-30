package com.github.ponclure.amongus.player;

import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.game.tasks.Task;
import com.github.ponclure.amongus.utility.container.Vec3;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

// TOOD: Finish Venting
public class Imposter extends Participant {

    private Set<Task> fakeTasks;
    private Set<Crewmate> killedCrewmates;

    public Imposter(Game game, UUID p, Vec3 spawnLocation, PlayerColor color) {
        super(game, p, spawnLocation, color);
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
