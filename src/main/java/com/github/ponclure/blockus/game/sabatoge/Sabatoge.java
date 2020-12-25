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

import java.util.Map;
import java.util.UUID;

public abstract class Sabatoge implements Listener {

    private final Game game;
    private final String name;
    private final int time;
    private boolean active;
    public Map<ArmorStand, PersistentGui> fix;

    public abstract void execute(PlayerArmorStandManipulateEvent e);

    public Sabatoge(Game game, String name, Map<ArmorStand, PersistentGui> fix, int time) {
        this.game = game;
        this.name = name;
        this.time = time;
        this.fix = fix;
        Bukkit.getPluginManager().registerEvents(this, BlockUsPlugin.getBlockUs().plugin());
    }

    @EventHandler
    public void manipulate(final PlayerArmorStandManipulateEvent e) {
        ArmorStand stand = e.getRightClicked();
        if (fix.keySet().stream().anyMatch(armorStand -> armorStand.getUniqueId() == stand.getUniqueId())) {
            e.setCancelled(true);
            fix.get(stand).open(e.getPlayer());
        }
    }

    public void startSiren() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BlockUsPlugin.getBlockUs().plugin(), new BukkitRunnable() {
            @Override
            public void run() {
                if (!active) {
                    cancel();
                }
                game.getParticipants().keySet().forEach(uuid -> {
                    Player player = Bukkit.getPlayer(uuid);
                    player.playSound(player.getLocation(), SpecialSoundEffects.SABATOGE.getName(), 1.0F, 1.0F);
                    BlockUsPlugin.getBlockUs().getPacketHandler().sendSabatogePacket(player, 50);
                    Bukkit.getScheduler().scheduleAsyncRepeatingTask(BlockUsPlugin.getBlockUs().plugin(), () -> {
                        BlockUsPlugin.getBlockUs().getPacketHandler().sendSabatogePacket(player, 0);
                    }, 0L, 20L);

                });
            }
        }, 0L, 40L);
    }

    public void callComplete() {
        active = false;
        for (UUID uuid : game.getParticipants().keySet()) {
            Player player = Bukkit.getPlayer(uuid);
        }
        game.getParticipants().keySet().forEach(uuid -> {
            BlockUsPlugin.getBlockUs().getPacketHandler().sendSabatogePacket(Bukkit.getPlayer(uuid), 0);
        });
    }

    enum SabatogeType {

        OXYGEN("Oxygen"), REACTOR_MELTDOWN("Reactors"),
        COMMUNICATIONS("Communications"), LIGHTS("Lights"),
        DOORS("Doors");

        private final String name;

        SabatogeType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    Game getGame() { return game; };

}
