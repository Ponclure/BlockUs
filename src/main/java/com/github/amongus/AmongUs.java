package com.github.amongus;

import com.github.amongus.arena.ArenaManager;
import com.github.amongus.config.ConfigFactory;
import com.github.amongus.config.ConfigManager;
import com.github.amongus.game.GameManager;

import com.github.ponclure.securitycams.CameraManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.logging.Logger;

public final class AmongUs {

    public static boolean isAvailable;
    private static final AmongUsPlugin PLUGIN;
    private static final ArenaManager ARENA_MANAGER;
    private static final GameManager GAME_MANAGER;
    private static final Logger LOGGER;
    private static final File DATA_FOLDER;
    private static final ConfigFactory CONFIG_FACTORY;
    private static final ConfigManager CONFIG_MANAGER;

    private static CameraManager CAMERA_MANAGER;

    static {
        PLUGIN = JavaPlugin.getPlugin(AmongUsPlugin.class);
        LOGGER = PLUGIN.getLogger();
        DATA_FOLDER = PLUGIN.getDataFolder();
        CONFIG_FACTORY = new ConfigFactory();
        ARENA_MANAGER = new ArenaManager();
        CONFIG_MANAGER = new ConfigManager();
        GAME_MANAGER = new GameManager();
        try {
            CAMERA_MANAGER = new CameraManager(plugin(), new File(plugin().getDataFolder(), "cameras"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
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

    public static ConfigFactory configFactory() {
        return checkAvailability(CONFIG_FACTORY);
    }

    public static ConfigManager configManager() {
        return checkAvailability(CONFIG_MANAGER);
    }

    public static CameraManager getCameraManager() {
        return checkAvailability(CAMERA_MANAGER);
    }

    private static <T> T checkAvailability(T t) {
        if (!isAvailable) throw new IllegalStateException("Among Us hasn't been loaded yet.");
        return t;
    }

}
