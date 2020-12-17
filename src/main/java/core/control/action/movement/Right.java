package main.java.core.control.action.movement;

import main.java.core.control.PlayerController;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Right extends MovementAction {
    public Right(PlayerController player) {
        super(player);
    }

    @Override
    protected Vector getMovementVector(int velocity) {
        return new Vector(velocity,0);
    }
}
