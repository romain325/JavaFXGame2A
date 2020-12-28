package main.java.core.visual.map;

import javafx.scene.image.Image;
import main.java.core.logic.Collisionner;
import main.java.core.logic.Interactive;
import main.java.core.personnage.PNJ;
import main.java.core.personnage.Personnage;
import main.java.core.visual.Visuel;
import main.java.view.MainFrame;
import main.java.view.renderer.Rendable;

import java.util.LinkedList;
import java.util.List;

public class Map {

    private final List<Visuel> elements;
    private final List<Interactive> interactives;
    private final Image background;

    public Map(Image background, List<Visuel> mapElements, List<Interactive> interactives){
        this.background = background;
        this.elements = mapElements;
        this.interactives = interactives;
    }

    public Map(Image background){
        this(background, new LinkedList<>(), new LinkedList<>());
    }

    public List<Visuel> getElements() {
        return elements;
    }

    public List<Interactive> getInteractives() { return interactives; }

    public Image getBackground() {
        return background;
    }

    public void addVisualElement(Visuel v){
        elements.add(v);
    }
}
