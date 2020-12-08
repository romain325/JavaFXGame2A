package main.java.core.visual.map;

import javafx.scene.image.Image;
import main.java.core.logic.Collisionner;
import main.java.view.renderer.Rendable;

import java.util.LinkedList;
import java.util.List;

public class Map {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    private Collisionner collisionner = new Collisionner();
    private List<Rendable> elements = new LinkedList<>();
    private Image background;

    public Map(Image background, List<Rendable> mapElements){
        this(background);
        this.elements = elements;
    }

    public Map(Image background){
        this.background = background;
    }
}
