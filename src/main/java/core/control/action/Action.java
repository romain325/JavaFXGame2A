package main.java.core.control.action;

import main.java.core.control.PlayerController;

public abstract class Action {
    private final PlayerController player;

    public Action(PlayerController player){
        this.player = player;
    }

    /**
     * Action to do on trigger
     */
    public abstract void interact();

    /**
     * get current player controller
     * @return player controller
     */
    protected PlayerController getPlayer(){
        return this.player;
    }
}
