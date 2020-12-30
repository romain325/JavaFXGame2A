package main.java.core.logic.collision;

import main.java.core.logic.movement.Vector;

public interface Collisionable {
    Vector getPosition();
    int getHeight();
    int getWidth();
    boolean hasCollision();
}
