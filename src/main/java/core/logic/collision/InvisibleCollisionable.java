package main.java.core.logic.collision;

import main.java.core.logic.movement.Vector;

public class InvisibleCollisionable implements Collisionable{
    private final Vector position;
    private final int height;
    private final int width;

    public InvisibleCollisionable(Vector position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector getPosition() {
        return position;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean hasCollision() {
        return true;
    }
}
