package main.java.core.visual;

import javafx.scene.canvas.GraphicsContext;
import main.java.core.logic.movement.Vector;
import main.java.view.renderer.ZIndex;

public class VisuelPersonnage extends Visuel {
    private static final byte PERSONNAGE_HEIGHT = 16;
    private static final byte PERSONNAGE_WIDTH = 16;

    public VisuelPersonnage(int x, int y) {
        super(x, y, PERSONNAGE_HEIGHT, PERSONNAGE_WIDTH, ZIndex.CHARACTER);
    }

    @Override
    public void render(GraphicsContext context) {
        context.strokeRect(this.getCoordX(),this.getCoordY(),PERSONNAGE_WIDTH,PERSONNAGE_HEIGHT);
    }
}
