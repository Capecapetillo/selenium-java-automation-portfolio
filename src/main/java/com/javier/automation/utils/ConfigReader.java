package com.javier.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {

        properties = new Properties();

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties");
        
        if (inputStream == null) {
            throw new RuntimeException("config.properties file not found");
        }
        
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        
        
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
