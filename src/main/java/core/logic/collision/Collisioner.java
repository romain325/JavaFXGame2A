package main.java.core.logic.collision;

import main.java.core.logic.Interactive;
import main.java.utils.Vector;
import main.java.core.visual.VisualPersonnage;
import main.java.core.visual.map.Map;

import javax.management.InstanceNotFoundException;

public class Collisioner {
    private final Map map;
    private final Vector maxSize;

    public Collisioner(Map map, int w, int h){
        this.map = map;
        this.maxSize = new Vector(w,h);
    }

    /**
     * Check if the player is not trying to get out of the map limits
     * @param nextPos nextPlayer position
     * @param joueur the player moving
     * @return will the player be out of the map limits
     */
    public boolean isOutOfMapLimit(Vector nextPos, VisualPersonnage joueur){
        return nextPos.isIn(maxSize, joueur.getWidth(), joueur.getHeight());
    }

    /**
     * Check if the next position is in collision with any Collisionable Object
     * @param nextPos next player position
     * @param joueur current player
     * @return will the player collisioon with an object
     */
    public boolean hasNextPosCollision(Vector nextPos, VisualPersonnage joueur){
        for (var elem: map.getCollisionables()) {
            if(elem.hasCollision() && this.collisionIntersects(elem,nextPos, joueur)){
                return true;
            }
        }
        return false;
    }

    /**
     * get interactive object if any found
     * @param joueur current player
     * @return interactive object in player scope
     * @throws InstanceNotFoundException No interactive object found in player scope
     */
    public Interactive getInteractiveObject(VisualPersonnage joueur) throws InstanceNotFoundException {
        for (Interactive obj: map.getInteractives()) {
            if(this.canInteractWith(obj, joueur)){
                return obj;
            }
        }
        throw new InstanceNotFoundException("No interactive objective found");
    }

    /**
     * can a given interactive object interact with the player
     * @param interactive interactive object to test
     * @param joueur current player
     * @return is the player in the interactive object scope
     */
    private boolean canInteractWith(Interactive interactive, VisualPersonnage joueur){
        return Vector.intersects(
                joueur.getPosition(),
                joueur.getPosition().sum(joueur.getWidth(), joueur.getHeight()),
                interactive.getPosition().sum(interactive.getInteractZone().invert()),
                interactive.getPosition().sum(interactive.getWidth(), interactive.getHeight()).sum(interactive.getInteractZone())
        );
    }

    /**
     * check if a collisionable intersects with the nextPos
     * @param collisionable collisionable
     * @param nextPos next posiiton
     * @param joueur player visual
     * @return is there a collision
     */
    private boolean collisionIntersects(Collisionable collisionable, Vector nextPos, VisualPersonnage joueur){
        return Vector.intersects(
                collisionable.getPosition(), collisionable.getPosition().sum(collisionable.getWidth(), collisionable.getHeight()),
                nextPos, nextPos.sum(joueur.getWidth(), joueur.getHeight())
        );
    }
}
