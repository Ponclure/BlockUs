package com.github.ponclure.blockus.game.tasks;

import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DivertPower extends Task {

    private final PersistentGui gui;
    private final int index;

    public DivertPower(Game game, Location loc, Participant p) {
        super(game, "Divert Power", loc, p);
        this.gui = new PersistentGui(5, "Divert Power");
        this.index = new Random().nextInt(6);
        init();
        setEmpty(gui);
    }

    private void init() {
        List<Integer> slots = Arrays.asList(20, 21, 22, 23, 24);
        GuiItem increase = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTA1YTJjYWI4YjY4ZWE1N2UzYWY5OTJhMzZlNDdjOGZmOWFhODdjYzg3NzYyODE5NjZmOGMzY2YzMWEzOCJ9fX0=", "Increase"), event -> {
            event.setCancelled(true);
            if (event.getSlot() + 9 == index) {
                gui.setItem(slots.get(index), new GuiItem(ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).setName(ChatColor.GREEN + "Perfect").build()));
                callComplete((Player) event.getWhoClicked(), gui);
            }
        });
        gui.setItem(Arrays.asList(11, 12, 13, 14, 15), increase);
        GuiItem decrease = new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzAxNTg2ZTM5ZjZmZmE2M2I0ZmIzMDFiNjVjYTdkYThhOTJmNzM1M2FhYWI4OWQzODg2NTc5MTI1ZGZiYWY5In19fQ==", "Decrease"), event -> {
            event.setCancelled(true);
        });
        gui.setItem(Arrays.asList(29, 30, 31, 32, 33), decrease);
        for (int slot : slots) {
            if (slot != index) {
                gui.setItem(slot, new GuiItem(ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).setName(ChatColor.GREEN + "Good").build()));
            } else {
                gui.setItem(slot, new GuiItem(ItemBuilder.from(Material.YELLOW_STAINED_GLASS_PANE).setName(ChatColor.RED + "Pull Up").build()));
            }
        }
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }
}
