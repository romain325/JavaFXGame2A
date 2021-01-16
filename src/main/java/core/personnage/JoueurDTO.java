package main.java.core.personnage;

import main.java.core.logic.GameAdvancement;
import main.java.utils.serialization.DTOElement;

public class JoueurDTO implements JoueurProcuration, DTOElement<Joueur> {
    private final String name;
    private final int velocity;
    private final GameAdvancement gameAdvancement;

    public JoueurDTO(Joueur joueur) {
        this.name = joueur.getNom();
        this.velocity = joueur.getSpeed();
        this.gameAdvancement = joueur.getAdvancement();
    }

    @Override
    public String getNom() {
        return name;
    }

    @Override
    public int getSpeed() {
        return velocity;
    }

    @Override
    public GameAdvancement getAdvancement() {
        return gameAdvancement;
    }

    @Override
    public Joueur getInstance(){
        return new Joueur(this);
    }
}
