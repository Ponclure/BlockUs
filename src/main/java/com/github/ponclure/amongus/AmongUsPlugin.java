package com.github.ponclure.amongus;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AmongUsPlugin extends JavaPlugin {

    private static AmongUs init;

    @Override
    public void onEnable() {

        Logger logger = getLogger();

        long startTime = System.nanoTime();
        logger.info("Loading...");

        init = new AmongUs(this);
        init.setAvailability(true);
        init.configManager().load();

        long totalTime = System.nanoTime() - startTime;
        logger.info("Loading complete. Took " + totalTime + " (ns)");

    }

    @Override
    public void onDisable() {
        init.setAvailability(false);
    }

    public static AmongUs getAmongUs() {
        return init;
    }

}
