package main.java.core.control.action;

import main.java.core.control.PlayerController;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class Interact extends Action {

    private static long lastInteraction = 0;

    public Interact(Joueur player) {
        super(player);
    }

    @Override
    public void interact(){
        //Verif call rate with delay
        if(System.currentTimeMillis() - lastInteraction < 200){
            return;
        }

        // Set new lastInterTime
        lastInteraction = System.currentTimeMillis();

        // Code
        System.out.println("I Interacted on (" + this.player.getX() + "/" + this.player.getY() + ")");

    }

}
