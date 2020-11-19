package main.java.Core.Visual;

public class VisuelPersonnage extends Visuel {
    private static final byte PERSONNAGE_HEIGHT = 64;
    private static final byte PERSONNAGE_WIDTH = 64;

    public VisuelPersonnage(int x, int y) {
        super(x, y, PERSONNAGE_HEIGHT, PERSONNAGE_WIDTH);
    }

}
