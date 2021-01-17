package main.java.core.visual.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.java.core.visual.map.Map;

public abstract class MessageBox extends VisualUI {

    protected final static int DEFAULT_X = 20;
    protected final static int DEFAULT_Y = 20;
    protected final static int DEFAULT_DURATION = 2000;

    private final String message;
    private final long lifespan;

    public MessageBox(String message, long millisDuration, int x, int y, int h, int w) {
        super(x,y,w,h);
        this.message = message;
        lifespan = System.currentTimeMillis() + millisDuration;
        Map.setMessageToDisplay(this);
    }

    @Override
    public void render(GraphicsContext context) {
        if(System.currentTimeMillis() > lifespan){
            Map.setMessageToDisplay(null);
        }
        context.drawImage(getBackgroundImage(), getCoordX(), getCoordY(), getWidth(), getHeight());
        context.fillText(this.message, getCoordX() + 30, getCoordY() + 30);
    }

    /**
     * Get background image where the message will be displayed
     * @return background image
     */
    protected abstract Image getBackgroundImage();
}
