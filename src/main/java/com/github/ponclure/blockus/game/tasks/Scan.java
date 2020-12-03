package com.github.ponclure.blockus.game.tasks;

import com.github.ponclure.blockus.BlockUs;
import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.game.Game;
import com.github.ponclure.blockus.player.Participant;
import com.github.ponclure.blockus.utility.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Scan extends Task implements Listener {

    private final BlockUs au = BlockUsPlugin.getBlockUs();
    private final Location scanArea;
    private final Participant player;
    private ScanState state;

    private enum ScanState {
        NOT_STARTED, STARTED, FINISHED
    }

    public Scan(Game game, Location loc, Location scanArea, Participant p) {
        super(game, "Medical Scan", loc, p);
        this.scanArea = scanArea;
        this.player = p;
        this.state = ScanState.NOT_STARTED;
        au.plugin().getServer().getPluginManager().registerEvents(this, au.plugin());
    }

/*    @EventHandler
    public void onButtonClick(PlayerInteractEvent event) {
        if (state == ScanState.NOT_STARTED) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = event.getClickedBlock();
                if (clicked.getType() == Material.STONE_BUTTON) {
                    if (clicked.getLocation() == button.getLocation()) {
                        if (event.getPlayer().getUniqueId() == player.getUuid()) {
                            state = ScanState.STARTED;
                            performRitual(event.getPlayer());
                        }
                    }
                }
           }
        }
    }*/

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (state == ScanState.STARTED) {
            Player p = event.getPlayer();
            if (p.getUniqueId() == player.getUuid()) {
                event.setCancelled(true);
            }
        }
    }

    private int sec = 0;

    private void performRitual(Player p) { // kekw
        p.teleport(scanArea);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 1000, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 1000, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10, 1000, true, false));
        Random rand = new Random();
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                switch (sec) {
                    case 0:
                        Utils.showTitleAnimation(p, "Starting Scan on Subject");
                        break;
                    case 1:
                        Utils.showTitleAnimation(p, "Color" + player.getColor().name());
                        break;
                    case 2:
                        Utils.showTitleAnimation(p, "Age: " + rand.nextInt(200) + 1 + " Centillions");
                        break;
                    case 3:
                        Utils.showTitleAnimation(p, "Height: " + rand.nextInt(100) + 1 + " Heptameters");
                        break;
                    case 4:
                        Utils.showTitleAnimation(p, "Health: " + getRandomHealth());
                        break;
                    case 5:
                        state = ScanState.FINISHED;
                        callComplete(p, null);
                        break;
                }
                p.getWorld().spawnParticle(Particle.WHITE_ASH, scanArea, 10);
                sec++;
            }
        };
        runnable.runTaskTimer(au.plugin(), 20, 220);
    }

    private String getRandomHealth() {
        Health[] values = Health.values();
        return values[new Random().nextInt(values.length)].name();
    }

    private enum Health {
        OUTSTANDING, WELL, OKAY, POOR, COVID19
    }

    @Deprecated
    private Participant getClosestPlayer() {
        double minDistance = 1000000;
        Participant participant = null;
        Map<UUID, Participant> players = getGame().getParticipants();
        for (UUID uuid : players.keySet()) {
            double distance = Bukkit.getPlayer(uuid).getLocation().distance(scanArea);
            if (distance < minDistance) {
                minDistance = distance;
                participant = players.get(uuid);
            }
        }
        return participant;
    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent event) {
        if (state == ScanState.NOT_STARTED) {
            if (event.getPlayer().getUniqueId() == player.getUuid()) {
                state = ScanState.STARTED;
                performRitual(event.getPlayer());
            }
        }
    }
}
