package org.example.main;

import org.example.main.entity.Player;

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
        double drawInterval = (double) 1000000000 /FPS; // 0.016666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                drawCount++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                timer = 0;
                drawCount = 0;
            }

        }
    }

    public void update() {
        if (keyH.downPressed) {
            player.moveDown();
        } else if (keyH.upPressed) {
            player.moveUp();
        } else if (keyH.rightPressed) {
            player.moveToRight();
        } else if (keyH.leftPressed) {
            player.moveToLeft();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.renderPlayer(g2);
    }
}
