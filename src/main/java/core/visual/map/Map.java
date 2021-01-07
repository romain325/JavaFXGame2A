package main.java.core.visual.map;

import javafx.scene.image.Image;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.Interactive;
import main.java.view.renderer.Rendable;

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

    public List<Rendable> getElements() {
        return elements;
    }

    public List<Interactive> getInteractives() { return interactives; }

    public List<Collisionable> getCollisionables() { return collisionables; }

    public Image getBackground() {
        return background;
    }

    public void addVisualElement(Rendable v){
        elements.add(v);
    }

    public static void setMessageToDisplay(Rendable rendable){
        MESSAGE_DISPLAY = rendable;
    }

    public Rendable getMessageDisplay(){
        return MESSAGE_DISPLAY;
    }
}
