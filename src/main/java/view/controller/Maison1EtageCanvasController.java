package main.java.view.controller;

import javafx.scene.image.Image;
import main.java.core.personnage.Joueur;

public class Maison1EtageCanvasController extends DefaultCanvasController{

    public Maison1EtageCanvasController(Joueur joueur){
        super(joueur);
    }

    Image background = new Image(getClass().getResourceAsStream("/img/Maison1Etage.png"));


    @Override
    protected Image getBackgroundImage() {
        return background;
    }

    @Override
    protected void initMapElements() {

    }
}
