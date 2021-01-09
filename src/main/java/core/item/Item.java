package main.java.core.item;

import javafx.fxml.Initializable;
import main.java.core.logic.Consommable;
import main.java.core.logic.Interactive;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.Visuel;
import main.java.core.visual.sprite.StaticItemSprite;
import main.java.core.visual.ui.InfoBox;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class Item implements Interactive, Consommable, Collisionable, Initializable, Serializable, ItemProcuration{
    private boolean isBusy = false;
    private boolean isConsumed = false;
    private boolean isInteractive = true;
    private boolean hasCollision;
    private boolean hasIllimitedConso = false;

    protected final Vector interactZone = new Vector(15,15);

    private final String nom;
    private String message = "";
    protected Visuel visual;

    public Item(String nom){
        this(nom, new StaticItemSprite(0,0,nom), false);
    }

    public Item(String nom, boolean hasCollision){
        this(nom, new StaticItemSprite(0,0,nom), hasCollision);
    }

    public Item(String nom, int x,int y,boolean hasCollision){
        this(nom, new StaticItemSprite(x,y,nom), hasCollision);
    }

    public Item(ItemDTO dto) {
        this(dto.getNom(),StaticItemSprite.factory(dto.getPosition(), dto.getWidth(), dto.getHeight(), dto.getNom()),dto.getMessage(),dto.hasCollision(), dto.hasIllimitedConsommation());
    }

    protected Item(String nom, StaticItemSprite sprite, boolean hasCollision){
        this.nom = nom;
        this.visual = sprite;
        this.hasCollision = hasCollision;

        URL path = getClass().getResource("/dialog/item/" + this.getNom() + ".txt");
        if(path != null) {
            try {
                this.message = new Scanner(new FileReader(path.getPath())).nextLine().replace("\\n", "\n");
            } catch (FileNotFoundException ignored) {

            }
        }
        initialize(null,null);
    }

    protected Item(String nom, StaticItemSprite sprite, String message, boolean hasCollision, boolean hasIllimitedConso){
        this.nom = nom;
        this.visual = sprite;
        this.hasCollision = hasCollision;
        this.message = message;
        this.hasIllimitedConso = hasIllimitedConso;
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
    public void consume() {
        isConsumed = true;
        hasCollision = false;
        isInteractive = false;
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

    public String getMessage() {
        return message;
    }

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

}
