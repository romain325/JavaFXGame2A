package main.java.core.control.action;

import main.java.core.control.PlayerController;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public abstract class Action {
    protected final Joueur player;

    public Action(Joueur player){
        this.player = player;
    }

    public abstract void interact();
}
