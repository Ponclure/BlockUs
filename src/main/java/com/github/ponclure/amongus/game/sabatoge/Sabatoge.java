package com.github.ponclure.amongus.game.sabatoge;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.sound.SpecialSoundEffects;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// In Progress
public abstract class Sabatoge implements Listener {

    private final Game game;
    private final String name;
    private final Map<ArmorStand, PersistentGui> fix;
    private final int time;
    private boolean active;

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
        Bukkit.getScheduler().scheduleSyncRepeatingTask(AmongUsPlugin.getAmongUs().plugin(), new BukkitRunnable() {
            @Override
            public void run() {
                if (!active) {
                    cancel();
                }
                for (UUID uuid : game.getParticipants().keySet()) {
                    Player player = Bukkit.getPlayer(uuid);
                    player.playSound(player.getLocation(), SpecialSoundEffects.SABATOGE.getName(), 1.0F, 1.0F);
                    AmongUsPlugin.getAmongUs().getPacketHandler().sendSabatogePacket(player, 50);
                    Bukkit.getScheduler().scheduleAsyncRepeatingTask(AmongUsPlugin.getAmongUs().plugin(), () -> {
                        AmongUsPlugin.getAmongUs().getPacketHandler().sendSabatogePacket(player, 0);
                    }, 0L, 20L);

                }
            }
        }, 0L, 40L);
    }

    public void callComplete() {
        active = false;
    }

}
