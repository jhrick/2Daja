package org.example.main.characters;

public class Player {
    private int x;
    private int y;

    final private int tileSize = 48;

    public Player() {
        x = 0;
        y = 0;
    }

    public void moveToLeft() {
        x -= tileSize;
    }

    public void moveToRight() {
        x += tileSize;
    }

    public void moveUp() {
        y += tileSize;
    }

    public void moveDown() {
        y -= tileSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
