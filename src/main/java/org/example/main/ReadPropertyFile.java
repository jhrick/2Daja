package org.example.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
    public Properties loadConfig() {
        Properties properties = new Properties();

        try {
            String configFile = "config.properties";
            InputStream inputStream = ReadPropertyFile.class.getClassLoader().getResourceAsStream(configFile);
            if (inputStream == null) {
                throw new RuntimeException("Config file not found: " + configFile);
            }

            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    public BufferedImage accessImage(String variable) {
        Properties config = new ReadPropertyFile().loadConfig();

        String imgPath = config.getProperty(variable);

        File imageFile = new File(imgPath);

        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
