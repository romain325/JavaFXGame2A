package main.java.core.visual.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.VisuelPersonnage;

public class StaticPlayerSprite extends VisuelPersonnage {

    private final Image sprite;

    public StaticPlayerSprite(String imagePath, Vector pos) {
        super(pos.getX(), pos.getY());
        this.sprite = new Image(getClass().getResourceAsStream(imagePath));
    }

    @Override
    public void render(GraphicsContext context) {
        super.render(context);
        context.drawImage(sprite, this.getCoordX(), this.getCoordY());
    }
}
