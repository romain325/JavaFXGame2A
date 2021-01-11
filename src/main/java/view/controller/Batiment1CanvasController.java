package main.java.view.controller;

import javafx.scene.image.Image;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Batiment1CanvasController extends DefaultCanvasController{

    public Batiment1CanvasController(Joueur joueur){
        super(joueur);
        joueur.setPosition(new Vector(345,680));
    }

    Image background = new Image(getClass().getResourceAsStream("/img/Batiment1.png"));

    @Override
    protected Image getBackgroundImage() {
        return background;
    }

    @Override
    protected void initMapElements() {
        loadCollisionElements("batiment1");
    }
}
