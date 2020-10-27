package com.github.amongus.game.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.amongus.AmongUs;
import com.github.amongus.game.Game;

import net.md_5.bungee.api.ChatColor;

public class Wiring extends Task implements Listener {

	private final Inventory gui;

	private Color lastColor;
	private int lastSlot;

	public Wiring(Game game, Location loc) {

		super(game, "Fix Wiring", loc);
		Bukkit.getPluginManager().registerEvents(this, AmongUs.plugin());

		this.gui = Bukkit.createInventory(null, 54, "Fix Wiring");

		List<ItemStack> stacks = generateWiring();
		gui.setItem(2, stacks.get(0));
		gui.setItem(11, stacks.get(1));
		gui.setItem(20, stacks.get(2));
		gui.setItem(29, stacks.get(3));

		Collections.shuffle(stacks);
		gui.setItem(6, stacks.get(0));
		gui.setItem(15, stacks.get(1));
		gui.setItem(24, stacks.get(2));
		gui.setItem(33, stacks.get(3));

		ItemStack gray = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		ItemMeta grayMeta = gray.getItemMeta();
		grayMeta.setDisplayName(ChatColor.GRAY + "");
		gray.setItemMeta(grayMeta);

		setEmpty(gui);

	}

	public List<ItemStack> generateWiring() {

		List<ItemStack> stacks = new ArrayList<>();

		ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta redMeta = red.getItemMeta();
		redMeta.setDisplayName(ChatColor.DARK_RED + "Red Wire");
		red.setItemMeta(redMeta);
		stacks.add(red);

		ItemStack blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
		ItemMeta blueMeta = blue.getItemMeta();
		blueMeta.setDisplayName(ChatColor.DARK_BLUE + "Blue Wire");
		blue.setItemMeta(blueMeta);
		stacks.add(blue);

		ItemStack yellow = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
		ItemMeta yellowMeta = yellow.getItemMeta();
		yellowMeta.setDisplayName(ChatColor.YELLOW + "Yellow Wire");
		yellow.setItemMeta(yellowMeta);
		stacks.add(yellow);

		ItemStack pink = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
		ItemMeta pinkMeta = pink.getItemMeta();
		pinkMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Wire");
		pink.setItemMeta(pinkMeta);
		stacks.add(pink);

		Collections.shuffle(stacks);

		return stacks;

	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (event.getInventory().equals(gui)) {
			event.setCancelled(true);
			Color nextColor = null;
			
			switch (event.getCurrentItem().getType()) {
				case RED_STAINED_GLASS_PANE:
					nextColor = Color.RED;
					break;
				case BLUE_STAINED_GLASS_PANE:
					nextColor = Color.BLUE;
					break;
				case YELLOW_STAINED_GLASS_PANE:
					nextColor = Color.YELLOW;
					break;
				case PINK_STAINED_GLASS_PANE:
					nextColor = Color.PINK;
					break;
				default:
					break;
			}
			
			if (lastColor == null || lastColor != nextColor) {
				switch (event.getCurrentItem().getType()) {
					case RED_STAINED_GLASS_PANE:
						lastColor = Color.RED;
						lastSlot = event.getSlot();
						dragWire(Color.RED);
						break;
					case BLUE_STAINED_GLASS_PANE:
						lastColor = Color.BLUE;
						lastSlot = event.getSlot();
						dragWire(Color.BLUE);
						break;
					case YELLOW_STAINED_GLASS_PANE:
						lastColor = Color.YELLOW;
						lastSlot = event.getSlot();
						dragWire(Color.YELLOW);
						break;
					case PINK_STAINED_GLASS_PANE:
						lastColor = Color.PINK;
						lastSlot = event.getSlot();
						dragWire(Color.PINK);
						break;
					default:
						break;
				}
			} else if (lastColor == nextColor) {
				ItemStack lime = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
				ItemMeta limeMeta = lime.getItemMeta();
				limeMeta.setDisplayName(ChatColor.GREEN + "Wire Connected");
				lime.setItemMeta(limeMeta);
				event.getInventory().setItem(event.getSlot(), lime);
				event.getInventory().setItem(lastSlot, lime);
				lastColor = null;
				lastSlot = event.getSlot();
				if (allComplete(event.getInventory())) {
					callComplete(Bukkit.getPlayer(event.getWhoClicked().getName()));
				}
			}
		}
	}

	public boolean allComplete(Inventory inv) {
		Material m = Material.LIME_STAINED_GLASS_PANE;
		return inv.getItem(2).getType() == m && inv.getItem(11).getType() == m && inv.getItem(20).getType() == m
				&& inv.getItem(29).getType() == m && inv.getItem(6).getType() == m && inv.getItem(15).getType() == m
				&& inv.getItem(24).getType() == m && inv.getItem(33).getType() == m;
	}

	public void dragWire(Color c) {

		switch (c) {

		case RED:
			ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
			ItemMeta redMeta = red.getItemMeta();
			redMeta.setDisplayName(ChatColor.DARK_RED + "Select Second Slot");
			red.setItemMeta(redMeta);
			gui.setItem(4, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			gui.setItem(13, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			gui.setItem(22, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			gui.setItem(31, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			break;

		case BLUE:
			ItemStack blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
			ItemMeta blueMeta = blue.getItemMeta();
			blueMeta.setDisplayName(ChatColor.DARK_BLUE + "Select Second Slot");
			blue.setItemMeta(blueMeta);
			gui.setItem(4, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			gui.setItem(13, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			gui.setItem(22, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			gui.setItem(31, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			break;

		case YELLOW:
			ItemStack yellow = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
			ItemMeta yellowMeta = yellow.getItemMeta();
			yellowMeta.setDisplayName(ChatColor.YELLOW + "Select Second Slot");
			yellow.setItemMeta(yellowMeta);
			gui.setItem(4, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
			gui.setItem(13, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
			gui.setItem(22, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
			gui.setItem(31, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
			break;

		case PINK:
			ItemStack pink = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
			ItemMeta pinkMeta = pink.getItemMeta();
			pinkMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Select Second Slot");
			pink.setItemMeta(pinkMeta);
			gui.setItem(4, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			gui.setItem(13, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			gui.setItem(22, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			gui.setItem(31, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
			break;

		}

	}

	public enum Color {
		RED, BLUE, YELLOW, PINK
	}

	@Override
	public void execute(Player p) {
		p.openInventory(gui);
	}

}
