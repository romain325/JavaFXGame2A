package main.java.view.controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.collision.InvisibleCollisionable;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.pnjs.Andre;
import main.java.view.FRAME;
import main.java.view.MainFrame;

import java.net.URL;
import java.util.InvalidPropertiesFormatException;
import java.util.ResourceBundle;
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
        Item book = new Item("book", true) {
            @Override
            public void interact() {
                if(!isInteractive()) return;

                consume();
            }

            @Override
            public void initialize(URL url, ResourceBundle resourceBundle) {
                this.setX(100);
                this.setY(100);
            }
        };
        addMapElements(book.getVisual());
        addInteractiveElements(book);
        addCollisionableElements(book);

        Item door1 = new InteractZone("portal",16,16,true) {
            @Override
            public void interact() {
                MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new Batiment1CanvasController(getPlayer()));
            }

            @Override
            public void initialize(URL url, ResourceBundle resourceBundle) {
                this.setX(150);
                this.setY(150);
            }
        };
        addInteractiveElements(door1);
        addMapElements(door1.getVisual());
        addCollisionableElements(door1);

        Scanner scanner = new Scanner(getClass().getResourceAsStream("/map/main.pos"));
        int[] values = new int[4];
        try{
            while (scanner.hasNextInt()){
                for (int i = 0; i < 4; i++){
                    if(!scanner.hasNextInt()) throw new InvalidPropertiesFormatException("Position file is wrong");
                    values[i] = scanner.nextInt();
                }
                addCollisionableElements(new InvisibleCollisionable(new Vector(values[0], values[1]), values[2], values[3]));
            }
        }catch (InvalidPropertiesFormatException e){
            e.printStackTrace();
        }

    }
}
