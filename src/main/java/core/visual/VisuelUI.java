package main.java.core.visual;

import main.java.view.renderer.ZIndex;

public class VisuelUI extends Visuel{

    public VisuelUI(int x, int y, int h, int w) {
        super(x, y, h, w, ZIndex.GENERAL_UI);
    }

    @Override
    public void render() {
        //render
    }
}
