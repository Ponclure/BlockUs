package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.game.Game;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class CalibrateDistributor extends Task {

    // in progress
    private final PersistentGui gui;
    private Player player;
    private int dial;

    public CalibrateDistributor(Game game, Location loc) {
        super(game, "Callibrate Distrubutor", loc);
        this.gui = new PersistentGui(5, "Callibrate Distrubutor");
    }

    public void rotate() {
        while (gui.getInventory().getViewers().get(0).getUniqueId() == player.getUniqueId()) {

        }
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        player = e.getPlayer();
        gui.open(player);
    }
}
