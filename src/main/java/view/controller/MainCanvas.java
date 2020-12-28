package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import main.java.core.control.PlayerController;
import main.java.core.logic.Collisionner;
import main.java.core.logic.GameLoop;
import main.java.core.logic.Interactive;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.personnage.pnjs.Andre;
import main.java.core.visual.Visuel;
import main.java.core.visual.map.Map;
import main.java.view.MainFrame;
import main.java.view.renderer.CanvasRenderer;

import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class MainCanvas implements Initializable {
    @FXML
    private Canvas gameCanvas;
    @FXML
    private AnchorPane root;

    private GameLoop gameLoop;
    private CanvasRenderer renderer;
    private List<Visuel> mapElements = new LinkedList<>();
    private List<Interactive> interactivesElements = new LinkedList<>();

    private Joueur player = new Joueur("Pedro");
    private PlayerController playerController;

    private Map gameMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initMap();
            initMapElements();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        gameMap = new Map(new Image(getClass().getResourceAsStream("/img/map.png")), mapElements, interactivesElements);
        playerController = new PlayerController(player, new Collisionner(gameMap, (int)gameCanvas.getWidth(), (int)gameCanvas.getHeight()));
        renderer = new CanvasRenderer(gameCanvas, gameMap);

        // TODO Use other renderer to add to the main Canvas

        gameLoop = new GameLoop() {
            @Override
            public void tick() {
                // TODO Game Logic aka movement/collision/physics taking care of elapsedSec

                playerController.doAction();

                renderer.render();
            }
        };

        gameLoop.start();
    }

    protected void initMap() throws Exception {
        gameCanvas.setHeight(MainFrame.HEIGHT);
        gameCanvas.setWidth(MainFrame.WIDTH);
    }

    protected void initMapElements() {
        // Add player to render
        player.getVisual().setDebugMode(Color.RED);
        mapElements.add(player.getVisual());

        // Add pnj
        Andre andre = new Andre(true);
        mapElements.add(andre.getVisual());
        interactivesElements.add(andre);

        // Add Object
    }
}
