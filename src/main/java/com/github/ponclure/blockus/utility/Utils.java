package com.github.ponclure.blockus.utility;

import com.github.ponclure.blockus.BlockUsPlugin;
import com.github.ponclure.blockus.throwable.IllegalInstantiation;
import com.github.ponclure.blockus.utility.container.AABB;
import com.github.ponclure.blockus.utility.container.Vec3;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;
import java.util.UUID;

public final class Utils {

    private Utils() {
        IllegalInstantiation.deploy(Utils.class);
    }

    public static String color(final String str) {
        Validate.notNull(str, "Cannot translate null text");

        final char[] b = str.toCharArray();

        for (int i = 0; i < b.length - 1; ++i) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = 167;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }

    @SuppressWarnings("ConstantConditions")
    public static ItemStack getSkull(final String skull, final String name) {
        final ItemStack stack = SkullCreation.itemWithBase64(SkullCreation.createSkull(), skull);
        final ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return stack;
    }

    public static void showTitleAnimation(final Player p, final String text) {
        final StringBuilder sb = new StringBuilder();
        String str = sb.toString();
        int index = 0;
        while (!str.equals(text)) {
            str = sb.toString();
            new TitleAnimation(p, str).runTaskLater(BlockUsPlugin.getBlockUs().plugin(), 2);
            sb.append(text.charAt(index));
            index++;
        }
    }

    public static ItemStack getSkull(final UUID uuid, final String name) {
        final ItemStack stack = SkullCreation.itemFromUuid(uuid);
        final ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return stack;
    }

    public static void copyFileOver(File before, File after) throws IOException {
        File[] worldContents = before.listFiles();
        Stack<File> files = new Stack<>();
        for (int i = 0; i < worldContents.length; i++) {
            files.add(worldContents[i]);
        }
        while (!files.isEmpty()) {
            File f = files.pop();
            if (f.isDirectory()) {
                File[] children = f.listFiles();
                for (int i = 0; i < children.length; i++) {
                    files.add(children[i]);
                }
            } else {
                InputStream in = new FileInputStream(f);
                OutputStream out = new FileOutputStream(after);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        }
    }

    private static class TitleAnimation extends BukkitRunnable {

        private final Player player;
        private final String str;

        public TitleAnimation(final Player p, final String str) {
            this.player = p;
            this.str = str;
        }

        @Override
        public void run() {
            this.player.sendTitle(this.str, "", 1, 20, 1);
        }
    }

    public static void setBlock(final AABB aabb, final Material mat) {
        for (final Vec3 vec3 : aabb) {
            vec3.toLocation(Bukkit.getWorld("skeld")).getBlock().setType(mat);
        }
    }

}
