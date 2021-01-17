package main.java.core.visual.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.java.utils.Vector;
import main.java.core.visual.VisualPersonnage;

public class StaticPlayerSprite extends VisualPersonnage implements Sprite {

    private final Image sprite;

    public StaticPlayerSprite(String imagePath, Vector pos) {
        super(pos.getX(), pos.getY());
        this.sprite = new Image(getClass().getResourceAsStream(imagePath));
    }

    public StaticPlayerSprite(Vector pos) {
        super(pos.getX(), pos.getY());
        this.sprite = null;
    }

    @Override
    public void render(GraphicsContext context) {
        super.render(context);
        if(this.getSprite() != null){
            context.drawImage(sprite, this.getCoordX(), this.getCoordY());
        }
    }

    @Override
    public Image getSprite() {
        return this.sprite;
    }
}
