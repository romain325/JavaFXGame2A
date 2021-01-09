package main.java.core.visual.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.java.core.control.KeyBinder;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.VisuelPersonnage;

public class AnimatedPlayerSprite extends VisuelPersonnage {

    private final int nbFramePerAnim = 3;
    private Image standingSprite;
    private final Image[][] sprites = new Image[4][nbFramePerAnim];
    private int tick = 0;

    public AnimatedPlayerSprite(String imageFolderPath, Vector pos) {
        super(pos.getX(), pos.getY());
        this.standingSprite = new Image(getClass().getResourceAsStream(imageFolderPath + "/standing.png"));
        char[] initialOrder = new char[]{'d','l','r','u'};
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < nbFramePerAnim; j++){
                sprites[i][j] = new Image(getClass().getResourceAsStream(imageFolderPath + "/" + initialOrder[i] + (j+1) + ".png"));
            }
        }
    }

    @Override
    public void render(GraphicsContext context) {
        super.render(context);
        context.drawImage(getCurrentSprite(), this.getCoordX(), this.getCoordY());
    }

    private Image getCurrentSprite(){
        switch (KeyBinder.getCurrentInteract()){
            case D_KEY:
                return sprites[0][getTick()];
            case L_KEY:
                return sprites[1][getTick()];
            case R_KEY:
                return sprites[2][getTick()];
            case U_KEY:
                return sprites[3][getTick()];
            case NONE_KEY:
            case INTERACT_KEY:
            default:
                return standingSprite;
        }
    }

    private int getTick(){
        addToTick();
        return tick;
    }
    protected void addToTick(){
        this.tick = (this.tick + 1) % nbFramePerAnim;
    }
}
