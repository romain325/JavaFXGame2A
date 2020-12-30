package main.java.core.visual.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.java.core.visual.Visuel;
import main.java.view.renderer.ZIndex;

import java.io.InputStream;

public class StaticItemSprite extends Visuel {
    private final Image sprite;

    public StaticItemSprite(int x, int y, String itemName){
        this(x, y, new Image(StaticItemSprite.class.getResourceAsStream("/img/items/" + itemName + ".png")));
    }

    public StaticItemSprite(int x, int y, int w, int h){
        super(x,y,w,h,ZIndex.ITEM);
        this.sprite = null;
        setVisible(false);
    }

    private StaticItemSprite(int x, int y, Image image) {
        super(x, y, (int) image.getHeight(), (int) image.getWidth(), ZIndex.ITEM);
        this.sprite = image;
    }

    public Image getSprite(){
        return this.sprite;
    }

    @Override
    public void render(GraphicsContext context) {
        debugVision(context);
        if(!isVisible()) return;
        context.drawImage(this.getSprite(), this.getCoordX(), this.getCoordY());
    }
}
