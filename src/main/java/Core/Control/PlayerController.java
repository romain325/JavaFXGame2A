package main.java.Core.Control;

import javafx.scene.input.KeyCode;
import main.java.Core.Personnage.Joueur;

public class PlayerController {
    private final Joueur joueur;

    private static byte velocity = 5;

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
        System.out.println("I Interacted on (" + joueur.getX() + "/" + joueur.getY() + ")");
    }

    public Action onKeyPressed(KeyCode code) {
        return InteractKey.getAction(code);
    }
}
