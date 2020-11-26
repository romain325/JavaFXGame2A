package main.java.core.visual;

import main.java.view.renderer.ZIndex;

public class VisuelPersonnage extends Visuel {
    private static final byte PERSONNAGE_HEIGHT = 64;
    private static final byte PERSONNAGE_WIDTH = 64;

    public VisuelPersonnage(int x, int y) {
        super(x, y, PERSONNAGE_HEIGHT, PERSONNAGE_WIDTH, ZIndex.CHARACTER);
    }

    @Override
    public void render() {
        //render
    }
}