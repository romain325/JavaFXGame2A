package main.java.core.item;

import javafx.fxml.Initializable;
import main.java.core.logic.Consommable;
import main.java.core.logic.Interactive;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.Visuel;
import main.java.core.visual.sprite.StaticItemSprite;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class Item implements Interactive, Consommable, Initializable {
    private boolean isBusy = false;
    private boolean isConsumed = false;
    private boolean isInteractive = true;

    protected final Vector interactZone = new Vector(30,30);

    private final String nom;
    protected Visuel visual;

    public Item(String nom){
        this.nom = nom;
        this.visual = new StaticItemSprite(0,0, this.nom);
        initialize(null,null);
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

    @Override
    public Vector getPos() { return visual.getPosition(); }

    public Visuel getVisual(){
        return this.visual;
    }

    @Override
    public Vector getInteractZone() {
        return this.interactZone;
    }

    @Override
    public boolean isInteractive() {
        return isInteractive;
    }

    @Override
    public boolean isBusy() {
        return isBusy;
    }

    @Override
    public boolean isConsumed() {
        return isConsumed;
    }

    @Override
    public void consume() {
        isConsumed = true;
        isInteractive = false;
        visual.setVisible(false);
        this.setX(-120);
        this.setY(-120);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        return;
    }

}
