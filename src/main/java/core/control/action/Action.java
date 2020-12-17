package main.java.core.control.action;

import main.java.core.control.PlayerController;

public abstract class Action {
    protected final PlayerController player;

    public Action(PlayerController player){
        this.player = player;
    }

    public abstract void interact();
}
