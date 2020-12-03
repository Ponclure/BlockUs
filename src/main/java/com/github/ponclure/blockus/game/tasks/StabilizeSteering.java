package com.github.ponclure.blockus.game.tasks;

import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.Random;

public class StabilizeSteering extends Task {

    private final PersistentGui gui;

    public StabilizeSteering(Game game, Location loc, Participant p) {
        super(game, "Stabilize Steering", loc, p);
        this.gui = new PersistentGui(5, "Stabilize Steering");
        init();
    }

    private int slot;

    private void init() {
        Random rand = new Random();
        slot = rand.nextInt(45);
        while (slot != 22) {
            slot = rand.nextInt(45);
        }
        GuiItem item = new GuiItem(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.GOLD + "Drag me to the Middle").build(), event -> {
            int clickedSlot = event.getSlot();
            if (clickedSlot == 22) {
                callComplete((Player) event.getWhoClicked(), gui);
            } else if (clickedSlot != slot) {
                event.setCancelled(true);
            }
        });
        gui.setItem(slot, item);

    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }
}
