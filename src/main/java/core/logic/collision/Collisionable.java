package main.java.core.logic.collision;

import main.java.utils.Vector;

public interface Collisionable {
    /**
     * getter
     * @return valuer
     */
    Vector getPosition();
    /**
     * getter
     * @return valuer
     */
    int getHeight();
    /**
     * getter
     * @return valuer
     */
    int getWidth();
    /**
     * getter
     * @return valuer
     */
    boolean hasCollision();
}
