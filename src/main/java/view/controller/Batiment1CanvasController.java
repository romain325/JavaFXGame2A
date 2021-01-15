package main.java.view.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;
import main.java.core.control.PlayerController;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.item.ItemDTO;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.visual.ui.InfoBox;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;

import java.lang.reflect.Method;

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
        addPNJ(new PNJ("Hotelier", new Vector(350,250)){
            @Override
            public void interact(PlayerController playerController) {
                new Timeline(new KeyFrame(Duration.seconds(2), actionEvent -> {
                    endDay();
                })).play();
            }
        });

        //Add Object
        Item registeryHotel = new InteractZone("registeryHotel", 655,20, 20,20,"A registery of the hotel staff\nYou recognize the receptionist !\nHis name is \"Sir Alfred\"", true, false);
        registeryHotel.setHintValue(1);
        SerializationManager.serializeObject(registeryHotel.getNom() + ".obj", registeryHotel);
        addItem(SerializationManager.<ItemDTO>deserializeObject("registeryHotel.obj").getInstance());

        loadCollisionElements("batiment1");
    }

    private void endDay(){
        // Checkpoint
        getPlayer().save();
        getPlayer().getAdvancement().addDay();

        if(PNJ.NIVEAU_FOLIE > 7 || getPlayer().getAdvancement().hasSuspicion()){
            navigator.switchScene(FRAME.GAME_OVER, false);
            return;
        }

        new InfoBox("13 November 1990, 08:00 AM, feel like the " + getPlayer().getAdvancement().getDayElapsed() + " day in this weird town");
        navigator.switchScene(FRAME.PLAYABLE_CANVAS, true, new MainCanvasController(getPlayer()));
    }
}
