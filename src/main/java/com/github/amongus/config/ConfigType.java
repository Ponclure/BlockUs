package com.github.amongus.config;

import com.github.amongus.utility.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

public enum ConfigType {
    YML(".yml",YamlConfiguration::new);

    private final String suffix;
    private final Supplier<FileConfiguration> supplier;

    ConfigType(String suffix,
               Supplier<FileConfiguration> supplier) {
        this.suffix = suffix;
        this.supplier = supplier;
    }

    public String getSuffix() {
        return suffix;
    }

    public File supplyFile(File directory,
                           String name) {
        return new File(directory, name+suffix);
    }

    public File supplyFile(String directory,
                           String name) {
        return new File(directory, name+suffix);
    }

    public FileConfiguration supplyConfig() {
        return supplier.get();
    }
}
