package main.java.core.personnage;

import main.java.utils.Vector;
import main.java.core.visual.VisualPersonnage;

public abstract class Personnage {
    private final String nom;
    protected VisualPersonnage visual;


    public Personnage(String nom){
        this.nom = nom;
        this.visual = new VisualPersonnage(0,0);
    }

    /**
     * set visual's x coord
     * @param x coord x
     */
    public void setX(int x){
        visual.setCoordX(x);
    }

    /**
     * set visual's y coord
     * @param y coord y
     */
    public void setY(int y){
        visual.setCoordY(y);
    }

    /**
     * get X coord
     * @return x coord
     */
    public int getX(){
        return visual.getCoordX();
    }

    /**
     * get y coord
     * @return y coord
     */
    public int getY(){
        return visual.getCoordY();
    }

    /**
     * get player's name
     * @return player's name
     */
    public String getNom() { return this.nom; }

    /**
     * get player's position
     * @return player's position
     */
    public Vector getPosition() { return visual.getPosition();}

    /**
     * set player's position
     * @param vector new player position
     */
    public void setPosition(Vector vector) { visual.setPosition(vector);}

    /**
     * get player's visual
     * @return player's visual
     */
    public VisualPersonnage getVisual(){
        return this.visual;
    }
}
