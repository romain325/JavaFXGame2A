package main.java.core.control.action.movement;

import main.java.core.control.PlayerController;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Down extends MovementAction {
    public Down(PlayerController player) {
        super(player);
    }

    @Override
    protected Vector getMovementVector(int velocity) {
        return new Vector(0,velocity);
    }
}
