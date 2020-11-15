package com.github.amongus.game.security;

import com.github.amongus.AmongUs;
import com.github.amongus.AmongUsPlugin;
import com.github.ponclure.securitycams.CameraManager;
import com.github.ponclure.securitycams.model.Camera;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class SecurityCamera implements Listener {

    private final CameraManager manager;
    private final Location cameraLoc;
    private final Location viewLoc;
    private final ArmorStand stand;
    private final String name;

    public SecurityCamera(Location cameraLoc, Location viewLoc, String name) {
        this.cameraLoc = cameraLoc;
        this.viewLoc = viewLoc;
        this.stand = (ArmorStand) AmongUsPlugin.getWorld().spawnEntity(viewLoc, EntityType.ARMOR_STAND);
        this.stand.setVisible(false);
        this.stand.setGravity(false);
        this.stand.setCustomName(name);
        this.name = name;
        this.manager = AmongUs.getCameraManager();
        this.manager.addCamera(cameraLoc, name);
        AmongUs.plugin().getServer().getPluginManager().registerEvents(this, AmongUs.plugin());
    }

    @EventHandler
    public void manipulate(PlayerArmorStandManipulateEvent e) {
        ArmorStand as = e.getRightClicked();
        Player player = e.getPlayer();
        if (as.getUniqueId() == stand.getUniqueId()) {
            e.setCancelled(true);
            manager.addWatcher(player, getCamera(as.getName()));
            player.sendMessage(ChatColor.GOLD + "Press sneak to Exit");
        }
    }

    public Camera getCamera(String name) {
        return manager.getCamera(name);
    }

}
