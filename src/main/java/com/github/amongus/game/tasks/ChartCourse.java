package com.github.amongus.game.tasks;

import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.github.amongus.game.Game;

import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.Arrays;
import java.util.List;

public class ChartCourse extends Task {
	
	private final PersistentGui gui;
	private int currentPos = 0;

	public ChartCourse(Game game, Location loc) {
		super(game, "Chart Course", loc);
		
		this.gui = new PersistentGui(5, "Chart Course");

		List<Integer> course = Arrays.asList(28, 20, 12, 22, 32, 24, 16);

		GuiItem clicked = ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName(ChatColor.BLUE + "").asGuiItem();
		GuiItem path = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.RED + "").asGuiItem(event -> {
			int slot = event.getSlot();
			if (course.contains(slot) && slot == course.get(currentPos)) {
				if (slot == 16) {
					callComplete((Player)event.getWhoClicked(), gui);
				}
				gui.setItem(course.get(currentPos), clicked);
				currentPos++;
			} else {
				event.setCancelled(true);
			}
		});
		gui.setItem(course, path);

		setEmpty(gui);

	}

	

	@Override
	public void execute(PlayerArmorStandManipulateEvent e) {
		gui.open(e.getPlayer());
	}
	
	
}
