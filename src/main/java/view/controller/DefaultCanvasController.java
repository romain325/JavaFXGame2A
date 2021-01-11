package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.core.control.PlayerController;
import main.java.core.item.Item;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.collision.Collisionner;
import main.java.core.logic.GameLoop;
import main.java.core.logic.Interactive;
import main.java.core.logic.collision.InvisibleCollisionable;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.visual.Visuel;
import main.java.core.visual.map.Map;
import main.java.view.FRAME;
import main.java.view.MainFrame;
import main.java.view.Navigator;
import main.java.view.renderer.CanvasRenderer;
import main.java.view.renderer.Rendable;

import java.net.URL;
import java.util.*;

public abstract class DefaultCanvasController implements Controller {
    @FXML
    private Canvas gameCanvas;
    @FXML
    private AnchorPane root;

    private GameLoop gameLoop;
    private CanvasRenderer renderer;
    private final List<Rendable> mapElements = new LinkedList<>();
    private final List<Interactive> interactivesElements = new LinkedList<>();
    private final List<Collisionable> collisionableElements = new LinkedList<>();
    private Joueur joueur = new Joueur("Null");
    protected Navigator navigator;

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

        gameMap = new Map(getBackgroundImage(), mapElements, interactivesElements, collisionableElements);
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

    public void addCollisionableElements(Collisionable collisionable) {
        collisionableElements.add(collisionable);
    }

    private void initGameLoop(){
        gameLoop = new GameLoop() {
            @Override
            public void tick() {
                addIntroGameLoop();
                playerController.doAction();
                renderer.render();
            }
        };
    }

    protected void addIntroGameLoop(){
        return;
    }

    protected void initCanvas() {
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

    protected void addItem(Item item){
        if(getPlayer().getAdvancement().getCollectedItems().contains(item.getNom())) return;
        if(item.hasCollision()) addCollisionableElements(item);
        if(item.isInteractive()) addInteractiveElements(item);
        if(item.getVisual().isVisible()) addMapElements(item.getVisual());
    }

    protected void addPNJ(PNJ pnj){
        if(pnj.getLifespan() < getPlayer().getAdvancement().getDayElapsed()) return;
        addMapElements(pnj.getVisual());
        addInteractiveElements(pnj);
    }

    protected void loadCollisionElements(String filename){
        Scanner scanner = new Scanner(getClass().getResourceAsStream("/map/" + filename + ".pos"));
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

    public void setOpacity(double opacity){
        root.setOpacity(opacity);
    }
    public double getOpacity(){
        return root.getOpacity();
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void stop(){
        this.gameLoop.stop();
    }
}
