package main.java.view.controller;

import javafx.scene.image.Image;
import main.java.core.personnage.Joueur;

public class Maison1CanvasController extends DefaultCanvasController{

    public Maison1CanvasController(Joueur joueur){
        super(joueur);
    }

    Image background = new Image(getClass().getResourceAsStream("/img/Maison1.png"));


    @Override
    protected Image getBackgroundImage() {
        return background;
    }

    @Override
    protected void initMapElements() {

    }
}
