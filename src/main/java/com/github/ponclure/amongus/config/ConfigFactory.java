package com.github.ponclure.amongus.config;

import java.io.File;

public final class ConfigFactory {

    public ConfigFactory() {
    }

    public Config supplyConfig(File path, String name, ConfigType type) {
        return new ConfigBase(type.supplyFile(path, name), type.supplyConfig());
    }

    public Config supplyConfig(String path, String name, ConfigType type) {
        return new ConfigBase(type.supplyFile(path, name), type.supplyConfig());
    }

}
