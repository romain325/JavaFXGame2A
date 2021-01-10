package main.java.core.personnage.pnjs;

import javafx.scene.paint.Color;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.PNJ;

public class Marie extends PNJ {

    public Marie() {
        super("Marie", new Vector(200 ,200), false);
    }
    public Marie(boolean debug){
        this();
        this.getVisual().setDebugMode(Color.PALEGOLDENROD);
    }
}
