package com.github.ponclure.blockus.game.sabatoge;

import com.github.ponclure.blockus.game.Game;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReactorSabatoge extends Sabatoge {

    private final Map<ArmorStand, PersistentGui> fix;
    private Set<Integer> fixed;

    public ReactorSabatoge(Game game, Map<ArmorStand, PersistentGui> fix, int time) {
        super(game, "Reactor Sabatoge", fix, time);
        this.fix = new HashMap<>();
        this.fixed = new HashSet<>();
        init();
    }

    private void init() {
        for (PersistentGui gui : fix.values()) {
        GuiItem button = new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.RED + "Hold to Fix").build(), event -> {
            if (event.getSlot() == 13) {
                ItemStack item = gui.getGuiItem(13).getItemStack();
                int hash = gui.hashCode();
                if (item == null || item.getType() == Material.AIR) {
                    fixed.add(hash);
                } else if (fixed.contains(hash)) {
                    fixed.remove(hash);
                }
                if (fixed.size() == fix.size()) {
                    gui.close(event.getWhoClicked());
                    callComplete();
                }
            } else {
                event.setCancelled(true);
            }
        });
        gui.setItem(13, button);
        }
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        fix.get(e.getRightClicked()).open(e.getPlayer());
    }
}
