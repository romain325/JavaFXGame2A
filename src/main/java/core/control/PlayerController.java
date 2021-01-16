package main.java.core.control;

import main.java.core.control.action.Idle;
import main.java.core.logic.collision.Collisioner;
import main.java.core.personnage.Joueur;

public class PlayerController {
    private final Joueur joueur;
    private final Collisioner collisioner;

    public PlayerController(Joueur j, Collisioner collisioner){
        this.joueur = j;
        this.collisioner = collisioner;
    }

    /**
     * get controlled player
     * @return controlled player
     */
    public Joueur getJoueur(){
        return joueur;
    }

    /**
     * get game collisioner
     * @return game collisioner
     */
    public Collisioner getCollisionner(){
        return collisioner;
    }

    /**
     * do adadpted Action
     */
    public void doAction(){
        try{
            KeyBinder.getCurrentAction(this).interact();
        }catch (Exception e){
            new Idle(this).interact();
            e.printStackTrace();
        }
    }
}
