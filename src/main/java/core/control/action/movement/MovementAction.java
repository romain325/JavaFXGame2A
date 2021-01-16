package main.java.core.control.action.movement;

import main.java.core.control.PlayerController;
import main.java.core.control.action.Action;
import main.java.utils.Vector;

public abstract class MovementAction extends Action {
    public MovementAction(PlayerController player) {
        super(player);
    }

    /**
     * Move the player to the specified place
     * @param newPos new player positio
     */
    public void moveTo(Vector newPos){
        getPlayer().getJoueur().setCoord(newPos);
    }

    /**
     * get adapated movement vector
     * @param velocity player velocity
     * @return adapted movement vector
     */
    protected abstract Vector getMovementVector(int velocity);

    @Override
    public void interact() {
        Vector finalPos = getPlayer().getJoueur().getPosition().sum(this.getMovementVector(this.getPlayer().getJoueur().getSpeed()));
        if(
                getPlayer().getCollisionner().isOutOfMapLimit(finalPos, getPlayer().getJoueur().getVisual()) ||
                getPlayer().getCollisionner().hasNextPosCollision(finalPos, getPlayer().getJoueur().getVisual())
        ){
            return;
        }
        moveTo(finalPos);
    }
}
