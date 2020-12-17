package main.java.core.control.action;

import main.java.core.control.PlayerController;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Idle extends Action {
    public Idle(PlayerController player) {
        super(player);
    }

    @Override
    public void interact() {
        return;
    }
}
