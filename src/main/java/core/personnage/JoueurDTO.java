package main.java.core.personnage;

import main.java.utils.serialization.DTOElement;

public class JoueurDTO implements JoueurProcuration, DTOElement<Joueur> {
    private final String name;
    private final int velocity;

    public JoueurDTO(Joueur joueur) {
        this.name = joueur.getNom();
        this.velocity = joueur.getSpeed();
    }

    public String getNom() {
        return name;
    }

    public int getSpeed() {
        return velocity;
    }

    public Joueur getInstance(){
        return new Joueur(this);
    }
}
