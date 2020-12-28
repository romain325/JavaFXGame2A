package main.java.core.personnage.pnjs;

import javafx.scene.paint.Color;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.PNJ;

public class Andre extends PNJ {
    public Andre() {
        super("Andre", new Vector(100,150));
    }
    public Andre(boolean debug){
        this();
        this.getVisual().setDebugMode(Color.PALEGOLDENROD);
    }

    @Override
    public void dialog() {
        System.out.println("Moi c'est " + this.getNom());
    }
}
