package com.github.amongus.game.tasks;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.github.amongus.AmongUs;
import com.github.amongus.AmongUsPlugin;
import com.github.amongus.game.Game;
import com.github.amongus.player.Crewmate;
import com.github.amongus.player.Participant;
import com.github.amongus.sound.SpecialSoundEffects;
import com.github.amongus.utility.ItemBuilder;

import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;

public abstract class Task implements Listener {

	private Game game;
	private String name;
	private ArmorStand stand;
	private UUID uuid;

	public abstract void execute(Player p);

	public Task(Game game, String name, Location loc) {
		this.game = game;
		this.setName(name);
		Bukkit.getPluginManager().registerEvents(this, AmongUs.plugin());

		this.stand = (ArmorStand) AmongUsPlugin.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		this.stand.setVisible(false);
		this.stand.setGravity(false);

		this.setUuid(stand.getUniqueId());
	}
	
	@EventHandler
	public void manipulate(PlayerArmorStandManipulateEvent e) {
		if (e.getRightClicked().getUniqueId() == uuid) {
			e.setCancelled(true);
			execute(e.getPlayer());
		}
	}

	public void callComplete(Player player) {
		player.closeInventory();
		player.sendTitle(ChatColor.BOLD + "" + ChatColor.GREEN + ChatColor.GREEN + "Task Completed",
				"Move on to Other Tasks", 1, 20, 1);
		for (UUID uuid : game.getSet()) {
			if (uuid == player.getUniqueId()) {
				Participant participant = game.getParticipants().get(uuid);
				if (!participant.isImposter()) {
					Crewmate c = (Crewmate) participant;
					c.removeTask(this);
					Player pl = Bukkit.getPlayer(c.getUuid());
					pl.playSound(pl.getLocation(), SpecialSoundEffects.TASK_PROGRESS.getName(), 1.0F, 1.0F);
					break;
				}
			}
		}
	}

	public void setEmpty(PersistentGui inv) {
		GuiItem gray = new GuiItem(new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE).withName(ChatColor.GRAY + "").get());
		Inventory inventory = inv.getInventory();
		for (int i = 0; i < inventory.getSize(); i++) {
			ItemStack item = inventory.getItem(i);
			if (item == null || item.getType() == Material.AIR) {
				inv.setItem(i, gray);
			}
		}
	}

	public Game getGame() {
		return game;
	}

	public ArmorStand getStand() {
		return stand;
	}

	public void setStand(ArmorStand stand) {
		this.stand = stand;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
