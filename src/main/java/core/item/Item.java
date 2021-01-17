package main.java.core.item;

import javafx.fxml.Initializable;
import main.java.core.control.PlayerController;
import main.java.core.logic.Action;
import main.java.core.logic.Consommable;
import main.java.core.logic.Interactive;
import main.java.core.logic.collision.Collisionable;
import main.java.utils.Vector;
import main.java.core.visual.Visual;
import main.java.core.visual.sprite.StaticItemSprite;
import main.java.core.visual.ui.InfoBox;
import main.java.utils.serialization.SerializableDTO;
import main.java.utils.serialization.SerializationManager;

import java.net.URL;
import java.util.ResourceBundle;

public class Item implements Interactive, Consommable, Collisionable, Initializable, SerializableDTO<ItemDTO>, ItemProcuration{
    private boolean isBusy = false;
    private boolean isConsumed = false;
    private boolean isInteractive = true;
    private boolean hasCollision;
    private boolean hasIllimitedConso = false;
    private int hintVal = 0;
    private int apparitionDay = 0;

    protected final Vector interactZone = new Vector(15,15);

    private final String nom;
    private final String message;
    protected Visual visual;
    private Action action = playerController -> {};

    public Item(String nom, int x,int y,String message, int hintVal, int apparitionDay){
        this(nom, new StaticItemSprite(x,y,nom), message, true, hintVal, apparitionDay);
    }

    public Item(String nom, int x,int y,String message,boolean hasCollision, int hintVal, int apparitionDay){
        this(nom, new StaticItemSprite(x,y,nom), message, hasCollision, hintVal, apparitionDay);
    }

    public Item(ItemDTO dto) {
        this(dto.getNom(),StaticItemSprite.factory(dto.getPosition(), dto.getWidth(), dto.getHeight(), dto.getNom()),dto.getMessage(),dto.hasCollision(), dto.hasIllimitedConsommation(), dto.getHintValue(), dto.getApparitionDay());
    }

    public Item(ItemDTO dto, Action action) {
        this(dto);
        this.action = action;
    }

    protected Item(String nom, StaticItemSprite sprite, String message,boolean hasCollision, int hintVal, int apparitionDay){
        this.nom = nom;
        this.visual = sprite;
        this.hasCollision = hasCollision;
        this.hintVal = hintVal;
        this.apparitionDay = apparitionDay;
        this.message = message;
        initialize(null,null);
    }

    protected Item(String nom, StaticItemSprite sprite, String message, boolean hasCollision, boolean hasIllimitedConso, int hintVal, int apparitionDay){
        this.nom = nom;
        this.visual = sprite;
        this.hasCollision = hasCollision;
        this.message = message;
        this.hasIllimitedConso = hasIllimitedConso;
        this.hintVal = hintVal;
        this.apparitionDay = apparitionDay;
        initialize(null,null);
    }

    /**
     * getter
     * @return val
     */
    @Override
    public String getNom() { return this.nom; }

    /**
     * getter
     * @return val
     */
    @Override
    public Vector getPosition() { return visual.getPosition(); }

    /**
     * getter
     * @return val
     */
    public Visual getVisual(){
        return this.visual;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public Vector getInteractZone() {
        return this.interactZone;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public boolean isInteractive() {
        return isInteractive;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public boolean isConsumed() {
        return isConsumed;
    }

    /**
     * Consume the item
     * @param playerController current player
     */
    @Override
    public void consume(PlayerController playerController) {
        isConsumed = true;
        hasCollision = false;
        isInteractive = false;
        playerController.getJoueur().getAdvancement().addCollectedItem(this);
        visual.setVisible(false);
    }

    /**
     * getter
     * @return val
     */
    @Override
    public int getHeight() {
        return visual.getHeight();
    }

    /**
     * getter
     * @return val
     */
    @Override
    public int getWidth() {
        return visual.getWidth();
    }

    /**
     * getter
     * @return val
     */
    @Override
    public boolean hasCollision() {
        return hasCollision;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public int getHintValue() {
        return hintVal;
    }

    /**
     * setter
     * @param hintValue val
     */
    public void setHintValue(int hintValue) {
        this.hintVal = hintValue;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public ItemDTO getDTO(){
        return new ItemDTO(this);
    }

    /**
     * Initialization of an object
     * @param url null
     * @param resourceBundle null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        return;
    }

    /**
     * getter
     * @return val
     */
    @Override
    public boolean hasIllimitedConsommation() {
        return hasIllimitedConso;
    }

    /**
     * On Interaction effect
     * @param playerController player interacting with the item
     */
    @Override
    public void interact(PlayerController playerController) {
        if (isInteractive() && !isBusy() && !getMessage().replace(" ", "").equals("")){
            new InfoBox(getMessage());
        }
        this.action.doAction(playerController);
        if(!hasIllimitedConsommation()){
            consume(playerController);
        }
    }

    /**
     * getter
     * @return val
     */
    public int getApparitionDay(){
        return this.apparitionDay;
    }

    @Override
    public void save() {
        SerializationManager.serializeObject(this.getNom() + ".obj", this);
    }
}
