package main.java.core.control;

import main.java.core.control.action.Action;
import main.java.core.control.action.ActionDeprecated;
import main.java.core.control.action.Interact;
import main.java.core.control.action.movement.MovementAction;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

public class PlayerController {
    private final Joueur joueur;

    private static byte velocity = 5;
    private static long lastInteraction = 0;

    public PlayerController(Joueur j){
        this.joueur = j;
    }

    private void move(ActionDeprecated d){
        int futurX = joueur.getX(), futurY = joueur.getY();
        switch (d){
            case UP:
                futurY -= velocity;
                break;
            case DOWN:
                futurY += velocity;
                break;
            case RIGHT:
                futurX += velocity;
                break;
            case LEFT:
                futurX -= velocity;
                break;
            default:
                break;
        }
        joueur.setCoord(futurX,futurY);
    }

    private void interact(){
        //Verif call rate with delay
        if(System.currentTimeMillis() - lastInteraction < 200){
            return;
        }

        // Set new lastInterTime
        lastInteraction = System.currentTimeMillis();

        // Code
        // System.out.println("I Interacted on (" + joueur.getX() + "/" + joueur.getY() + ")");

    }

    public void doAction(Action action){
        if(action instanceof MovementAction){
            ((MovementAction) action).move(new Vector(0,0),1);
            return;
        }
        if (action instanceof Interact){
            ((Interact) action).interact(new Vector(0,0));
            return;
        }
    }

    public void doAction(ActionDeprecated actionDeprecated) {
        switch (actionDeprecated){
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                move(actionDeprecated);
                break;
            case END:
                //end it all :)
                // see how to get the isRunning var of the GL
                break;
            case INTERACT:
                interact();
                break;
            case IDLE:
            default:
                //do ntg
                break;
        }
    }

    public void setVelocity(byte velocity){
        PlayerController.velocity = velocity;
    }
}
