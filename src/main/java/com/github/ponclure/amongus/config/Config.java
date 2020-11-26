package com.github.ponclure.amongus.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface Config {

	public void load();

	public void load(Consumer<? super Exception> exceptionHandler);

	public void loadAsync();

	public void loadAsync(Consumer<? super Config> handler);

	public void loadAsync(Consumer<? super Config> handler, Consumer<? super Exception> exceptionHandler);

	public void save();

	public void save(Consumer<? super IOException> exceptionHandler);

	public void saveAsync();

	public void saveAsync(Consumer<? super IOException> exceptionHandler);

	public FileConfiguration getConfig();

	public Object get(String path);

	public Object get(String path, Object fallback);

	public String getString(String path);

	public String getString(String path, String fallback);

	public int getInt(String path);

	public int getInt(String path, int fallback);

	public double getDouble(String path);

	public double getDouble(String path, double fallback);

	public boolean getBoolean(String path);

	public boolean getBoolean(String path, boolean fallback);

	public List<?> getList(String path);

	public List<?> getList(String path, List<?> fallback);

	public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> type);

	public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> type, T fallback);

	public boolean isSet(String path);

}
