package main.java.core.logic;

import main.java.core.logic.movement.Vector;

public interface Interactive {
    void interact();
    Vector getInteractZone();
    Vector getPos();
    boolean isBusy();
}
