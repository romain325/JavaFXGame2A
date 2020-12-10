package main.java.core.visual.map;

import javafx.scene.image.Image;
import main.java.core.logic.Collisionner;
import main.java.core.visual.Visuel;
import main.java.view.MainFrame;
import main.java.view.renderer.Rendable;

import java.util.LinkedList;
import java.util.List;

public class Map {

    private final Collisionner collisionner = new Collisionner();
    private final List<Visuel> elements;
    private final Image background;

    public Map(Image background, List<Visuel> mapElements){
        this.background = background;
        this.elements = mapElements;
    }

    public Map(Image background){
        this(background, new LinkedList<>());
    }

    public List<Visuel> getElements() {
        return elements;
    }

    public Image getBackground() {
        return background;
    }

    public void addVisualElement(Visuel v){
        elements.add(v);
    }
}
