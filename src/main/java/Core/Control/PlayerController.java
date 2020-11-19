package main.java.Core.Control;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.java.Launch.GameLoop;
import main.java.Core.Personnage.Joueur;

public class PlayerController {
    private final Joueur joueur;
    private static final KeyCode U_KEY = KeyCode.Z;
    private static final KeyCode D_KEY = KeyCode.S;
    private static final KeyCode L_KEY = KeyCode.Q;
    private static final KeyCode R_KEY = KeyCode.D;
    private static final KeyCode INTERACT_KEY = KeyCode.E;
    private static final KeyCode END_KEY = KeyCode.ENTER;
    private static byte velocity = 5;

    public PlayerController(Joueur j){
        this.joueur = j;
    }

    private void move(Direction d){
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

    public void keyPressed(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        if(code.equals(INTERACT_KEY)){
            interact();
            return;
        }
        if(code.equals(END_KEY)){
            GameLoop.EndGame();
            return;
        }

        if(code.equals(U_KEY) || code.equals(D_KEY) || code.equals(R_KEY) || code.equals(L_KEY)){
            Direction D = Direction.IDLE;
            if(code.equals(U_KEY)){
                D = Direction.UP;
            }
            if(code.equals(D_KEY)){
                D = Direction.DOWN;
            }
            if(code.equals(R_KEY)){
                D = Direction.RIGHT;
            }
            if(code.equals(L_KEY)){
                D = Direction.LEFT;
            }
            move(D);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void SetUpListener(Scene scene){
        System.out.println(scene.getHeight());
        scene.setOnKeyPressed(this::keyPressed);
    }
}
