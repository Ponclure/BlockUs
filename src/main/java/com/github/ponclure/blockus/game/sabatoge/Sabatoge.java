package com.github.ponclure.blockus.game.sabatoge;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.sound.SpecialSoundEffects;
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
        Bukkit.getPluginManager().registerEvents(this, BlockUsPlugin.getBlockUs().plugin());
    }

    @EventHandler
    public void manipulate(final PlayerArmorStandManipulateEvent e) {
        if (fix.keySet().stream().anyMatch(armorStand -> armorStand.getUniqueId() == e.getRightClicked().getUniqueId())) {
            e.setCancelled(true);
            execute(e);
        }
    }

    public void startSiren() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BlockUsPlugin.getBlockUs().plugin(), new BukkitRunnable() {
            @Override
            public void run() {
                if (!active) {
                    cancel();
                }
                for (UUID uuid : game.getParticipants().keySet()) {
                    Player player = Bukkit.getPlayer(uuid);
                    player.playSound(player.getLocation(), SpecialSoundEffects.SABATOGE.getName(), 1.0F, 1.0F);
                    BlockUsPlugin.getBlockUs().getPacketHandler().sendSabatogePacket(player, 50);
                    Bukkit.getScheduler().scheduleAsyncRepeatingTask(BlockUsPlugin.getBlockUs().plugin(), () -> {
                        BlockUsPlugin.getBlockUs().getPacketHandler().sendSabatogePacket(player, 0);
                    }, 0L, 20L);

                }
            }
        }, 0L, 40L);
    }

    public void callComplete() {
        active = false;
    }

}
