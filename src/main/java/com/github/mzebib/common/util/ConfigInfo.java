package com.github.mzebib.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mzebib
 */
public class ConfigInfo {

    private String name;
    private String description;
    private String version;
    private Map<String, Object> configParams = new HashMap<>();

    public ConfigInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Object> getConfigParams() {
        return configParams;
    }

    public void setConfigParams(Map<String, Object> configParams) {
        this.configParams = configParams;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", configParams=" + configParams +
                '}';
    }
}
