package main.java.Core.Personnage;

import main.java.Core.Item.Item;
import main.java.Core.Visual.VisuelPersonnage;

import java.util.List;

public class Personnage {
    private String nom;
    private VisuelPersonnage visual;


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


}
