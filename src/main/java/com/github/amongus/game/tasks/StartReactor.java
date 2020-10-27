package com.github.amongus.game.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
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

public class StartReactor extends Task implements Listener {

	private Inventory gui;

	private final List<Integer> copyGrid = Arrays.asList(19, 20, 21, 28, 29, 39, 37, 38, 39);

	private final List<Integer> pressGrid = Arrays.asList(23, 24, 25, 32, 33, 34, 41, 42, 43);

	private final List<Integer> status = Arrays.asList(2, 3, 4, 5, 6, 7);

	private final List<List<Integer>> sequence = genSequence();

	private List<Integer> currentSequence = new ArrayList<>(); // Current sequence that the user has pressed
	private int index = 0; // Index of the current button
	private int correct = 0; // How many sequences the user has gotten correct

	public StartReactor(Game game, Location loc) {

		super(game, "Start Reactor", loc);
		Bukkit.getPluginManager().registerEvents(this, AmongUs.plugin());
		this.gui = Bukkit.createInventory(null, 54, "Upload Data");

		ItemStack button = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta buttonMeta = button.getItemMeta();
		buttonMeta.setDisplayName(ChatColor.DARK_GRAY + "");
		button.setItemMeta(buttonMeta);

		for (int i = 0; i < 9; i++) {
			gui.setItem(copyGrid.get(i), button);
			gui.setItem(pressGrid.get(i), button);
		}

	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (event.getInventory().equals(gui) && event.getWhoClicked() instanceof Player) {
			Player p = (Player) event.getWhoClicked();
			event.setCancelled(true);
			int slot = event.getSlot();
			if (pressGrid.contains(slot)) {
				int clicked = 0;
				switch (slot) {
				case 23:
					clicked = 0;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.C));
					break;
				case 24:
					clicked = 1;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.D));
					break;
				case 25:
					clicked = 2;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.E));
					break;
				case 26:
					clicked = 3;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.F));
					break;
				case 27:
					clicked = 4;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.G));
					break;
				case 28:
					clicked = 5;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.A));
					break;
				case 29:
					clicked = 6;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.B));
					break;
				case 30:
					clicked = 7;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(2, Note.Tone.C));
					break;
				case 31:
					clicked = 8;
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(2, Note.Tone.D));
					break;
				}
				if (sequence.get(correct).get(index) == clicked) { // its right! :D
					index++;
				} else { // its wrong! :(
					correct = 0;
					index = 0;
					currentSequence.clear();
					setWrong();
				}
				if (finishSeq(currentSequence, correct)) { // finished a whole sequence
					correct++;
					if (correct == 5) {
						callComplete((Player) event.getWhoClicked());
					}
					index = 0;
					currentSequence.clear();
				}
			}
		}
	}
	
	public void setWrong() {
		ItemStack wrong = new ItemStack(Material.RED_STAINED_GLASS);
		ItemMeta wrongMeta = wrong.getItemMeta();
		wrongMeta.setDisplayName(ChatColor.RED + "WRONG BUTTON");
		wrong.setItemMeta(wrongMeta);
		for (int i = 0; i < status.size(); i++) {
			gui.setItem(status.get(i), wrong);
		}
	}

	public boolean finishSeq(List<Integer> current, int correct) {
		return sequence.get(correct).equals(current);
	}

	public List<List<Integer>> genSequence() {
		List<List<Integer>> setting = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			int random = rand.nextInt(0) + 9;
			while (setting.get(i).contains(random)) {
				random = rand.nextInt(0) + 9;
			}
			if (setting.size() == 0) {
				List<Integer> click = new ArrayList<>();
				click.add(random);
				setting.add(click);
			} else {
				List<Integer> click = new ArrayList<>(setting.get(i - 1));
				click.add(random);
				setting.add(click);
			}
		}
		return setting;
	}

	@Override
	public void execute(Player p) {
		p.openInventory(gui);
	}

}
