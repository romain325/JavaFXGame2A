package main.java.core.control.action.movement;

import main.java.core.control.PlayerController;
import main.java.core.control.action.Action;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public abstract class MovementAction extends Action {
    public MovementAction(Joueur player) {
        super(player);
    }

    public abstract void move(int velocity);

    @Override
    public void interact() {
        move(this.player.getSpeed());
    }
}
