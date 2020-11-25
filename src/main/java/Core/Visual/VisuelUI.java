package main.java.Core.Visual;

import main.java.View.Renderer.ZIndex;

public class VisuelUI extends Visuel{

    public VisuelUI(int x, int y, int h, int w) {
        super(x, y, h, w, ZIndex.GENERAL_UI);
    }

    @Override
    public void render() {
        //render
    }
}
