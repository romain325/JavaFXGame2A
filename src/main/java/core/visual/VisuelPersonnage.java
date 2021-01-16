package main.java.core.visual;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.java.view.renderer.ZIndex;

public class VisuelPersonnage extends Visuel {
    private boolean debugMode = false;
    private Color debugColor;
    private static final byte PERSONNAGE_HEIGHT = 16;
    private static final byte PERSONNAGE_WIDTH = 16;

    public VisuelPersonnage(int x, int y) {
        super(x, y, PERSONNAGE_HEIGHT, PERSONNAGE_WIDTH, ZIndex.CHARACTER);
    }
    public VisuelPersonnage(int x, int y, Color debugColor) {
        this(x, y);
        this.debugMode = true;
        this.debugColor = debugColor;
    }

    @Override
    public void render(GraphicsContext context) {
        if(!isVisible()) return;
        if(debugMode){
            context.setStroke(debugColor);
            context.strokeRect(this.getCoordX(),this.getCoordY(),PERSONNAGE_WIDTH,PERSONNAGE_HEIGHT);
        }
    }

    public void setDebugMode(Color color){
        this.debugMode = true;
        this.debugColor = color;
    }
}
