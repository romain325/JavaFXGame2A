package main.java.core.logic;

import main.java.core.control.PlayerController;
import main.java.core.logic.movement.Vector;

import java.io.Serializable;

public interface Interactive {
    boolean isInteractive();
    void interact(PlayerController playerController);
    Vector getInteractZone();
    Vector getPosition();
    int getHeight();
    int getWidth();
    boolean isBusy();
}
