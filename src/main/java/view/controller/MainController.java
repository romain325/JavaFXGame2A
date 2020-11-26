package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import main.java.core.control.Action;
import main.java.core.control.InteractKey;
import main.java.core.control.KeyBinder;
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
    private KeyBinder keyBinder;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initElements();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        renderer = new CanvasRenderer(gameCanvas);
        renderer.setBackground(new Image(getClass().getResourceAsStream("/img/map.png")));

        // TODO Use other renderer to add to the main Canvas

        gameLoop = new GameLoop() {
            @Override
            public void tick(float elapsedSec) {
                // renderer.prepare();
                // TODO Game Logic aka movement/collision/physics taking care of elapsedSec
                if(KeyBinder.isKeyDown(InteractKey.U_KEY.getKeyCode())){
                    System.out.println("Go UP");
                }
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