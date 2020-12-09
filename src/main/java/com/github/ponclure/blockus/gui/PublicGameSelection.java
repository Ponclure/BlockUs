package com.github.ponclure.blockus.gui;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.game.Lobby;
import com.github.ponclure.blockus.utility.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PaginatedGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class PublicGameSelection {

    private final PaginatedGui gui;

    public PublicGameSelection() {
        this.gui = new PaginatedGui(6, 45, "Among Us Games");
        init();
    }

    private void init() {
        gui.setItem(6, 3, ItemBuilder.from(Material.PAPER).setName(ChatColor.GOLD + "Previous").asGuiItem(event -> gui.previous()));
        gui.setItem(6, 7, ItemBuilder.from(Material.PAPER).setName(ChatColor.GOLD + "Next").asGuiItem(event -> gui.next()));
        gui.setItem(6, 5, new GuiItem(Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTFkNzIwY2QzOWRmM2JlNzRiMGNhYzc1ZTM5MzdmMDA4NWEzNzgyNDc0M2NhZDYzMzBkYzlmNDY2NmE0NTEwZCJ9fX0=", ChatColor.GOLD + "Reload"), event -> {
            for (int i = 0; i < 45; i++) {
                gui.setItem(i, null);
            }
            loadGames();
        }));
        loadGames();
    }

    private void loadGames() {
        for (Game g : BlockUsPlugin.getBlockUs().getGames().values()) {
            Lobby lobby = g.getLobby();
            ItemStack head = Utils.getSkull(lobby.getLeader(), ChatColor.GOLD + Bukkit.getPlayer(lobby.getLeader()).getDisplayName() + "'s Game");
            ItemMeta meta = head.getItemMeta();
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            head.setItemMeta(meta);
            if (lobby.isAccessible()) {
                gui.addItem(new GuiItem(head, event -> {
                    UUID uuid = Bukkit.getPlayer(getOwner(event.getCurrentItem().getItemMeta().getDisplayName())).getUniqueId();
                    for (Game find : BlockUsPlugin.getBlockUs().getGames().values()) {
                        if (find.getLobby().getLeader() == uuid) {
                            find.getLobby().add(event.getWhoClicked().getUniqueId());
                        }
                    }
                }));
            }
        }
    }

    private String getOwner(String str) {
        int split = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '\'') {
                split = i;
                break;
            }
        }
        return str.substring(0, split);
    }


}
