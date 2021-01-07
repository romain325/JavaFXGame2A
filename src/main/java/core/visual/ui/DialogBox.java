package main.java.core.visual.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import main.java.core.visual.map.Map;

public class DialogBox extends VisuelUI{

    private final static int WIDTH = 500;
    private final static int HEIGHT = 100;
    private final static int X = 20;
    private final static int Y = 20;
    private final static long DEFAULT_DURATION = 2000;

    private final String message;
    private final long deathMillis;
    private static final Image DIALOG_BOX = new Image(DialogBox.class.getResourceAsStream("/img/ui/dialogbox.png"));


    public DialogBox(String message) {
        this(message, DEFAULT_DURATION);
    }

    public DialogBox(String message, long millisDuration) {
        super(X, Y, HEIGHT, WIDTH);
        this.message = message;
        deathMillis = System.currentTimeMillis() + millisDuration;
        Map.setMessageToDisplay(this);
    }

    @Override
    public void render(GraphicsContext context) {
        if(System.currentTimeMillis() > deathMillis){
            Map.setMessageToDisplay(null);
        }
        context.drawImage(DIALOG_BOX, getCoordX(), getCoordY(), getWidth(), getHeight());
        context.fillText(this.message, getCoordX() + 30, getCoordY() + 30);
    }
}
