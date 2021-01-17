package main.java.core.personnage;

import main.java.core.logic.GameProgression;
import main.java.utils.serialization.DTOElement;

public class JoueurDTO implements JoueurProcuration, DTOElement<Joueur> {
    private final String name;
    private final int velocity;
    private final GameProgression gameProgression;

    public JoueurDTO(Joueur joueur) {
        this.name = joueur.getNom();
        this.velocity = joueur.getSpeed();
        this.gameProgression = joueur.getAdvancement();
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
    public GameProgression getAdvancement() {
        return gameProgression;
    }

    @Override
    public Joueur getInstance(){
        return new Joueur(this);
    }
}
