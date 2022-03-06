package ru.ibs.appline.framework.managers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropManager {
    private static PropManager propManager = null;
    private Properties properties = new Properties();

    private PropManager() {
        loadProperties();
    }

    public static PropManager getInstance() {
        if (propManager == null) {
            propManager = new PropManager();
        }
        return propManager;
    }

    public Properties getApplicationProperties() {
        return properties;
    }

    private void loadProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propFile", "application") + ".properties"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
