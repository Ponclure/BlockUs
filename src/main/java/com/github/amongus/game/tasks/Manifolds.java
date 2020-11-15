package com.github.amongus.game.tasks;

import com.github.amongus.game.Game;
import com.github.amongus.utility.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Manifolds extends Task {

    private final PersistentGui gui;
    private int current = 1;

    public Manifolds(Game game, Location loc) {
        super(game, "Manifolds", loc);
        this.gui = new PersistentGui(5, "Manifolds");
        List<Integer> seq = genRandomSequence();
        int index = 0;
        GuiItem correct = new GuiItem(new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).withName(ChatColor.GREEN + "✔").get());
        GuiItem wrong = new GuiItem(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).withName(ChatColor.RED + "❌").get());
        GuiItem unclicked = new GuiItem(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).withName(ChatColor.GOLD + "" + getSlot(seq.get(index))).get(), event -> {
            int slot = event.getSlot();
            if (gui.getGuiItem(slot).getItemStack().getItemMeta().getDisplayName().contains(String.valueOf(current + 1))) {
                if (current == 9) {
                    callComplete((Player)event.getWhoClicked());
                } else {
                    gui.setItem(slot, correct);
                }
            } else {
                gui.setItem(slot, wrong);
            }
        });
        gui.setItem(Arrays.asList(11, 12, 13, 14, 15, 20, 21, 22, 23, 24), unclicked);

        setEmpty(gui);
    }

    public List<Integer> genRandomSequence() {
        List<Integer> sequence = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.shuffle(sequence);
        return sequence;
    }

    public int getSlot(int index) {
        switch (index) {
            case 1:
                return 11;
            case 2:
                return 12;
            case 3:
                return 13;
            case 4:
                return 14;
            case 5:
                return 15;
            case 6:
                return 20;
            case 7:
                return 21;
            case 8:
                return 22;
            case 9:
                return 23;
            case 10:
                return 24;
        }
        return -1;
    }

    @Override
    public void execute(Player p, PlayerArmorStandManipulateEvent e) {
        gui.open((Player)p);
    }


}
