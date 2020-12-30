package main.java.core.visual.map;

import javafx.scene.image.Image;
import main.java.core.logic.collision.Collisionable;
import main.java.core.logic.Interactive;
import main.java.core.visual.Visuel;

import java.util.LinkedList;
import java.util.List;

public class Map {

    private final List<Visuel> elements;
    private final List<Interactive> interactives;
    private final List<Collisionable> collisionables;
    private final Image background;

    public Map(Image background, List<Visuel> mapElements, List<Interactive> interactives, List<Collisionable> collisionables){
        this.background = background;
        this.elements = mapElements;
        this.interactives = interactives;
        this.collisionables = collisionables;
    }

    public Map(Image background){
        this(background, new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
    }

    public List<Visuel> getElements() {
        return elements;
    }

    public List<Interactive> getInteractives() { return interactives; }

    public List<Collisionable> getCollisionables() { return collisionables; }

    public Image getBackground() {
        return background;
    }

    public void addVisualElement(Visuel v){
        elements.add(v);
    }
}
