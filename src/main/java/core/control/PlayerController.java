package main.java.core.control;

import main.java.core.control.action.Action;
import main.java.core.control.action.ActionDeprecated;
import main.java.core.control.action.Interact;
import main.java.core.control.action.movement.MovementAction;
import main.java.core.logic.movement.Vector;
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
