package org.example.main;

import org.example.main.characters.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HandlerEvent implements KeyListener {
    Player player;

    public HandlerEvent(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT -> player.moveToLeft();
            case KeyEvent.VK_RIGHT -> player.moveToRight();
            case KeyEvent.VK_UP -> player.moveUp();
            case KeyEvent.VK_DOWN -> player.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
