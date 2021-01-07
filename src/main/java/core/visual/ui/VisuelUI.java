package main.java.core.visual.ui;

import javafx.scene.canvas.GraphicsContext;
import main.java.core.visual.Visuel;
import main.java.view.renderer.ZIndex;

public abstract class VisuelUI extends Visuel {

    public VisuelUI(int x, int y, int h, int w) {
        super(x, y, h, w, ZIndex.GENERAL_UI);
    }

}
