package main.java.core.visual.ui;

import javafx.scene.image.Image;

public class DialogBox extends MessageBox{

    private static final Image IMAGE = new Image(DialogBox.class.getResourceAsStream("/img/ui/dialogbox.png"));

    public DialogBox(String message) {
        super(message, 3000, DEFAULT_X, DEFAULT_Y, 400, 100);
    }

    @Override
    protected Image getBackgroundImage() {
        return IMAGE;
    }
}
