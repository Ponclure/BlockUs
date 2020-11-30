package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import com.github.ponclure.amongus.utility.Utils;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;

public class AlignEngine extends Task {

    private final PersistentGui gui;
    private final int finalYaw;
    private final int finalPitch;
    private int currentYaw;
    private int currentPitch;

    public AlignEngine(Game game, Location loc, Participant holder) {
        super(game, "Align Engine", loc, holder);
        this.gui = new PersistentGui(5, "Allign Engine");
        this.finalYaw = generateRandom();
        this.finalPitch = generateRandom();
        this.currentYaw = 180;
        this.currentPitch = 180;
        init();
        setEmpty(gui);
    }

    public int generateRandom() {
        Random rand = new Random();
        int num = rand.nextInt(11);
        boolean operation = rand.nextBoolean();
        if (operation) {
            return 180 + num * 10;
        } else {
            return 180 - num * 10;
        }
    }

    private void init() {

        ItemStack yaw = Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjllZTgxZDQ4OTA3NmYyOTcxZGUwZDVlNzU4OTlkNGRmZTlmYjMxMTQzNmUyNzE5NWZiYzJkN2RlYjYwOWVjMCJ9fX0=", ChatColor.GOLD + "Yaw");
        gui.setItem(19, new GuiItem(yaw));

        ItemStack pitch = Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjllZTgxZDQ4OTA3NmYyOTcxZGUwZDVlNzU4OTlkNGRmZTlmYjMxMTQzNmUyNzE5NWZiYzJkN2RlYjYwOWVjMCJ9fX0=", ChatColor.GOLD + "Pitch");
        gui.setItem(21, new GuiItem(pitch));

        ItemStack increase = Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWNkYjhmNDM2NTZjMDZjNGU4NjgzZTJlNjM0MWI0NDc5ZjE1N2Y0ODA4MmZlYTRhZmYwOWIzN2NhM2M2OTk1YiJ9fX0=", ChatColor.GOLD + "Increase by 10");
        GuiItem plus = new GuiItem(increase, event -> {
            if (event.getSlot() == 10) {
                currentYaw += 10;
            } else if (event.getSlot() == 12) {
                currentPitch += 10;
            }
            if (currentYaw == finalYaw && currentPitch == finalPitch) {
                callComplete((Player) event.getWhoClicked(), gui);
            }
        });
        gui.setItem(Arrays.asList(10, 12), plus);

        ItemStack decrease = Utils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFlMWU3MzBjNzcyNzljOGUyZTE1ZDhiMjcxYTExN2U1ZTJjYTkzZDI1YzhiZTNhMDBjYzkyYTAwY2MwYmI4NSJ9fX0=", ChatColor.GOLD + "Decrease by 10");
        GuiItem minus = new GuiItem(decrease, event -> {
            if (event.getSlot() == 28) {
                currentYaw -= 10;
            } else if (event.getSlot() == 30) {
                currentPitch -= 10;
            }
            if (currentYaw == finalYaw && currentPitch == finalPitch) {
                callComplete((Player) event.getWhoClicked(), gui);
            }
        });
        gui.setItem(Arrays.asList(28, 30), minus);

    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        gui.open(e.getPlayer());
    }
}
