package main.java.core.personnage;

import main.java.core.item.Item;

import java.util.Collection;

public class Joueur extends Personnage {
    private Collection<Item> inventaire;
    private boolean soupcon = false;

    public Joueur(String nom) {
        super(nom);
    }

    public void setCoord(int x, int y){
        setX(x);
        setY(y);
    }

    @Override
    public void setX(int x) {
        //TODO Add collision Check
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        //TODO Add collision Check
        super.setY(y);
    }

    public boolean hasSoupcon() {
        return soupcon;
    }

    public void setSoupcon(boolean soupcon) {
        this.soupcon = soupcon;
    }

}
