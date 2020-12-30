package main.java.core.logic;

import main.java.core.logic.movement.Vector;

public interface Interactive {
    boolean isInteractive();
    void interact();
    Vector getInteractZone();
    Vector getPosition();
    boolean isBusy();
}
