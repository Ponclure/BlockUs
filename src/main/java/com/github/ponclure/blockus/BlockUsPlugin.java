package com.github.ponclure.blockus;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BlockUsPlugin extends JavaPlugin {

    private static BlockUs init;

    @Override
    public void onEnable() {

        Logger logger = getLogger();

        long startTime = System.nanoTime();
        logger.info("Loading...");

        init = new BlockUs(this);
        init.setAvailability(true);
        init.configManager().load();

        long totalTime = System.nanoTime() - startTime;
        logger.info("Loading complete. Took " + totalTime + " (ns)");

    }

    @Override
    public void onDisable() {
        init.setAvailability(false);
    }

    public static BlockUs getBlockUs() {
        return init;
    }

}
