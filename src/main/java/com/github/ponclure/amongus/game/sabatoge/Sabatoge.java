package com.github.ponclure.amongus.game.sabatoge;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// In Progress
public abstract class Sabatoge implements Listener {

    private final Game game;
    private final String name;
    private final Map<ArmorStand, PersistentGui> fix;
    private final int time;

    public abstract void execute(PlayerArmorStandManipulateEvent e);

    public Sabatoge(Game game, String name, ArmorStand[] fix, int time) {
        this.game = game;
        this.name = name;
        this.time = time;
        this.fix = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(this, AmongUsPlugin.getAmongUs().plugin());
    }

    @EventHandler
    public void manipulate(final PlayerArmorStandManipulateEvent e) {
        if (fix.keySet().stream().anyMatch(armorStand -> armorStand.getUniqueId() == e.getRightClicked().getUniqueId())) {
            e.setCancelled(true);
            execute(e);
        }
    }

    public void startSiren() {
        for (UUID uuid : game.getParticipants().keySet()) {

        }
    }

    public void callComplete() {

    }

}
