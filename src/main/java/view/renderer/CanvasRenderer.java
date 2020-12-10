package main.java.view.renderer;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.java.core.visual.Visuel;
import main.java.core.visual.map.Map;

import java.util.LinkedList;
import java.util.List;

public class CanvasRenderer {
    private Canvas canvas;
    private GraphicsContext context;
    private Map gameMap;

    public CanvasRenderer(Canvas canvas, Map map){
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
        this.gameMap = map;
    }

    public void render(){
        context.save();
        context.drawImage(gameMap.getBackground(),0 ,0);

        for (Rendable elem : gameMap.getElements()) {
            elem.render(context);
        }

        context.restore();
    }

}
