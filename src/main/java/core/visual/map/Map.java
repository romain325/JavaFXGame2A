package main.java.core.visual.map;

import javafx.scene.image.Image;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.Interactive;
import main.java.core.logic.Rendable;

import java.util.LinkedList;
import java.util.List;

public class Map {

    private final List<Rendable> elements;
    private final List<Interactive> interactives;
    private final List<Collisionable> collisionables;
    private static Rendable MESSAGE_DISPLAY;
    private final Image background;

    public Map(Image background, List<Rendable> mapElements, List<Interactive> interactives, List<Collisionable> collisionables){
        this.background = background;
        this.elements = mapElements;
        this.interactives = interactives;
        this.collisionables = collisionables;
    }

    public Map(Image background){
        this(background, new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
    }

    /**
     * Get rendable Elements
     * @return rendable elemnts
     */
    public List<Rendable> getRendableElements() {
        return elements;
    }

    /**
     * get Interactive Elements
     * @return interactive elemnts
     */
    public List<Interactive> getInteractives() { return interactives; }

    /**
     * get collisionable Elements
     * @return collisionable elements
     */
    public List<Collisionable> getCollisionables() { return collisionables; }

    /**
     * get background image
     * @return background image
     */
    public Image getBackground() {
        return background;
    }

    /**
     * Set the display information
     * @param rendable display informations
     */
    public static void setMessageToDisplay(Rendable rendable){
        MESSAGE_DISPLAY = rendable;
    }

    /**
     * get current display information
     * @return diplay information
     */
    public Rendable getMessageDisplay(){
        return MESSAGE_DISPLAY;
    }
}
