package main.java.core.personnage;

import main.java.core.item.Item;
import main.java.core.logic.advancement.GameAdvancement;
import main.java.core.logic.movement.Vector;
import main.java.core.visual.sprite.AnimatedPlayerSprite;
import main.java.utils.serialization.SerializableDTO;
import main.java.utils.serialization.SerializationManager;

import java.util.Collection;

public class Joueur extends Personnage implements JoueurProcuration, SerializableDTO<JoueurDTO> {
    private GameAdvancement gameAdvancement = new GameAdvancement();
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
        this.gameAdvancement = dto.getAdvancement();
        PNJ.NIVEAU_FOLIE = gameAdvancement.getDayElapsed();
    }

    public void setCoord(int x, int y){
        setX(x);
        setY(y);
    }

    public void setCoord(Vector pos){
        setCoord(pos.getX(), pos.getY());
    }

    @Override
    public void setX(int x) {
        //TODO Add collision Check
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        //TODO Add collision Check, maybve not here
        super.setY(y);
    }

    public int getSpeed(){
        return this.speed;
    }

    @Override
    public GameAdvancement getAdvancement() {
        return gameAdvancement;
    }

    public JoueurDTO getDTO(){
        return new JoueurDTO(this);
    }

    public void save(){
        SerializationManager.serializeObject("player.obj", this);
    }
}
