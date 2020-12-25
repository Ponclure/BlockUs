package com.github.ponclure.blockus.game.sabatoge;

import com.github.ponclure.blockus.game.Game;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Map;

public class LightSabatoge extends Sabatoge {

    private int count = 0;

    public LightSabatoge(Game game, Map<ArmorStand, PersistentGui> fix, int time) {
        super(game, "Light Sabatoge", fix, time);
        init();
    }

    private void init() {
        for (PersistentGui gui : fix.values()) {
            gui = new PersistentGui(4, "Lights");
            PersistentGui copy = gui;
            GuiItem lever = new GuiItem(ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName(ChatColor.RED + "Off").build(), event -> {
               event.setCancelled(true);
               copy.setItem(event.getSlot(), new GuiItem(ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).setName(ChatColor.RED + "On").build()));
               count++;
               if (count == 4) {
                   getGame().getParticipants().values().forEach(p -> p.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS));
                   callComplete();
               }
            });
            gui.setItem(Arrays.asList(10, 12, 14, 16), lever);
        }
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        fix.get(e.getRightClicked()).open(e.getPlayer());
    }


}
