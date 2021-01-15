package main.java.core.item;

import javafx.fxml.Initializable;
import main.java.core.control.PlayerController;
import main.java.core.logic.Consommable;
import main.java.core.logic.Interactive;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.Visuel;
import main.java.core.visual.sprite.StaticItemSprite;
import main.java.core.visual.ui.InfoBox;
import main.java.utils.serialization.SerializableDTO;

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
    private String message = "";
    protected Visuel visual;

    public Item(String nom, int x,int y,String message, int hintVal, int apparitionDay){
        this(nom, new StaticItemSprite(x,y,nom), message, true, hintVal, apparitionDay);
    }

    public Item(String nom, int x,int y,String message,boolean hasCollision, int hintVal, int apparitionDay){
        this(nom, new StaticItemSprite(x,y,nom), message, hasCollision, hintVal, apparitionDay);
    }

    public Item(ItemDTO dto) {
        this(dto.getNom(),StaticItemSprite.factory(dto.getPosition(), dto.getWidth(), dto.getHeight(), dto.getNom()),dto.getMessage(),dto.hasCollision(), dto.hasIllimitedConsommation(), dto.getHintValue(), dto.getApparitionDay());
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


    public void setX(int x){
        visual.setCoordX(x);
    }

    public void setY(int y){
        visual.setCoordY(y);
    }

    public int getX(){
        return visual.getCoordX();
    }

    public int getY(){
        return visual.getCoordY();
    }

    @Override
    public String getNom() { return this.nom; }

    @Override
    public Vector getPosition() { return visual.getPosition(); }

    public Visuel getVisual(){
        return this.visual;
    }

    @Override
    public Vector getInteractZone() {
        return this.interactZone;
    }

    @Override
    public boolean isInteractive() {
        return isInteractive;
    }

    @Override
    public boolean isBusy() {
        return isBusy;
    }

    @Override
    public boolean isConsumed() {
        return isConsumed;
    }

    @Override
    public void consume(PlayerController playerController) {
        isConsumed = true;
        hasCollision = false;
        isInteractive = false;
        playerController.getJoueur().getAdvancement().addCollectedItem(this);
        visual.setVisible(false);
    }

    @Override
    public int getHeight() {
        return visual.getHeight();
    }

    @Override
    public int getWidth() {
        return visual.getWidth();
    }

    @Override
    public boolean hasCollision() {
        return hasCollision;
    }

    @Override
    public int getHintValue() {
        return hintVal;
    }

    public void setHintValue(int hintValue) {
        this.hintVal = hintValue;
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ItemDTO getDTO(){
        return new ItemDTO(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        return;
    }

    @Override
    public boolean hasIllimitedConsommation() {
        return hasIllimitedConso;
    }

    @Override
    public void interact(PlayerController playerController) {
        if (isInteractive() && !isBusy() && !getMessage().replace(" ", "").equals("")){
            new InfoBox(getMessage());
        }
        doAction(playerController);
        if(!hasIllimitedConsommation()){
            consume(playerController);
        }
    }

    public void doAction(PlayerController playerController){
        return;
    }

    public int getApparitionDay(){
        return this.apparitionDay;
    }
}
