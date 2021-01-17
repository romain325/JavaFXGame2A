package main.java.core.visual.ui;

import main.java.core.visual.Visual;
import main.java.core.visual.ZIndex;

public abstract class VisualUI extends Visual {

    public VisualUI(int x, int y, int h, int w) {
        super(x, y, h, w, ZIndex.GENERAL_UI);
    }

}
