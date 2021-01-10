package main.java.core.personnage.pnjs;

import javafx.scene.paint.Color;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.PNJ;

public class Marie extends PNJ {

    public Marie() {
        super("Marie", new Vector(150,150));
    }
    public Marie(boolean debug){
        this();
        this.getVisual().setDebugMode(Color.PALEGOLDENROD);
    }
}
