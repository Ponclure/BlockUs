<<<<<<< HEAD
package com.github.amongus.player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.github.amongus.game.tasks.Task;

public class Crewmate extends Participant {

	private Set<Task> tasks; 
	private Set<Task> todo; // Todo tasks

	public Crewmate(UUID p) {
		super(p);
		this.tasks = new HashSet<>();
		this.todo = new HashSet<>();
	}
	
	public Crewmate(UUID p, String s) {
		super(p, s);
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

}
=======
package com.github.amongus.player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.github.amongus.game.tasks.Task;

public class Crewmate extends Participant {

	private Set<Task> tasks; 
	private Set<Task> todo; // Todo tasks

	public Crewmate(UUID p) {
		super(p);
		this.tasks = new HashSet<>();
		this.todo = new HashSet<>();
	}
	
	public Crewmate(UUID p, String s) {
		super(p, s);
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

}
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
