package main.java.core.control;

import javafx.scene.input.KeyCode;
import main.java.core.personnage.Joueur;

public class PlayerController {
    private final Joueur joueur;

    private static byte velocity = 5;
    private static long lastInteraction = 0;

    public PlayerController(Joueur j){
        this.joueur = j;
    }

    private void move(Action d){
        int futurX = joueur.getX(), futurY = joueur.getY();
        switch (d){
            case UP:
                futurY += velocity;
                break;
            case DOWN:
                futurY -= velocity;
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

    public void doAction(Action action) {
        switch (action){
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                move(action);
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
}
