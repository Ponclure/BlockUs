package com.github.ponclure.amongus.config;

import com.github.ponclure.amongus.AmongUs;
import com.github.ponclure.amongus.AmongUsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class ConfigBase implements Config {

    protected final AmongUsPlugin pluginInstance = AmongUs.plugin();
    protected final BukkitScheduler scheduler = Bukkit.getScheduler();
    protected final FileConfiguration configuration;
    protected final File file;

    ConfigBase(File file, FileConfiguration configuration) {
        this.configuration = configuration;
        this.file = file;
    }

    @Override
    public void load()  {
        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load(Consumer<? super Exception> exceptionHandler) {
        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            exceptionHandler.accept(e);
        }
    }

    @Override
    public void loadAsync() {
        scheduler.runTaskAsynchronously(pluginInstance,() -> {
            try {
                configuration.load(file);
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void loadAsync(Consumer<? super Config> handler) {
        scheduler.runTaskAsynchronously(pluginInstance,() -> {
            try {
                configuration.load(file);
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            } finally {
                handler.accept(this);
            }
        });
    }

    @Override
    public void loadAsync(Consumer<? super Config> handler, Consumer<? super Exception> exceptionHandler) {
        scheduler.runTaskAsynchronously(pluginInstance,() -> {
            try {
                configuration.load(file);
            } catch (IOException | InvalidConfigurationException e) {
                exceptionHandler.accept(e);
            } finally {
                handler.accept(this);
            }
        });
    }

    @Override
    public void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Consumer<? super IOException> exceptionHandler) {
        try {
            configuration.save(file);
        } catch (IOException e) {
            exceptionHandler.accept(e);
        }
    }

    @Override
    public void saveAsync() {
        scheduler.runTaskAsynchronously(pluginInstance,() -> {
            try {
                configuration.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void saveAsync(Consumer<? super IOException> exceptionHandler) {
        scheduler.runTaskAsynchronously(pluginInstance,() -> {
            try {
                configuration.save(file);
            } catch (IOException e) {
                exceptionHandler.accept(e);
            }
        });
    }

    @Override
    public FileConfiguration getConfig() {
        return configuration;
    }

    @Override
    public Object get(String path) {
        return configuration.get(path);
    }

    @Override
    public Object get(String path, Object fallback) {
        return configuration.get(path, fallback);
    }

    @Override
    public String getString(String path) {
        return configuration.getString(path);
    }

    @Override
    public String getString(String path,
                            String fallback) {
        return configuration.getString(path,fallback);
    }

    @Override
    public int getInt(String path) {
        return configuration.getInt(path);
    }

    @Override
    public int getInt(String path, int fallback) {
        return configuration.getInt(path, fallback);
    }

    @Override
    public double getDouble(String path) {
        return configuration.getDouble(path);
    }

    @Override
    public double getDouble(String path, double fallback) {
        return configuration.getDouble(path,fallback);
    }

    @Override
    public boolean getBoolean(String path) {
        return configuration.getBoolean(path);
    }

    @Override
    public boolean getBoolean(String path, boolean fallback) {
        return configuration.getBoolean(path, fallback);
    }

    @Override
    public List<?> getList(String path) {
        return configuration.getList(path);
    }

    @Override
    public List<?> getList(String path, List<?> fallback) {
        return configuration.getList(path, fallback);
    }

    @Override
    public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> type) {
        return configuration.getSerializable(path,type);
    }

    @Override
    public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> type, T fallback) {
        return configuration.getSerializable(path,type,fallback);
    }

    @Override
    public boolean isSet(String path) {
        return configuration.isSet(path);
    }
}
