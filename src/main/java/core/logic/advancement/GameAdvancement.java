package main.java.core.logic.advancement;

import main.java.core.item.Item;
import main.java.core.personnage.PNJ;
import main.java.utils.serialization.SerializableDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GameAdvancement implements Serializable {
    private boolean suspicion = false;
    private int dayElapsed = 0;
    private Set<String> collectedItems = new HashSet<>();
    private int nbHints = 0;



    public boolean hasSuspicion() {
        return suspicion;
    }

    public int getDayElapsed() {
        return dayElapsed;
    }

    public void addDay() {
        this.dayElapsed += 1;
        PNJ.NIVEAU_FOLIE++;
    }

    public int getNbHints() {
        return nbHints;
    }

    public Set<String> getCollectedItems() {
        return collectedItems;
    }

    public void addCollectedItem(Item item){
        collectedItems.add(item.getNom());
        nbHints += item.getHintValue();
        if(nbHints > 8){
            this.suspicion = true;
        }
    }
}
