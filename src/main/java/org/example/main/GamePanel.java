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

    Thread gameThread;

    Player player;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
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
        final int framesPerSecond = 60; // 60FPS
        final int skipTricks = 1000 / framesPerSecond; // 1000 = one second

        double nextGameTick = System.currentTimeMillis();

        int sleepTime;

        int playerPreviousXValue = player.getX();
        int playerPreviousYValue = player.getY();

        while (gameThread != null) {
            update();
            paintContent();

            nextGameTick += skipTricks;
            sleepTime = (int) (nextGameTick - System.currentTimeMillis());

            if (sleepTime >= 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Shit, we are running behind
            }
            if (player != null) {
                if (player.getX() != playerPreviousXValue || player.getY() != playerPreviousYValue) {
                    System.out.println("Moved");
                }

                playerPreviousXValue = player.getX();
                playerPreviousYValue = player.getY();
            }


        }
    }

    public void update() {

    }

    public void paintContent() {

    }
}
