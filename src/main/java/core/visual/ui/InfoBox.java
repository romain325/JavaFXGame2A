package main.java.core.visual.ui;

import javafx.scene.image.Image;

public class InfoBox extends MessageBox{
    private static final Image IMAGE = new Image(DialogBox.class.getResourceAsStream("/img/ui/infobox.png"));

    public InfoBox(String message) {
        super(message, DEFAULT_DURATION, DEFAULT_X, DEFAULT_Y, 500, 100);
    }

    @Override
    protected Image getImage() {
        return IMAGE;
    }
}
