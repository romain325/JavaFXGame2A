package main.java.core.control.action.movement;

import main.java.core.control.PlayerController;
import main.java.core.control.action.Action;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public abstract class MovementAction extends Action {
    public MovementAction(PlayerController player) {
        super(player);
    }

    public void moveTo(Vector newPos){
        this.player.getJoueur().setCoord(newPos);
    }
    protected abstract Vector getMovementVector(int velocity);

    @Override
    public void interact() {
        Vector finalPos = player.getJoueur().getPosition().sum(this.getMovementVector(this.player.getJoueur().getSpeed()));
        if(
            player.getCollisionner().isOutOfMapLimit(finalPos, player.getJoueur().getVisual()) ||
            player.getCollisionner().hasNextPosCollision(finalPos, player.getJoueur().getVisual())
        ){
            return;
        }
        moveTo(finalPos);
    }
}
