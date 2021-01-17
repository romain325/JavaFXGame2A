package main.java.view.controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.item.ItemDTO;
import main.java.utils.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.visual.ui.InfoBox;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;

public class MainCanvasController extends DefaultCanvasController {

    public MainCanvasController(Joueur player){
        super(player);
        this.getPlayer().setPosition(new Vector(440,505));
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
        addPNJ(new PNJ("John",new Vector(100,605), false));
        addPNJ(new PNJ("Marie",new Vector(200,200)));
        addPNJ(new PNJ("Andre",new Vector(100,100)));

        // Add Object
        new Item("bookGarden",65,490,"This book is all covered in blood\nYou can distinguish a drawing of the town\nYou read the initials \"S.A.\"", 2, 1).save();
        addItem(SerializationManager.<ItemDTO>deserializeObject("bookGarden.obj").getInstance());

        new Item("letterFountain",610,295,"There is a little letter but it is signed as after tomorrow\nIt certainly is an error", 1, 2).save();
        addItem(SerializationManager.<ItemDTO>deserializeObject("letterFountain.obj").getInstance());

        // Add Interaction Zone
        Item fountain = new InteractZone("fountain", 610,230, 40,40,"Something is floating in the middle of the fountain\nIt comes closer to you and\nyou distinguish a finger\nThere is velvet under the nail", true, false);
        fountain.setHintValue(1);
        fountain.save();
        addItem(SerializationManager.<ItemDTO>deserializeObject("fountain.obj").getInstance());

        new InteractZone("bridge", 485,505, 20,20,"The bridge is broken and you can't get through it", true, true).save();
        addItem(SerializationManager.<ItemDTO>deserializeObject("bridge.obj").getInstance());

        new InteractZone("hotel", 615,195, 40,1,"You enter the hotel\nThe hall seems huge and totally disproportional\nDo you think the dev is tired or this is wanted ?", true, true).save();
        addItem(new Item(SerializationManager.deserializeObject("hotel.obj"), playerController -> navigator.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()))));


        loadCollisionElements("main");

    }

    @Override
    protected void addIntroGameLoop() {
        if(getOpacity() <= 0.15) {
            new InfoBox("Night has fallen, you get back to the hotel");
            setOpacity(1);
            navigator.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()));
        }else {
            setOpacity(getOpacity() - 0.0005);
        }
    }
}
