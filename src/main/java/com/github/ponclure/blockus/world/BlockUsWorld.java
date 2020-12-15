package com.github.ponclure.blockus.world;

import com.github.ponclure.blockus.BlockUs;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class BlockUsWorld {

    private final String url;
    private final BlockUs plugin;
    private final File contents;
    private final WorldType type;

    public BlockUsWorld(BlockUs plugin, WorldType type) {
        this.url = "https://github.com/Ponclure/Among-Us-Worlds/archive/master.zip";
        this.plugin = plugin;
        this.contents = new File(plugin.dataFolder(), type.getFolderName());
        this.type = type;
    }

    private World loadWorld() {
        WorldCreator creator = new WorldCreator(contents.getAbsolutePath());
        return creator.createWorld();
    }

    private boolean downloadWorlds() {
        if (worldFolderExists()) {
            plugin.logger().info(ChatColor.GREEN + "World has been found. Using world: " + type.getFolderName());
        } else {
            try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(contents)) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean worldFolderExists() {
        return contents.exists();
    }

    private enum WorldType {

        SKELD("skeld");

        private final String folderName;

        WorldType(String file) {
            this.folderName = file;
        }

        private String getFolderName() {
            return folderName;
        }

    }

}
