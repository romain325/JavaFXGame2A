package main.java.core.personnage.pnjs;

import javafx.scene.paint.Color;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.PNJ;

public class John extends PNJ {
    public John() {
        super("John", new Vector(100 ,605), false);
    }
    public John(boolean debug){
        this();
        this.getVisual().setDebugMode(Color.PALEGOLDENROD);
    }
}
