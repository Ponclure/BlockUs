package com.github.amongus.game.tasks;

import java.util.Arrays;
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
import org.bukkit.scheduler.BukkitRunnable;

import com.github.amongus.AmongUs;
import com.github.amongus.game.Game;
import com.github.amongus.utility.SkullCreation;

import net.md_5.bungee.api.ChatColor;

public class UploadData extends Task implements Listener {
	
	private final Inventory gui;
	private final List<Integer> uncompletedIndex = Arrays.asList(20, 21, 22, 23, 24);
	private final List<Integer> borderIndex = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 19, 25, 28, 29, 30, 31, 32, 33, 34);

	public UploadData(Game game, Location loc) {

		super(game, "Upload Data", loc);
		Bukkit.getPluginManager().registerEvents(this, AmongUs.plugin());
		this.gui = Bukkit.createInventory(null, 54, "Upload Data");
		
		ItemStack border = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta borderMeta = border.getItemMeta();
		borderMeta.setDisplayName(ChatColor.GRAY + "");
		border.setItemMeta(borderMeta);
		for (int index : borderIndex) {
			gui.setItem(index, border);
		}

		ItemStack start = getSkull(
				"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZlYjM5ZDcxZWY4ZTZhNDI2NDY1OTMzOTNhNTc1M2NlMjZhMWJlZTI3YTBjYThhMzJjYjYzN2IxZmZhZSJ9fX0=");
		ItemMeta startMeta = start.getItemMeta();
		startMeta.setDisplayName(ChatColor.GOLD + "Start Upload");
		start.setItemMeta(startMeta);
		gui.setItem(49, start);

		ItemStack uncompleted = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
		ItemMeta uncompletedMeta = uncompleted.getItemMeta();
		uncompletedMeta.setDisplayName(ChatColor.GRAY + "");
		uncompleted.setItemMeta(uncompletedMeta);
		for (int index : uncompletedIndex) {
			gui.setItem(index, uncompleted);
		}
		
		setEmpty(gui);
		
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (event.getInventory().equals(gui)) {
			if (event.getSlot() == 49) {
				ItemStack completed = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta completedMeta = completed.getItemMeta();
				completedMeta.setDisplayName(ChatColor.GOLD + "0% Completed");
				completed.setItemMeta(completedMeta);
				gui.setItem(49, completed);
				new BukkitRunnable() {
					double counter = 0;
					@Override
					public void run() {
						if (counter >= 100) {
							counter = 100;
							changeMode(counter);
							cancel();
						}
						counter += 17/6;
						changeMode(counter);
						completedMeta.setDisplayName(ChatColor.GOLD + "" + counter + "% Completed");
					}
				}.runTaskTimer(AmongUs.plugin(), 1, 170);
			}
		}
	}
	
	public void changeMode(double percent) {
		int slots = (int)percent/20;
		if (percent >= 0 && percent < 50) {
			ItemStack uncompleted = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
			ItemMeta uncompletedMeta = uncompleted.getItemMeta();
			uncompletedMeta.setDisplayName(ChatColor.GRAY + "");
			uncompleted.setItemMeta(uncompletedMeta);
			for (int i = 0; i < uncompletedIndex.size(); i++) {
				if (i > slots - 1) {
					break;
				}
				gui.setItem(uncompletedIndex.get(i), uncompleted);
			}
		} else if (percent >= 50 && percent < 100) {
			ItemStack progress = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
			ItemMeta progressMeta = progress.getItemMeta();
			progressMeta.setDisplayName(ChatColor.GRAY + "");
			progress.setItemMeta(progressMeta);
			for (int i = 0; i < uncompletedIndex.size(); i++) {
				if (i > slots - 1) {
					break;
				}
				gui.setItem(uncompletedIndex.get(i), progress);
			}
		} else if (percent >= 100) {
			ItemStack completed = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
			ItemMeta completedMeta = completed.getItemMeta();
			completedMeta.setDisplayName(ChatColor.GREEN + "");
			completed.setItemMeta(completedMeta);
			for (int i = 0; i < uncompletedIndex.size(); i++) {
				gui.setItem(uncompletedIndex.get(i), completed);
			}
		}
	}

	public ItemStack getSkull(String skull) {
		return SkullCreation.itemWithBase64(SkullCreation.createSkull(), skull);
	}

	@Override
	public void execute(Player p) {
		p.openInventory(gui);
	}

}
