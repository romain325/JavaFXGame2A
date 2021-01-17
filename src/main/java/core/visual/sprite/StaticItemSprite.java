package main.java.core.visual.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.java.utils.Vector;
import main.java.core.visual.Visual;
import main.java.core.visual.ZIndex;

public class StaticItemSprite extends Visual implements Sprite{
    private final Image sprite;

    public StaticItemSprite(int x, int y, String itemName){
        this(x, y, new Image(StaticItemSprite.class.getResourceAsStream("/img/items/" + itemName + ".png")));
    }

    public StaticItemSprite(int x, int y, int w, int h){
        super(x,y,w,h,ZIndex.ITEM);
        this.sprite = null;
        setVisible(false);
    }

    /**
     * Static Item Sprite factory
     * @param pos position
     * @param w width
     * @param h height
     * @param itemName itemname
     * @return constructed ItemSprite
     */
    public static StaticItemSprite factory(Vector pos, int w, int h, String itemName){
        if(StaticItemSprite.class.getResource("/img/items/" + itemName + ".png") == null) return new StaticItemSprite(pos.getX(), pos.getY(), w,h);
        else return new StaticItemSprite(pos.getX(), pos.getY(), itemName);
    }

    private StaticItemSprite(int x, int y, Image image) {
        super(x, y, (int) image.getHeight(), (int) image.getWidth(), ZIndex.ITEM);
        this.sprite = image;
    }

    @Override
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
