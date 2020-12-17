package main.java.core.personnage;

import main.java.core.item.Item;

import java.util.Collection;

public class Joueur extends Personnage {
    private Collection<Item> inventaire;
    private boolean soupcon = false;
    private int speed;

    public Joueur(String nom, int speed) {
        super(nom);
        this.speed = speed;
    }

    public Joueur(String nom) {
        this(nom,5);
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

    public int getSpeed(){
        return this.speed;
    }

}
