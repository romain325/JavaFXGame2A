package main.java.core.personnage;

import main.java.core.logic.GameProgression;
import main.java.utils.Vector;
import main.java.core.visual.sprite.AnimatedPlayerSprite;
import main.java.utils.serialization.SerializableDTO;
import main.java.utils.serialization.SerializationManager;

public class Joueur extends Personnage implements JoueurProcuration, SerializableDTO<JoueurDTO> {
    private GameProgression gameProgression = new GameProgression();
    private int speed;

    public Joueur(String nom, int speed) {
        super(nom);
        this.visual = new AnimatedPlayerSprite("/img/char/player", this.getPosition());
        this.speed = speed;
    }

    public Joueur(String nom) {
        this(nom,5);
    }

    public Joueur(JoueurDTO dto){
        this(dto.getNom(), dto.getSpeed());
        this.gameProgression = dto.getAdvancement();
        PNJ.NIVEAU_FOLIE = gameProgression.getDayElapsed();
    }

    @Override
    public int getSpeed(){
        return this.speed;
    }

    @Override
    public GameProgression getAdvancement() {
        return gameProgression;
    }

    @Override
    public JoueurDTO getDTO(){
        return new JoueurDTO(this);
    }

    @Override
    public void save(){
        SerializationManager.serializeObject("player.obj", this);
    }
}
