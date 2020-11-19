package main.java.Control;

import main.java.Launch.GameLoop;
import main.java.Personnage.Joueur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class PlayerController implements KeyListener {
    private final Joueur joueur;
    private static final int U_KEY = KeyEvent.VK_Z;
    private static final int D_KEY = KeyEvent.VK_S;
    private static final int L_KEY = KeyEvent.VK_Q;
    private static final int R_KEY = KeyEvent.VK_R;
    private static final int INTERACT_KEY = KeyEvent.VK_E;
    private static final int END_KEY = KeyEvent.VK_ENTER;
    private static byte velocity = 5;

    public PlayerController(Joueur j){
        this.joueur = j;
        addKeyListener(this);
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
                futurY -= velocity;
                break;
            default:
                break;
        }
        joueur.setCoord(futurX,futurY);
    }

    private void interact(){
        System.out.println("I Interacted on (" + joueur.getX() + "/" + joueur.getY() + ")");
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()){
            case INTERACT_KEY:
                interact();
                break;
            case END_KEY:
                GameLoop.EndGame();
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        Direction D;
        switch (keyEvent.getKeyCode()){
            case U_KEY:
                D = Direction.UP;
                break;

            case D_KEY:
                D = Direction.DOWN;
                break;

            case L_KEY:
                D = Direction.LEFT;
                break;

            case R_KEY:
                D = Direction.RIGHT;
                break;

            default:
                D = Direction.IDLE;
                break;
        }
        move(D);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
