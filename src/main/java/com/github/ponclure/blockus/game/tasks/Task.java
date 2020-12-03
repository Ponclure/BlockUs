package com.github.ponclure.blockus.game.tasks;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Crewmate;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.blockus.sound.SpecialSoundEffects;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.BaseGui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
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
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class Task implements Listener {

    private final Game game;
    private final String name;
    private final ArmorStand stand;
    private final Participant holder;

    public abstract void execute(PlayerArmorStandManipulateEvent e);

    public Task(final Game game, final String name, final Location loc, final Participant holder) {
        this.game = game;
        this.name = name;
        this.stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        stand.setVisible(false);
        stand.setGravity(false);
        this.holder = holder;
        Bukkit.getPluginManager().registerEvents(this, BlockUsPlugin.getBlockUs().plugin());
    }

    @EventHandler
    public void manipulate(final PlayerArmorStandManipulateEvent e) {
        if (e.getRightClicked().getUniqueId() == this.stand.getUniqueId()) {
            e.setCancelled(true);
            execute(e);
        }
    }

    public void callComplete(final Player player, @Nullable final BaseGui gui) {
        if (gui != null) {
            gui.close(player);
        }
        player.sendTitle("" + ChatColor.GREEN + ChatColor.BOLD + "Task Completed", "Move on to Other Tasks", 1, 20, 1);
        for (final UUID uuid : this.game.getSet()) {
            if (uuid == player.getUniqueId()) {
                final Participant participant = this.game.getParticipants().get(uuid);
                if (!participant.isImposter()) {
                    final Crewmate c = (Crewmate) participant;
                    c.removeTask(this);
                    final Player pl = Bukkit.getPlayer(c.getUuid());
                    pl.playSound(pl.getLocation(), SpecialSoundEffects.TASK_PROGRESS.getName(), 1.0F, 1.0F);
                    break;
                }
            }
        }
    }

    public void setEmpty(final PersistentGui inv) {
        final GuiItem gray = ItemBuilder.from(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(ChatColor.GRAY + "").asGuiItem();
        final Inventory inventory = inv.getInventory();
        for (int i = 0; i < inventory.getSize(); i++) {
            final ItemStack item = inventory.getItem(i);
            if (item == null || item.getType() == Material.AIR) {
                inv.setItem(i, gray);
            }
        }
    }

    public Game getGame() {
        return this.game;
    }

    public ArmorStand getStand() {
        return this.stand;
    }

    public String getName() {
        return this.name;
    }

    public Participant getHolder() {
        return this.holder;
    }
}
