package org.example.main.characters;

public class Player {
    private int x;
    private int y;

    final private int speed = 3;

    public Player() {
        x = 0;
        y = 0;
    }

    public void moveToLeft() {
        x -= speed;
    }

    public void moveToRight() {
        x += speed;
    }

    public void moveUp() {
        y += speed;
    }

    public void moveDown() {
        y -= speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
