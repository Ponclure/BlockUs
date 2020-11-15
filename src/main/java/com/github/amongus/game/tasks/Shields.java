package com.github.amongus.game.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.github.amongus.game.Game;
import com.github.amongus.sound.SpecialSoundEffects;
import com.github.amongus.utility.ItemBuilder;

import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class Shields extends Task {

	private final PersistentGui gui;
	private final List<Integer> all = Arrays.asList(12, 13, 14, 21, 22, 23, 32, 33, 34);
	private final List<Integer> random = genRandomCells();

	public Shields(Game game, Location loc) {
		super(game, "Shields", loc);

		this.gui = new PersistentGui(5, "Shields");

		GuiItem fine = new GuiItem(
				new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).withName(ChatColor.GREEN + "I'm Good").get());
		GuiItem broken = new GuiItem(
				new ItemBuilder(Material.RED_STAINED_GLASS_PANE).withName(ChatColor.DARK_RED + "Click Me!").get(),
				event -> {
					gui.setItem(event.getSlot(), fine);
					if (allEnabled()) {
						Player p = (Player)event.getWhoClicked();
						p.playSound(p.getLocation(), SpecialSoundEffects.TASK_PROGRESS.getName(), 1.0F, 1.0F);
						callComplete(p);
					}
				});
		for (int index : random) {
			gui.setItem(getSlot(index), broken);
		}
		for (int slot : all) {
			if (gui.getGuiItem(slot).getItemStack() == null) {
				gui.setItem(getSlot(slot), fine);
			}
		}

		setEmpty(gui);

	}

	public boolean allEnabled() {
		for (int index : all) {
			if (gui.getGuiItem(index).getItemStack().getType() == Material.RED_STAINED_GLASS_PANE) {
				return false;
			}
		}
		return true;
	}

	public int getSlot(int index) {

		switch (index) {

		case 0:
			return 12;

		case 1:
			return 13;

		case 2:
			return 14;

		case 3:
			return 21;

		case 4:
			return 22;

		case 5:
			return 23;

		case 6:
			return 32;

		case 7:
			return 33;

		case 8:
			return 34;

		default:
			return -1;

		}
	}

	public List<Integer> genRandomCells() {
		Random rand = new Random();
		List<Integer> slots = new ArrayList<>();
		int index = rand.nextInt(8) + 1;
		for (int i = 0; i < index; i++) {
			int random = rand.nextInt(9);
			while (slots.contains(random)) {
				random = rand.nextInt(9);
			}
			slots.add(random);
		}
		return slots;
	}

	@Override
	public void execute(Player p, PlayerArmorStandManipulateEvent e) {
		gui.open(p);
	}

}
