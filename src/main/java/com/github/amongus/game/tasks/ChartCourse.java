package com.github.amongus.game.tasks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.github.amongus.game.Game;

import me.mattstudios.mfgui.gui.guis.PersistentGui;

public class ChartCourse extends Task {
	
	private final PersistentGui gui;
	
	// TODO: Add code for Chart Course -> Diagonals must be consequent, etc
	public ChartCourse(Game game, Location loc) {
		super(game, "Chart Course", loc);
		
		this.gui = new PersistentGui(5, "Chart Course");
	}

	

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		
	}
	
	
}
