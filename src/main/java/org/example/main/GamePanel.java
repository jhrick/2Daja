package org.example.main;

import org.example.main.characters.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //screen settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRows = 12;
    final int screenWidth = maxScreenCol * tileSize; // 768px
    final int screenHeight = maxScreenRows * tileSize; // 576px

    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
