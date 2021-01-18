package main.java.view.controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.item.ItemDTO;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.visual.ui.InfoBox;
import main.java.utils.Vector;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;

public class MainCanvasController extends DefaultCanvasController {

    public MainCanvasController(Joueur player){
        super(player);
        this.getPlayer().setPosition(new Vector(440,505));
    }

    private final Image background = new Image(getClass().getResourceAsStream("/img/map.png"));

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
        addPNJ(new PNJ("Marie",new Vector(520,340)));
        addPNJ(new PNJ("Andre",new Vector(515,215)));

        // Add Object
        /*
        new Item("bookGarden",65,490,"This book is all covered in blood\nYou can distinguish a drawing of the town\nYou read the initials \"S.A.\"", 2, 1).save();

        new Item("letterFountain",610,295,"There is a little letter but it is signed as after tomorrow\nIt certainly is an error", 1, 2).save();

        Item fountain = new InteractZone("fountain", 610,230, 40,40,"Something is floating in the middle of the fountain\nIt comes closer to you and\nyou distinguish a finger\nThere is velvet under the nail", true, false);
        fountain.setHintValue(1);
        fountain.save();

        new InteractZone("bridge", 485,505, 20,20,"The bridge is broken and you can't get through it", true, true).save();

        new Item("bloodPuddle", 365,350,"You see puddles made out of blood & dirt\nFrom where does it come from ?", 2,3).save();

        new Item("bloodBucket", 220,350,"There is a gory bucket with Andre's head inside !\nNot him!\nWhat is going on around here", 3,4).save();

        */

        addItem(new InteractZone("hotel",615,195,40,5,"You enter the hotel\nThe hall seems huge and totally disproportional\nDo you think the dev is tired or this is wanted ?", true, true, playerController -> navigator.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()))));

        loadItems("main");
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
