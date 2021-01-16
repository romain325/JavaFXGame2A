package main.java.core.personnage;

import main.java.utils.Vector;
import main.java.core.visual.VisuelPersonnage;

public class Personnage {
    private final String nom;
    protected VisuelPersonnage visual;


    public Personnage(String nom){
        this.nom = nom;
        this.visual = new VisuelPersonnage(0,0);
    }

    public void setX(int x){
        visual.setCoordX(x);
    }

    public void setY(int y){
        visual.setCoordY(y);
    }

    public int getX(){
        return visual.getCoordX();
    }

    public int getY(){
        return visual.getCoordY();
    }

    public String getNom() { return this.nom; }

    public Vector getPosition() { return visual.getPosition();}
    public void setPosition(Vector vector) { visual.setPosition(vector);}

    public VisuelPersonnage getVisual(){
        return this.visual;
    }
}
