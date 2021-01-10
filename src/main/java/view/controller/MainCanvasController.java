package main.java.view.controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.control.PlayerController;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.item.ItemDTO;
import main.java.core.logic.collision.InvisibleCollisionable;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.personnage.pnjs.Andre;
import main.java.core.personnage.pnjs.John;
import main.java.core.personnage.pnjs.Marie;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;
import main.java.view.MainFrame;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class MainCanvasController extends DefaultCanvasController {

    public MainCanvasController(Joueur player){
        super(player);
    }

    private Image background = new Image(getClass().getResourceAsStream("/img/map.png"));

    @Override
    protected Image getBackgroundImage() {
        return background;
    }

    @Override
    protected void initMapElements() {
        // Add player debug to render
        this.getPlayer().getVisual().setDebugMode(Color.RED);

        // Add pnj
        addPNJ(new John(true));
        addPNJ(new Andre(true));
        addPNJ(new Marie(true));

        // Add Object

        Item book = new Item("book",100,100, true, 2);
        SerializationManager.serializeObject(book.getNom() + ".obj", book);
        addItem(SerializationManager.<ItemDTO>deserializeObject("book.obj").getInstance());

        Item bridge2 = new InteractZone("bridge", 485,505, 20,20,"The bridge is broken and you can't get through it", true, true);
        SerializationManager.serializeObject(bridge2.getNom() + ".obj", bridge2);
        addItem(SerializationManager.<ItemDTO>deserializeObject("bridge.obj").getInstance());

        Item hotel = new InteractZone("hotel", 615,195, 40,1,"You enter the hotel\nThe hall seems huge and totally disproportional\nDo you think the dev is tired or this is wanted ?", true, true);
        SerializationManager.serializeObject(hotel.getNom() + ".obj", hotel);
        addItem(new Item(SerializationManager.<ItemDTO>deserializeObject("hotel.obj")){
            @Override
            public void doAction(PlayerController playerController) {
                MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()));
            }
        });


        loadCollisionElements("main");

    }


}
