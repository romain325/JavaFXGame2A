package main.java.core.personnage;

import main.java.core.logic.GameAdvancement;

public interface JoueurProcuration {
    String getNom();
    int getSpeed();
    GameAdvancement getAdvancement();
}
