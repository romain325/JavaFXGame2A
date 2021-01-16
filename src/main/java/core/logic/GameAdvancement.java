package main.java.core.logic;

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

    /**
     * does the player have suspicion about what's happening
     * @return suspsicion are important enough ?
     */
    public boolean hasSuspicion() {
        return suspicion;
    }

    /**
     * Number of days elapsed since the beginning of the game
     * @return days elapsed
     */
    public int getDayElapsed() {
        return dayElapsed;
    }

    /**
     * add a new day to the counter
     */
    public void addDay() {
        this.dayElapsed += 1;
        PNJ.NIVEAU_FOLIE++;
    }

    /**
     * get Player number of Hints collected
     * @return number of hints collected
     */
    public int getNbHints() {
        return nbHints;
    }

    /**
     * Set of already collected items
     * @return colelcted items
     */
    public Set<String> getCollectedItems() {
        return collectedItems;
    }

    /**
     * mark an item as collected
     * @param item item to mark
     */
    public void addCollectedItem(Item item){
        collectedItems.add(item.getNom());
        nbHints += item.getHintValue();
        if(nbHints > 8){
            this.suspicion = true;
        }
    }
}
