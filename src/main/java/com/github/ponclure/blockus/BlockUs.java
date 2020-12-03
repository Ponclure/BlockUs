package com.github.ponclure.blockus;

import com.github.ponclure.blockus.arena.ArenaManager;
import com.github.ponclure.blockus.config.ConfigFactory;
import com.github.ponclure.blockus.config.ConfigManager;
import com.github.ponclure.blockus.game.GameManager;
import com.github.ponclure.blockus.implementation.PacketHandlerBase;
import com.github.ponclure.blockus.implementation.ReflectionHandler;
import com.github.ponclure.securitycams.CameraManager;
import com.github.ponclure.simplenpcframework.SimpleNPCFramework;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public final class BlockUs {

    public boolean isAvailable;
    private final BlockUsPlugin PLUGIN;
    private final ArenaManager ARENA_MANAGER;
    private final GameManager GAME_MANAGER;
    private final Logger LOGGER;
    private final File DATA_FOLDER;
    private final ConfigFactory CONFIG_FACTORY;
    private final ConfigManager CONFIG_MANAGER;
    private final PacketHandlerBase PACKET_HANDLER;

    private CameraManager CAMERA_MANAGER;
    private final SimpleNPCFramework NPC_FRAMEWORK;

    public BlockUs(BlockUsPlugin plugin) {
        this.PLUGIN = plugin;
        this.LOGGER = PLUGIN.getLogger();
        this.DATA_FOLDER = PLUGIN.getDataFolder();
        this.CONFIG_FACTORY = new ConfigFactory();
        this.ARENA_MANAGER = new ArenaManager();
        this.CONFIG_MANAGER = new ConfigManager();
        this.PACKET_HANDLER = ReflectionHandler.getNewPacketHandlerInstance();
        this.GAME_MANAGER = new GameManager();
        try {
            this.CAMERA_MANAGER = new CameraManager(plugin(), new File(plugin().getDataFolder(), "cameras"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        this.NPC_FRAMEWORK = new SimpleNPCFramework(plugin());
    }

    public BlockUsPlugin plugin() {
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

    public PacketHandlerBase getPacketHandler() { return checkAvailability(PACKET_HANDLER); }

    public CameraManager getCameraManager() {
        return checkAvailability(CAMERA_MANAGER);
    }

    public SimpleNPCFramework getNpcFramework() {
        return checkAvailability(NPC_FRAMEWORK);
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean b) {
        this.isAvailable = b;
    }

    private <T> T checkAvailability(T t) {
        if (!getAvailability()) throw new IllegalStateException("Block Us hasn't been loaded yet.");
        return t;
    }

}
