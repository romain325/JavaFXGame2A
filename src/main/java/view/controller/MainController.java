package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import main.java.core.time.GameLoop;
import main.java.view.renderer.CanvasRenderer;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Canvas gameCanvas;
    @FXML
    private AnchorPane root;

    private GameLoop gameLoop;
    private CanvasRenderer renderer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initElements();
        renderer = new CanvasRenderer(gameCanvas);
        renderer.setBackground(new Image(getClass().getResourceAsStream("/img/map.png")));

        // TODO Use other renderer to add to the main Canvas

        gameLoop = new GameLoop() {
            @Override
            public void tick(float elapsedSec) {
                // renderer.prepare();
                // TODO Game Logic aka movement/collision/physics taking care of elapsedSec
                renderer.render();
            }
        };

        gameLoop.start();
    }

    protected void initElements(){
        gameCanvas.setHeight(700); // TODO use the vars
        gameCanvas.setWidth(700);
    }
}
