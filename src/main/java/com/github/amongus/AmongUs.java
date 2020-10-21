package com.github.amongus;

import com.github.amongus.arena.ArenaManager;
import com.github.amongus.game.GameManager;
import com.sun.javafx.effect.EffectDirtyBits;
import com.sun.org.apache.regexp.internal.RE;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class AmongUs {

    private static final AmongUsPlugin PLUGIN;
    private static final ArenaManager ARENA_MANAGER;
    private static final GameManager GAME_MANAGER;
    private static final Logger LOGGER;
    private static final File DATA_FOLDER;

    static boolean isAvailable;

    static {
        PLUGIN = JavaPlugin.getPlugin(AmongUsPlugin.class);
        ARENA_MANAGER = new ArenaManager();
        GAME_MANAGER = new GameManager();
        LOGGER = PLUGIN.getLogger();
        DATA_FOLDER = PLUGIN.getDataFolder();
    }

    public static AmongUsPlugin plugin() {
        return checkAvailability(PLUGIN);
    }

    public static ArenaManager arenaManager() {
        return checkAvailability(ARENA_MANAGER);
    }

    public static GameManager gameManager() {
        return checkAvailability(GAME_MANAGER);
    }

    public static Logger logger() {
        return checkAvailability(LOGGER);
    }

    public static File dataFolder() {
        return checkAvailability(DATA_FOLDER);
    }


    private static <T> T checkAvailability(T t) {
        if (!isAvailable) throw new IllegalStateException("AmongUs hasn't been loaded yet.");
        return t;
    }

}
