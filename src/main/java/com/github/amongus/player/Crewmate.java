package com.github.amongus.player;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.github.amongus.game.Game;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;

import com.github.amongus.game.tasks.Task;

import net.minecraft.server.v1_16_R2.PacketPlayOutEntityMetadata;

public class Crewmate extends Participant {

	private Set<Task> tasks;
	private Set<Task> todo; // Todo tasks

	public Crewmate(Game game, UUID p, PlayerColor color) {
		super(game, p, color);
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
