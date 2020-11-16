package com.github.amongus.utility;

import com.github.amongus.AmongUs;
import com.github.amongus.throwable.IllegalInstantiation;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

public final class Utils {

    private Utils() {
        IllegalInstantiation.deploy(Utils.class);
    }

    public static String color(String str) {
        Validate.notNull(str, "Cannot translate null text");
        char[] b = str.toCharArray();

        for (int i = 0; i < b.length - 1; ++i) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = 167;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }

    public static ItemStack getSkull(String skull, String name) {
        ItemStack stack = SkullCreation.itemWithBase64(SkullCreation.createSkull(), skull);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return stack;
    }

    public static void showTitleAnimation(Player p, String text) {
        StringBuilder sb = new StringBuilder();
        String str = sb.toString();
        int index = 0;
        while (!str.equals(text)) {
            str = sb.toString();
            new TitleAnimation(p, str).runTaskLater(AmongUs.plugin(), 2);
            sb.append(text.charAt(index));
            index++;
        }
    }

    private static class TitleAnimation extends BukkitRunnable {
        private final Player player;
        private final String str;
        public TitleAnimation(Player p, String str) {
            this.player = p;
            this.str = str;
        }
        @Override
        public void run() {
            player.sendTitle(str, "", 1, 20, 1);
        }
    }

    public static void setBlock(BoundingBox box, Material mat) {
        for (int x = (int)box.getMinX(); x <= box.getMaxX(); x++) {
            for (int y = (int)box.getMinY(); y <= box.getMaxY(); y++) {
                for (int z = (int)box.getMinZ(); z <= box.getMaxZ(); z++) {
                    new Location(Bukkit.getWorld("skeld"),x, y, z).getBlock().setType(mat);
                }
            }
        }
    }

}
