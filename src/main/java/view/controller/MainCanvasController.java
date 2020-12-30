package main.java.view.controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.item.InteractZone;
import main.java.core.item.Item;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.pnjs.Andre;
import main.java.view.FRAME;
import main.java.view.MainFrame;

import java.net.URL;
import java.util.ResourceBundle;

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
        Item book = new Item("book") {
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

        Item door1 = new InteractZone("portal",50,50) {
            @Override
            public void interact() {
                MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new Maison1CanvasController(getPlayer()));
            }

            @Override
            public void initialize(URL url, ResourceBundle resourceBundle) {
                this.setX(150);
                this.setY(150);
                // TODO See why the size is not understood
            }
        };
        addInteractiveElements(door1);
        addMapElements(door1.getVisual());
    }
}
