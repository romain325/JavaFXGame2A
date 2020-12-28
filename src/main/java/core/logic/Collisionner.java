package main.java.core.logic;

import main.java.core.logic.movement.Vector;
import main.java.core.visual.Visuel;
import main.java.core.visual.VisuelPersonnage;
import main.java.core.visual.map.Map;

import javax.management.AttributeNotFoundException;
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

    public Interactive getInteractiveObject(VisuelPersonnage joueur) throws InstanceNotFoundException {
        for (Interactive obj: map.getInteractives()) {
            if(!this.canInteractWith(obj, joueur)){
                return obj;
            }
        }
        throw new InstanceNotFoundException("No interactive objective found");
    }

    private boolean canInteractWith(Interactive interactive, VisuelPersonnage joueur){
        return joueur.getPosition().isIn(interactive.getPos().sum(interactive.getInteractZone().invert()), interactive.getPos().sum(interactive.getInteractZone()), joueur.getWidth(), joueur.getHeight());
    }
}
