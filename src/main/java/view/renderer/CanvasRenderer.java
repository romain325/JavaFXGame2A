package main.java.view.renderer;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.LinkedList;
import java.util.List;

public class CanvasRenderer {
    private Canvas canvas;
    private GraphicsContext context;
    private Image background;
    private List<Rendable> elements;
    //TODO ENTITTY RENDERER LIST

    public CanvasRenderer(Canvas canvas){
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
        elements = new LinkedList<>();
    }

    public CanvasRenderer(Canvas canvas, List<Rendable> elements){
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
        this.elements = elements;
    }

    public void render(){
        context.save();
        if(background != null){
            context.drawImage(background, 0, 0);
        }
        for (Rendable elem: elements) {
            elem.render();
        }
        context.restore();
    }

    public void setBackground(Image background) {
        this.background = background;
    }
    public void addNewElement(Rendable element) {
        //elements.add(element);
    }
}
