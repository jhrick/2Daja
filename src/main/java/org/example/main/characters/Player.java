package org.example.main.characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

public class Player {
    private int x;
    private int y;

    final private int speed = 3;

    private final BufferedImage playerSprite;

    public Player() {
        x = 0;
        y = 0;

        BufferedReader reader;

        Properties properties = new Properties();

        final String configFile = "src/main/resources/config.properties";

        String playerSpritePath;

        try {
            reader = new BufferedReader(new FileReader(configFile));

            properties.load(reader);

            playerSpritePath = properties.getProperty("player_sprite");

            File imgFile = new File(playerSpritePath);

            playerSprite = ImageIO.read(imgFile);

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveToLeft() {
        x -= speed;
    }

    public void moveToRight() {
        x += speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void renderPlayer(Graphics g) {
        if (playerSprite != null) {
            g.drawImage(playerSprite, getX(), getY(), null);
        }
    }
}
