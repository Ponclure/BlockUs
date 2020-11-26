package com.github.ponclure.amongus;

import com.github.ponclure.amongus.arena.ArenaManager;
import com.github.ponclure.amongus.config.ConfigFactory;
import com.github.ponclure.amongus.config.ConfigManager;
import com.github.ponclure.amongus.game.GameManager;

import com.github.ponclure.securitycams.CameraManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public final class AmongUs {

    public boolean isAvailable;
    private final AmongUsPlugin PLUGIN;
    private final ArenaManager ARENA_MANAGER;
    private final GameManager GAME_MANAGER;
    private final Logger LOGGER;
    private final File DATA_FOLDER;
    private final ConfigFactory CONFIG_FACTORY;
    private final ConfigManager CONFIG_MANAGER;

    private CameraManager CAMERA_MANAGER;

    public AmongUs(AmongUsPlugin plugin) {
        this.PLUGIN = plugin;
        this.LOGGER = PLUGIN.getLogger();
        this.DATA_FOLDER = PLUGIN.getDataFolder();
        this.CONFIG_FACTORY = new ConfigFactory();
        this.ARENA_MANAGER = new ArenaManager();
        this.CONFIG_MANAGER = new ConfigManager();
        this.GAME_MANAGER = new GameManager();
        try {
            this.CAMERA_MANAGER = new CameraManager(plugin(), new File(plugin().getDataFolder(), "cameras"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public AmongUsPlugin plugin() {
        return checkAvailability(PLUGIN);
    }

    public ArenaManager arenaManager() {
        return checkAvailability(ARENA_MANAGER);
    }

    public GameManager gameManager() {
        return checkAvailability(GAME_MANAGER);
    }

    public Logger logger() {
        return checkAvailability(LOGGER);
    }

    public File dataFolder() {
        return checkAvailability(DATA_FOLDER);
    }

    public ConfigFactory configFactory() {
        return checkAvailability(CONFIG_FACTORY);
    }

    public ConfigManager configManager() {
        return checkAvailability(CONFIG_MANAGER);
    }

    public CameraManager getCameraManager() {
        return checkAvailability(CAMERA_MANAGER);
    }

    public boolean getAvailability() { return isAvailable; }

    public void setAvailability(boolean b) { this.isAvailable = b; }

    private <T> T checkAvailability(T t) {
        if (!getAvailability()) throw new IllegalStateException("Among Us hasn't been loaded yet.");
        return t;
    }

}
