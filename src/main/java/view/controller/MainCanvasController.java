package main.java.view.controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.item.ItemDTO;
import main.java.core.logic.collision.InvisibleCollisionable;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.pnjs.Andre;
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
        // Add player to render
        this.getPlayer().getVisual().setDebugMode(Color.RED);
        addMapElements(getPlayer().getVisual());

        // Add pnj
        Andre andre = new Andre(true);
        addMapElements(andre.getVisual());
        addInteractiveElements(andre);

        // Add Object

        Item book = new Item("book",100,100, true);
        SerializationManager.serializeObject(book.getNom() + ".obj", book);
        addItem(SerializationManager.<ItemDTO>deserializeObject("book.obj").getInstance());


        Item door1 = new InteractZone("portal",150,150,16,16,true) {
            @Override
            public void doAction() {
                MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()));
            }
        };
        SerializationManager.serializeObject(door1.getNom() + ".obj", door1);
        addItem(new Item(SerializationManager.<ItemDTO>deserializeObject("portal.obj")){
            @Override
            public void doAction() {
                MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()));
            }
        });

        Item bridge2 = new InteractZone("bridge", 485,505, 20,20,"The bridge is broken and you can't get through it", true, true);
        SerializationManager.serializeObject(bridge2.getNom() + ".obj", bridge2);
        addItem(SerializationManager.<ItemDTO>deserializeObject("bridge.obj").getInstance());

        Scanner scanner = new Scanner(getClass().getResourceAsStream("/map/main.pos"));
        int[] values = new int[4];
        try{
            while (scanner.hasNextInt()){
                for (int i = 0; i < 4; i++){
                    if(!scanner.hasNextInt()) throw new InvalidPropertiesFormatException("Position file is wrong. Some Collision may not work.");
                    values[i] = scanner.nextInt();
                }
                addCollisionableElements(new InvisibleCollisionable(new Vector(values[0], values[1]), values[2], values[3]));
            }
        }catch (InvalidPropertiesFormatException e){
            e.printStackTrace();
        }

    }

    private void addItem(Item item){
        if(item.hasCollision()) addCollisionableElements(item);
        if(item.isInteractive()) addInteractiveElements(item);
        if(item.getVisual().isVisible()) addMapElements(item.getVisual());
    }
}
