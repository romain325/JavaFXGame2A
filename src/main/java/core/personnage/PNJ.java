package main.java.core.personnage;

import javafx.beans.property.StringProperty;
import main.java.core.logic.Interactive;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.sprite.StaticPlayerSprite;
import main.java.core.visual.ui.DialogBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class PNJ extends Personnage implements Interactive {
    public static int NIVEAU_FOLIE = 0;

    protected ArrayList<String> dialogs = new ArrayList<>();

    private boolean isBusy = false;

    protected final Vector interactZone = new Vector(40,40);

    public PNJ(String nom, Vector vector) {
        super(nom);
        this.visual = new StaticPlayerSprite("/img/char/"+this.getNom()+".png", vector);
        try {
            Scanner scanner = new Scanner(getClass().getResourceAsStream("/dialog/" + this.getNom() + ".txt"));
            while (scanner.hasNextLine()){
                this.dialogs.add(scanner.nextLine().replace("\n", System.lineSeparator()));
            }
        }catch (Exception e){
            this.dialogs.add("Error Opening file");
        }
    }

    @Override
    public void interact() {
        if(isBusy()) return;
        isBusy = true;
        System.out.println(getDialog());
        new DialogBox(getDialog());
        isBusy = false;
    }

    @Override
    public Vector getInteractZone() {
        return this.interactZone;
    }

    @Override
    public boolean isBusy() {
        return isBusy;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    public String getDialog(){
        return dialogs.get(NIVEAU_FOLIE);
    }
}
