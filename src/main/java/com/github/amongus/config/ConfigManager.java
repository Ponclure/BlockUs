package com.github.amongus.config;

import com.github.amongus.AmongUs;
import com.github.amongus.arena.ArenaManager;
import com.github.amongus.game.GameSettings;
import com.github.amongus.utility.Namespace;
import org.bukkit.Bukkit;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class ConfigManager {

    private static final Pattern PATTERN = Pattern.compile("[.yml]+$",Pattern.CASE_INSENSITIVE);

    private final File dataFolder = AmongUs.dataFolder();
    private final ConfigFactory configFactory = AmongUs.configFactory();
    private final Config defaultConfig;

    public ConfigManager() {
        defaultConfig = configFactory.supplyConfig(dataFolder,"config",ConfigType.YML);
    }

    public void load() {
        Logger logger = AmongUs.logger();
        defaultConfig.loadAsync(cfg -> {},exc -> logger.info("Couldn't load config: " + exc.toString()));
        loadArenas();
    }

    private void loadArenas() {
        ArenaManager manager = AmongUs.arenaManager();
        for (File file : dataFolder.listFiles()) {
            if (file.isDirectory()) {
                continue;
            }
            if (!file.getName().endsWith(ConfigType.YML.getSuffix())) {
                continue;
            }
            Config config;
            String name = PATTERN.matcher(file.getName()).replaceFirst("");
            config = configFactory.supplyConfig(dataFolder+"/arenas/",name,ConfigType.YML);
            config.loadAsync(cfg -> {
                Namespace namespace = Namespace.of(name);
                String displayName = cfg.getString("DisplayName");
                GameSettings defaultSettings = getSettings(cfg);
                UUID worldUuid = Bukkit.getWorld(cfg.getString("World")).getUID();
                Vector min = getVector(config,"Arena.Min.");
                Vector max = getVector(config,"Arena.Max.");
                Vector lobbySpawn = getVector(config,"Spawn.Game.");
                Vector gameSpawn = getVector(config,"Spawn.Lobby.");
                manager.loadArena(
                        namespace,
                        displayName,
                        defaultSettings,
                        BoundingBox.of(min,max),
                        worldUuid,
                        lobbySpawn,
                        gameSpawn
                );
            });
        }
    }

    private Vector getVector(Config config,String basePath) {
        double x,y,z;
        x = config.getDouble(basePath+".X");
        y = config.getDouble(basePath+".Y");
        z = config.getDouble(basePath+".Z");
        return new Vector(x,y,z);
    }

    private GameSettings getSettings(Config config) {
        String path = "GameSettings.";
        return new GameSettings.Builder()
                .setCommonTaskCount(config.getInt(path+"CommonTaskCount"))
                .setConfirmingEjections(config.getBoolean(path+"ConfirmingEjections"))
                .setCrewmateVision(config.getDouble(path+"CrewmateVision"))
                .build();
    }

    public Config getDefaultConfig() {
        return defaultConfig;
    }
}
