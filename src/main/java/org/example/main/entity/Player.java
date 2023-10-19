package org.example.main.entity;

import org.example.main.GamePanel;
import org.example.main.KeyHandler;
import org.example.main.ReadPropertyFile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gp;

    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    private void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        ReadPropertyFile readPropertyFile = new ReadPropertyFile();

        up1 = readPropertyFile.accessImage("player_up_1");
        up2 = readPropertyFile.accessImage("player_up_2");
        down1 = readPropertyFile.accessImage("player_down_1");
        down2 = readPropertyFile.accessImage("player_down_2");
        left1 = readPropertyFile.accessImage("player_left_1");
        left2 = readPropertyFile.accessImage("player_left_2");
        right1 = readPropertyFile.accessImage("player_right_1");
        right2 = readPropertyFile.accessImage("player_right_2");

    }

    public void update() {
        if (keyH.downPressed || keyH.leftPressed || keyH.upPressed || keyH.rightPressed) {
            if (keyH.downPressed) {
                y += speed;
                direction = "down";
            } else if (keyH.upPressed) {
                y -= speed;
                direction = "up";
            } else if (keyH.rightPressed) {
                x += speed;
                direction = "right";
            } else {
                x -= speed;
                direction = "left";
            }

            spriteCount++;

            if (spriteCount == 15) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCount = 0;
            }
        }


    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else {
                    image = down2;
                }
                break;
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else {
                    image = up2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else {
                    image = right2;
                }
                break;

        }
        ;

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
