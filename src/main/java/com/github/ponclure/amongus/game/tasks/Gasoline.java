package com.github.ponclure.amongus.game.tasks;

import java.util.Arrays;
import java.util.List;

import com.github.ponclure.amongus.player.Participant;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;

import com.github.ponclure.amongus.game.Game;

import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;

public class Gasoline extends Task implements Listener {

	private final PersistentGui gui;
	private final Block tank;

	private int clicks = 0;

	public Gasoline(Game game, Location loc, Block b, Participant p) {

		super(game, "Gasoline", loc, p);

		this.tank = b;
		this.gui = new PersistentGui(3, "Fill Gasoline");

		List<Integer> small = Arrays.asList(36, 37, 38, 39, 40, 41, 42, 43, 44);
		List<Integer> middle = Arrays.asList(27, 28, 29, 30, 31, 32, 33, 34, 35);
		List<Integer> almost = Arrays.asList(18, 19, 20, 21, 22, 23, 24, 25, 26);
		List<Integer> full = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17);
		List<Integer> startSlots = Arrays.asList(12, 13, 14, 21, 22, 23, 30, 31, 32);

		Levelled cauldronData = (Levelled) tank.getBlockData(); // 1 is highest, 7 is lowest
		cauldronData.setLevel(1);
		tank.setBlockData(cauldronData);

		GuiItem empty = new GuiItem(new ItemStack(Material.AIR));
		GuiItem fill = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "Click a Lot to Pour Fuel").asGuiItem(event -> {
					if (startSlots.contains(event.getSlot())) {
						clicks++;
						int rows = clicks / 5;
						String percent = (25 * rows) + "% Filled";
						if (clicks % 5 == 0) {
							GuiItem fuel = ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.YELLOW + percent).asGuiItem();
							switch (rows) {
								case 1:
									gui.setItem(small, fuel);
									break;
								case 2:
									gui.setItem(middle, fuel);
									cauldronData.setLevel(3);
									tank.setBlockData(cauldronData);
									break;
								case 3:
									gui.setItem(almost, fuel);
									cauldronData.setLevel(5);
									tank.setBlockData(cauldronData);
									break;
								case 4:
									gui.setItem(full, fuel);
									cauldronData.setLevel(7);
									tank.setBlockData(cauldronData);
									callComplete((Player)event.getWhoClicked(), gui);
									break;
							}
						} else {
							switch (rows) {
								case 0:
									gui.setItem(small, empty);
									break;
								case 1:
									gui.setItem(middle, empty);
									break;
								case 2:
									gui.setItem(almost, empty);
									break;
								case 3:
									gui.setItem(full, empty);
									break;
							}
						}
					} else {
						event.setCancelled(true);
					}
				});
		GuiItem start = ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "Click to Start Pouring Fuel").asGuiItem(event -> {
					gui.setItem(Arrays.asList(12, 13, 14, 21, 22, 23, 30, 31, 32), empty);
					gui.setItem(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), fill);
				});
		gui.setItem(startSlots, start);

		setEmpty(gui);

	}

	@Override
	public void execute(PlayerArmorStandManipulateEvent e) {
		gui.open(e.getPlayer());
	}

	public Block getTank() {
		return tank;
	}

}
