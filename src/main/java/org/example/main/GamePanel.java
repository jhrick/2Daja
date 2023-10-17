package org.example.main;

import org.example.main.characters.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRows = 12;
    final int screenWidth = maxScreenCol * tileSize; // 768px
    final int screenHeight = maxScreenRows * tileSize; // 576px

    // FPS
    final int FPS = 60;

    Thread gameThread;

    KeyHandler keyH = new KeyHandler();

    Player player;

    public int playerX = 100;
    public int playerY = 100;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        if (keyH.downPressed) {
            playerY += 4;
        } else if (keyH.upPressed) {
            playerY -= 4;
        } else if (keyH.rightPressed) {
            playerX += 4;
        } else if (keyH.leftPressed) {
            playerX -= 4;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
    }
}
