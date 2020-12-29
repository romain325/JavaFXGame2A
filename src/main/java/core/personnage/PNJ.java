package main.java.core.personnage;

import main.java.core.logic.Interactive;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.sprite.StaticPlayerSprite;

public abstract class PNJ extends Personnage implements Interactive {
    public static int NIVEAU_FOLIE = 0;

    private boolean isBusy = false;

    protected final Vector interactZone = new Vector(40,40);

    public PNJ(String nom, Vector vector) {
        super(nom);
        this.visual = new StaticPlayerSprite("/img/char/"+this.getNom()+".png", vector);
    }

    public abstract String getDialog();

    @Override
    public void interact() {
        if(isBusy()) return;
        isBusy = true;
        System.out.println(getDialog());
        isBusy = false;
    }

    @Override
    public Vector getInteractZone() {
        return this.interactZone;
    }

    @Override
    public Vector getPos() {
        return this.getPosition();
    }

    @Override
    public boolean isBusy() {
        return isBusy;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }
}
