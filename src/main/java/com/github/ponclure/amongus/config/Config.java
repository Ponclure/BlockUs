package com.github.ponclure.amongus.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface Config {

    void load();

    void load(Consumer<? super Exception> exceptionHandler);

    void loadAsync();

    void loadAsync(Consumer<? super Config> handler);

    void loadAsync(Consumer<? super Config> handler, Consumer<? super Exception> exceptionHandler);

    void save();

    void save(Consumer<? super IOException> exceptionHandler);

    void saveAsync();

    void saveAsync(Consumer<? super IOException> exceptionHandler);

    FileConfiguration getConfig();

    Object get(String path);

    Object get(String path, Object fallback);

    String getString(String path);

    String getString(String path, String fallback);

    int getInt(String path);

    int getInt(String path, int fallback);

    double getDouble(String path);

    double getDouble(String path, double fallback);

    boolean getBoolean(String path);

    boolean getBoolean(String path, boolean fallback);

    List<?> getList(String path);

    List<?> getList(String path, List<?> fallback);

    <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> type);

    <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> type, T fallback);

    boolean isSet(String path);

}
