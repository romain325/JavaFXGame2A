package main.java.core.control.action.movement;

import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Up extends MovementAction {
    public Up(Joueur player) {
        super(player);
    }

    @Override
    public void move(int velocity) {
        this.player.setY(player.getY() - velocity);
    }
}
