package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import main.java.core.control.PlayerController;
import main.java.core.logic.Collisionner;
import main.java.core.logic.GameLoop;
import main.java.core.logic.Interactive;
import main.java.core.personnage.Joueur;
import main.java.core.visual.Visuel;
import main.java.core.visual.map.Map;
import main.java.view.MainFrame;
import main.java.view.renderer.CanvasRenderer;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class DefaultCanvasController implements Controller {
    @FXML
    private Canvas gameCanvas;
    @FXML
    private AnchorPane root;

    private GameLoop gameLoop;
    private CanvasRenderer renderer;
    private List<Visuel> mapElements = new LinkedList<>();
    private List<Interactive> interactivesElements = new LinkedList<>();
    private Joueur joueur = new Joueur("Null");

    public DefaultCanvasController(Joueur player){
        this.setPlayer(player);
    }

    private PlayerController playerController;

    private Map gameMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initCanvas();
            initMapElements();
            initGameLoop();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        gameMap = new Map(getBackgroundImage(), mapElements, interactivesElements);
        playerController = new PlayerController(getPlayer(), new Collisionner(gameMap, (int)gameCanvas.getWidth(), (int)gameCanvas.getHeight()));
        renderer = new CanvasRenderer(gameCanvas, gameMap);


        gameLoop.start();
    }

    public void addMapElements(Visuel visuel){
        mapElements.add(visuel);
    }

    public void addInteractiveElements(Interactive interactive){
        interactivesElements.add(interactive);
    }

    protected void initGameLoop(){
        gameLoop = new GameLoop() {
            @Override
            public void tick() {
                playerController.doAction();
                renderer.render();
            }
        };
    }

    protected void initCanvas() throws Exception {
        gameCanvas.setHeight(MainFrame.HEIGHT);
        gameCanvas.setWidth(MainFrame.WIDTH);
    }

    protected abstract Image getBackgroundImage();

    protected Joueur getPlayer() {
        return joueur;
    }
    protected void setPlayer(Joueur joueur) {
        this.joueur = joueur;
        addMapElements(getPlayer().getVisual());
    }


    protected abstract void initMapElements();
}
