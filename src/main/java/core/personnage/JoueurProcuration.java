package main.java.core.personnage;

import main.java.core.logic.advancement.GameAdvancement;

public interface JoueurProcuration {
    String getNom();
    int getSpeed();
    GameAdvancement getAdvancement();
}
