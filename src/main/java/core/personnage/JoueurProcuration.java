package main.java.core.personnage;

import main.java.core.logic.GameProgression;

public interface JoueurProcuration {
    /**
     * get joueur name
     * @return player name
     */
    String getNom();

    /**
     * get player velocity
     * @return get velocity
     */
    int getSpeed();

    /**
     * get player progression
     * @return progression
     */
    GameProgression getAdvancement();
}
