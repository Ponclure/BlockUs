package com.github.amongus.game.tasks;

import com.github.amongus.AmongUs;
import com.github.amongus.game.Game;
import com.github.amongus.player.Participant;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BoundingBox;

import java.util.Map;
import java.util.UUID;

public class Scan extends Task implements Listener {

    private final Location scanArea;
    private final Block button;
    private final Participant player;
    private ScanState state;

    public enum ScanState {
        NOT_STARTED, STARTED, FINISHED;
    }

    public Scan(Game game, Location loc, Location scanArea, Block button, Participant p) {
        super(game, "Medical Scan", loc);
        this.scanArea = scanArea;
        this.button = button;
        this.player = p;
        this.state = ScanState.NOT_STARTED;
        AmongUs.plugin().getServer().getPluginManager().registerEvents(this, AmongUs.plugin());
    }

    @EventHandler
    public void onButtonClick(PlayerInteractEvent event) {
        if (state == ScanState.NOT_STARTED) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = event.getClickedBlock();
                if (clicked.getType() == Material.STONE_BUTTON) {
                    if (clicked.getLocation() == button.getLocation()) {
                        if (event.getPlayer().getUniqueId() == player.getUuid()) {
                            state = ScanState.STARTED;
                        }
                    }
                }
           }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (state == ScanState.STARTED) {
            Player p = event.getPlayer();
            if (p.getUniqueId() == player.getUuid()) {
                event.setCancelled(true);
            }
        }
    }

    public void performRitual(Player p) { // kekw
        p.teleport(scanArea);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 8, 1000, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 8, 1000, true, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 8, 1000, true, false));

        p.getWorld().spawnParticle(Particle.WHITE_ASH, scanArea, 10);
    }

    @Deprecated
    public Participant getClosestPlayer() {
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
    public void execute(Player p) {

    }


}
