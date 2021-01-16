package main.java.core.logic;

import main.java.core.control.PlayerController;

public interface Action {
    /**
     * an action to do
     * @param playerController the player controller to interact with the player
     */
    void doAction(PlayerController playerController);
}
