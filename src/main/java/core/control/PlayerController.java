package main.java.core.control;

import main.java.core.personnage.Joueur;

public class PlayerController {
    private final Joueur joueur;
    private static long lastInteraction = 0;

    public PlayerController(Joueur j){
        this.joueur = j;
    }

    public void doAction(){
        try{
            KeyBinder.getCurrentAction(this.joueur).interact();
        }catch (Exception e){
            System.out.println("KeyBinding Error");
            return;
        }
    }
}
