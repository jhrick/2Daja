package org.example.main;

import org.example.main.characters.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2Daja");

        GamePanel gamePanel = new GamePanel();
        gamePanel.setFocusable(true);

        gamePanel.startGameThread();

        Player player = new Player();

        gamePanel.setPlayer(player);

        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT) {
                    player.moveToLeft();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    player.moveToRight();
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
