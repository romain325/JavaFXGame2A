package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import main.java.core.control.InteractKey;
import main.java.core.control.KeyBinder;
import main.java.core.control.PlayerController;
import main.java.core.personnage.Joueur;
import main.java.core.time.GameLoop;
import main.java.core.visual.map.Map;
import main.java.view.renderer.CanvasRenderer;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MainCanvas implements Initializable {
    @FXML
    private Canvas gameCanvas;
    @FXML
    private AnchorPane root;

    private GameLoop gameLoop;
    private CanvasRenderer renderer;
    private KeyBinder keyBinder;
    // CHANGER POUR LE VRAI J
    private Joueur player = new Joueur("Pedro");
    private PlayerController playerController = new PlayerController(player);
    private Map gameMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initElements();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        gameMap = new Map(new Image(getClass().getResourceAsStream("/img/map.png")), new LinkedList<>(Arrays.asList(player.getVisual())));

        renderer = new CanvasRenderer(gameCanvas, gameMap);

        // TODO Use other renderer to add to the main Canvas

        gameLoop = new GameLoop() {
            @Override
            public void tick() {
                // TODO Game Logic aka movement/collision/physics taking care of elapsedSec

                playerController.doAction(KeyBinder.getCurrentAction());

                renderer.render();
            }
        };

        gameLoop.start();
    }

    protected void initElements() throws Exception {
        gameCanvas.setHeight(700); // TODO use the vars
        gameCanvas.setWidth(700);
    }
}