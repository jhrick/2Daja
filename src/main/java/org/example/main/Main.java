package org.example.main;

import org.example.main.characters.Player;

import javax.swing.*;

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

        HandlerEvent handlerEvent = new HandlerEvent(player);

        gamePanel.addKeyListener(handlerEvent);

        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
