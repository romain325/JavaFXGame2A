package main.java.core.control.action.movement;

import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Left extends MovementAction {
    public Left(Joueur player) {
        super(player);
    }

    @Override
    public void move(int velocity) {
        this.player.setX(player.getX() - velocity);
    }
}
