package com.github.amongus.game.tasks;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.github.amongus.game.Game;
import com.github.amongus.utility.ItemBuilder;

import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;

public class Gasoline extends Task implements Listener {

	private final PersistentGui gui;
	private final Block tank;

	private Player player;
	private int clicks = 0;

	public Gasoline(Game game, Location loc, Block b) {

		super(game, "Gasoline", loc);

		this.tank = b;
		this.gui = new PersistentGui(3, "Fill Gasoline");

		List<Integer> small = Arrays.asList(36, 37, 38, 39, 40, 41, 42, 43, 44);
		List<Integer> middle = Arrays.asList(27, 28, 29, 30, 31, 32, 33, 34, 35);
		List<Integer> almost = Arrays.asList(18, 19, 20, 21, 22, 23, 24, 25, 26);
		List<Integer> full = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17);

		Levelled cauldronData = (Levelled) tank.getBlockData(); // 1 is highest, 7 is lowest
		cauldronData.setLevel(1);
		tank.setBlockData(cauldronData);

		GuiItem empty = new GuiItem(new ItemStack(Material.AIR));
		GuiItem fill = new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
				.withName(ChatColor.GOLD + "Click a Lot to Pour Fuel").get(), event -> {
					clicks++;
					int rows = clicks / 5;
					String percent = (25 * rows) + "% Filled";
					if (clicks % 5 == 0) {
						GuiItem fuel = new GuiItem(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE)
								.withName(ChatColor.YELLOW + percent).get());
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
							callComplete(player);
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
				});
		GuiItem start = new GuiItem(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE)
				.withName(ChatColor.GOLD + "Click to Start Pouring Fuel").get(), event -> {
					gui.setItem(Arrays.asList(12, 13, 14, 21, 22, 23, 30, 31, 32), empty);
					gui.setItem(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), fill);
				});
		gui.setItem(Arrays.asList(12, 13, 14, 21, 22, 23, 30, 31, 32), start);

	}

	@Override
	public void execute(Player p) {
		this.player = p;
		gui.open(p);
	}

	public Block getTank() {
		return tank;
	}

}
