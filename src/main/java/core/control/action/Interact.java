package main.java.core.control.action;

import main.java.core.control.PlayerController;

import javax.management.InstanceNotFoundException;

public class Interact extends Action {

    private static long lastInteraction = 0;

    public Interact(PlayerController player) {
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
        try {
            System.out.println(getPlayer().getJoueur().getPosition());
            getPlayer().getCollisionner().getInteractiveObject(getPlayer().getJoueur().getVisual()).interact(getPlayer());
        } catch (InstanceNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

}
