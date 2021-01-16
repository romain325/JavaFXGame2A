package main.java.core.control.action.movement;

import main.java.core.control.PlayerController;
import main.java.utils.Vector;

public class Right extends MovementAction {
    public Right(PlayerController player) {
        super(player);
    }

    @Override
    protected Vector getMovementVector(int velocity) {
        return new Vector(velocity,0);
    }
}
