package com.github.ponclure.blockus.player;

import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.game.tasks.Task;
import com.github.ponclure.blockus.utility.container.Vec3;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Crewmate extends Participant {

    private Set<Task> tasks;
    private Set<Task> todo; // Todo tasks

    public Crewmate(Game game, UUID p, Vec3 spawnLocation, PlayerColor color) {
        super(game, p, spawnLocation, color);
        this.tasks = new HashSet<>();
        this.todo = new HashSet<>();
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Task> getTodo() {
        return todo;
    }

    public void setTodo(Set<Task> todo) {
        this.todo = todo;
    }

    public void removeTask(Task t) {
        todo.remove(t);
    }

    public void showTasks() {
//		PacketPlayOutEntityMetadata packet = (PacketPlayOutEntityMetadata) obj;
//	    int entityID = (int) ReflectionUtils.getField(packet.getClass(), "a").get(packet);
//	    List<DataWatcher.Item<?>> data = (List<DataWatcher.Item<?>>) ReflectionUtils.getField(packet.getClass(), "b").get(packet);
    }

}
