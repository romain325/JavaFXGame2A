package main.java.core.logic.collision;

import main.java.core.logic.Interactive;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.VisuelPersonnage;
import main.java.core.visual.map.Map;

import javax.management.InstanceNotFoundException;

public class Collisionner {
    private final Map map;
    private final Vector maxSize;

    public Collisionner(Map map, int w, int h){
        this.map = map;
        this.maxSize = new Vector(w,h);
    }

    public boolean isOutOfMapLimit(Vector nextPos, VisuelPersonnage joueur){
        return nextPos.isIn(maxSize, joueur.getWidth(), joueur.getHeight());
    }

    public boolean hasNextPosCollision(Vector nextPos, VisuelPersonnage joueur){
        for (var elem: map.getCollisionables()) {
            if(elem.hasCollision() && this.collisionIntersects(elem,nextPos, joueur)){
                return true;
            }
        }
        return false;
    }

    public Interactive getInteractiveObject(VisuelPersonnage joueur) throws InstanceNotFoundException {
        for (Interactive obj: map.getInteractives()) {
            if(!this.canInteractWith(obj, joueur)){
                return obj;
            }
        }
        throw new InstanceNotFoundException("No interactive objective found");
    }

    private boolean canInteractWith(Interactive interactive, VisuelPersonnage joueur){
        return joueur.getPosition().isIn(interactive.getPosition().sum(interactive.getInteractZone().invert()), interactive.getPosition().sum(interactive.getInteractZone()), joueur.getWidth(), joueur.getHeight());
    }

    private boolean collisionIntersects(Collisionable collisionable, Vector nextPos,VisuelPersonnage joueur){
        return Vector.intersects(
                collisionable.getPosition(), collisionable.getPosition().sum(collisionable.getWidth(), collisionable.getHeight()),
                nextPos, nextPos.sum(joueur.getWidth(), joueur.getHeight())
        );
    }
}
