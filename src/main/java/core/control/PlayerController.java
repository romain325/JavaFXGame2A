package main.java.core.control;

import main.java.core.logic.Collisionner;
import main.java.core.personnage.Joueur;
import main.java.core.visual.map.Map;

public class PlayerController {
    private final Joueur joueur;
    private final Collisionner collisionner;
    private static long lastInteraction = 0;

    public PlayerController(Joueur j, Collisionner collisionner){
        this.joueur = j;
        this.collisionner = collisionner;
    }

    public Joueur getJoueur(){
        return joueur;
    }
    public Collisionner getCollisionner(){
        return collisionner;
    }

    public void doAction(){
        try{
            KeyBinder.getCurrentAction(this).interact();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("KeyBinding Error");
            return;
        }
    }
}
