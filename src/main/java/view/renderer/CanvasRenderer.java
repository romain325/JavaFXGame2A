package main.java.view.renderer;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.java.core.logic.Rendable;
import main.java.core.visual.map.Map;

public class CanvasRenderer {
    private final Canvas canvas;
    private final GraphicsContext context;
    private final Map gameMap;

    public CanvasRenderer(Canvas canvas, Map map){
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
        this.gameMap = map;
    }

    public void render(){
        context.save();
        context.drawImage(gameMap.getBackground(),0 ,0);

        for (Rendable elem : gameMap.getRendableElements()) {
            if(elem.isVisible()) {
                elem.render(context);
            }
        }

        var message = gameMap.getMessageDisplay();
        if(message != null) message.render(context);

        context.restore();
    }

}
