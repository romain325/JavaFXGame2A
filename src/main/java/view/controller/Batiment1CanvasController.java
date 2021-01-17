package main.java.view.controller;

import javafx.scene.image.Image;
import main.java.core.control.PlayerController;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.item.ItemDTO;
import main.java.utils.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.visual.ui.InfoBox;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;

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
                endDay();
            }
        });

        //Add Object
        Item registeryHotel = new InteractZone("registeryHotel", 655,20, 20,20,"A registery of the hotel staff\nYou recognize the receptionist !\nHis name is \"Sir Alfred\"", true, false);
        registeryHotel.setHintValue(1);
        registeryHotel.save();
        addItem(SerializationManager.<ItemDTO>deserializeObject("registeryHotel.obj").getInstance());

        loadCollisionElements("batiment1");
    }

    /**
     * end the day
     */
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
