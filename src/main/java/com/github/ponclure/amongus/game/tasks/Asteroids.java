package com.github.ponclure.amongus.game.tasks;

import com.github.ponclure.amongus.AmongUsPlugin;
import com.github.ponclure.amongus.game.Game;
import com.github.ponclure.amongus.player.Participant;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

import java.util.*;

public class Asteroids extends Task {

    private final ItemStack tool;
    private int count;
    private Set<Location> locations;

    public Asteroids(Game game, Location loc, Participant p) {
        super(game, "Asteroids", loc, p);
        this.locations = new HashSet<>();
        this.tool = getDestroyer();
        createBox();
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getUniqueId() != getHolder().getUuid()) {
            return;
        }
        if (event.getBlock().getType() != Material.COBBLESTONE) {
            return;
        }
        event.setCancelled(true);
        count++;
    }

    public void startAsteroids() {

        Player participant = Bukkit.getPlayer(getHolder().getUuid());

        PlayerInventory inv = participant.getInventory();
        inv.addItem(tool);

        /*
        Spawning Region
        (501, ~, 509)
        (509, ~+8, 509)
         */

        World world = participant.getWorld();
        Random rand = new Random();

        new BukkitRunnable() {
            @Override
            public void run() {

                // Check if the count is 20
                if (count == 20) {
                    cancel();
                    inv.remove(tool);
                    callComplete(participant, null);
                }

                // Generate Random Starting Location
                int randomX = rand.nextInt(9);
                int randomY = rand.nextInt(9);

                // Generate Spawn Location
                Location blockLoc = new Location(world, 501 + randomX, participant.getLocation().getY() + randomY, 501);

                // Add it to the Set
                locations.add(blockLoc);

                // Check if Block Reaches End of Life Span And Move
                locations.forEach(block -> {

                    // Check if End
                    if (block.getZ() == 509) {

                        // Set Air and Remove
                        world.getBlockAt(block).setType(Material.AIR);
                        locations.remove(block);

                    } else {

                        // Clone
                        Location loc = block.clone();
                        loc.setZ(block.getBlockZ() + 1);

                        // Set to Air and Remove
                        world.getBlockAt(block).setType(Material.AIR);
                        locations.remove(block);

                        // Add New Location and Set to Cobblestone
                        locations.add(loc);
                        world.getBlockAt(loc).setType(Material.COBBLESTONE);

                    }
                });
            }
        }.runTaskTimer(AmongUsPlugin.getAmongUs().plugin(), 0L, 8L);

    }

    public ItemStack getDestroyer() {

        ItemStack tool = new ItemStack(Material.NETHERITE_PICKAXE);

        ItemMeta meta = tool.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Asteroid Destroyer");
        meta.setLore(Arrays.asList("Destroy Asteroids (Cobblestone) using this tool!"));
        meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier("Speed", 2, AttributeModifier.Operation.ADD_NUMBER));

        tool.setItemMeta(meta);

        return tool;

    }

    public void teleport() {
        Player participant = Bukkit.getPlayer(getHolder().getUuid());
        participant.teleport(new Location(participant.getWorld(), 505, participant.getLocation().getY(), 505));
    }

    public void createBox() {
        setSide(Facement.UP);
        setSide(Facement.DOWN);
        setSide(Facement.FORWARD);
        setSide(Facement.BACKWARD);
        setSide(Facement.LEFT);
        setSide(Facement.RIGHT);
    }

    public void setSide(Facement face) {
        BoundingBox box = face.getRegion();
        Player participant = Bukkit.getPlayer(getHolder().getUuid());
        for (int x = (int) box.getMinX(); x < box.getMaxX(); x++) {
            for (int y = (int) box.getMinY(); y < box.getMaxY(); y++) {
                for (int z = (int) box.getMinZ(); z < box.getMaxZ(); z++) {
                    participant.getWorld().getBlockAt(x, y, z).setType(Material.BLACK_CONCRETE);
                }
            }
        }
    }

    private enum Facement {

        UP(new BoundingBox(500, 510, 500, 510, 510, 510)), DOWN(new BoundingBox(500, 500, 500, 510, 500, 510)),
        FORWARD(new BoundingBox(500, 500, 500, 510, 510, 500)), BACKWARD(new BoundingBox(510, 500, 500, 510, 510, 510)),
        LEFT(new BoundingBox(500, 500, 500, 510, 510, 500)), RIGHT(new BoundingBox(500, 500, 510, 510, 510, 510));

        private final BoundingBox region;

        private Facement(BoundingBox box) {
            this.region = box;
        }

        public BoundingBox getRegion() {
            return region;
        }

    }

    @Override
    public void execute(PlayerArmorStandManipulateEvent e) {
        teleport();
        startAsteroids();
    }
}
