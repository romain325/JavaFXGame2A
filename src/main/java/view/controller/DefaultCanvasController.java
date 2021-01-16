package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import main.java.core.control.PlayerController;
import main.java.core.item.Item;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.collision.Collisioner;
import main.java.core.logic.GameLoop;
import main.java.core.logic.Interactive;
import main.java.core.logic.collision.InvisibleCollisionable;
import main.java.utils.Vector;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.PNJ;
import main.java.core.visual.Visuel;
import main.java.core.visual.map.Map;
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

    /**
     * Create a default canvas given the player that will be playing on it
     * @param player The player who will be playing
     */
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
        playerController = new PlayerController(getPlayer(), new Collisioner(gameMap, (int)gameCanvas.getWidth(), (int)gameCanvas.getHeight()));
        renderer = new CanvasRenderer(gameCanvas, gameMap);

        gameLoop.start();
    }

    /**
     * Add visual element
     * @param visuel Visuel element to render
     */
    public void addMapElements(Visuel visuel){
        mapElements.add(visuel);
    }

    /**
     * Add an interactive elmement to the map
     * @param interactive intereactive element to add
     */
    public void addInteractiveElements(Interactive interactive){
        interactivesElements.add(interactive);
    }

    /**
     * Add a collisionable elemnt to the maop
     * @param collisionable Collisionable element
     */
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

    /**
     * Template method to add an action at the beginning of the tick in the gameloop
     */
    protected void addIntroGameLoop(){
        return;
    }

    /**
     * Init canvas property
     */
    protected void initCanvas() {
        gameCanvas.setHeight(MainFrame.HEIGHT);
        gameCanvas.setWidth(MainFrame.WIDTH);
    }

    /**
     * Let the player set the backgroundImage of the map
     * @return the background Image
     */
    protected abstract Image getBackgroundImage();

    /**
     * Get current player
     * @return current player
     */
    protected Joueur getPlayer() {
        return joueur;
    }

    /**
     * Set current player
     * @param joueur current player
     */
    protected void setPlayer(Joueur joueur) {
        this.joueur = joueur;
        addMapElements(getPlayer().getVisual());
    }

    /**
     * Init of all the map elements
     */
    protected abstract void initMapElements();

    /**
     * Add an item (collisionable, interactive & visual) if the gameAdvancement allow it
     * @param item wanted element
     */
    protected void addItem(Item item){
        if(
                getPlayer().getAdvancement().getCollectedItems().contains(item.getNom()) ||
                getPlayer().getAdvancement().getDayElapsed() < item.getApparitionDay()
        ) return;
        if(item.hasCollision()) addCollisionableElements(item);
        if(item.isInteractive()) addInteractiveElements(item);
        if(item.getVisual().isVisible()) addMapElements(item.getVisual());
    }

    /**
     * Add a new PNJ (Visuel, Interactive) if he's not dead
     * @param pnj  pnj to add
     */
    protected void addPNJ(PNJ pnj){
        if(pnj.getLifespan() < getPlayer().getAdvancement().getDayElapsed()) return;
        addMapElements(pnj.getVisual());
        addInteractiveElements(pnj);
    }

    /**
     * Load collisonable elemnts from a given file of coordinate
     * @param filename file containing the coordinate of this map
     */
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

    /**
     * Change scene opacity
     * @param opacity new opacity
     */
    public void setOpacity(double opacity){
        root.setOpacity(opacity);
    }

    /**
     * Get current scene opacity
     * @return current scene opacity
     */
    public double getOpacity(){
        return root.getOpacity();
    }

    /**
     * Set the navigator allowing you to navigate through the different scene
     * @param navigator Navigator
     */
    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    /**
     * End the game loop
     */
    @Override
    public void stop(){
        this.gameLoop.stop();
    }
}
