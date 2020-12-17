package main.java.core.logic;

import main.java.core.logic.movement.Vector;
import main.java.core.visual.VisuelPersonnage;
import main.java.core.visual.map.Map;

public class Collisionner {
    private final Map map;
    private final int width;
    private final int height;

    public Collisionner(Map map, int w, int h){
        this.map = map;
        this.width = w;
        this.height = h;
    }

    public boolean isOutOfMapLimit(Vector nextPos, VisuelPersonnage joueur){
        return (
                nextPos.getX() + joueur.getWidth() > width ||
                nextPos.getX() < 0 ||
                nextPos.getY() + joueur.getHeight()*3 > height ||
                nextPos.getY() < 0
        );
    }
}
