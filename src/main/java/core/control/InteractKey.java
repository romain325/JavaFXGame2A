package main.java.core.control;

import javafx.scene.input.KeyCode;
import main.java.core.control.action.*;
import main.java.core.control.action.movement.Down;
import main.java.core.control.action.movement.Left;
import main.java.core.control.action.movement.Right;
import main.java.core.control.action.movement.Up;
import main.java.core.logic.movement.Vector;
import main.java.core.personnage.Joueur;

import java.lang.reflect.InvocationTargetException;

public enum InteractKey {
    U_KEY(KeyCode.Z, Up.class),
    D_KEY(KeyCode.S, Down.class),
    L_KEY(KeyCode.Q, Left.class),
    R_KEY(KeyCode.D, Right.class),
    INTERACT_KEY(KeyCode.E, Interact.class),
    END_KEY(KeyCode.ESCAPE, End.class),
    NONE_KEY(null,Idle.class)
    ;


    private final KeyCode code;
    private final Class action;

    public KeyCode getKeyCode(){
        return this.code;
    }

    public Action getAction(Joueur player) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Action) this.action.getConstructor(Joueur.class).newInstance(player);
    }

    public static InteractKey getInteractKey(KeyCode code){
        for (InteractKey key :  InteractKey.values()){
            if(key.getKeyCode() == code){
                return key;
            }
        }
        return NONE_KEY;
    }

    InteractKey(KeyCode code, Class actionClass) {
        this.code = code;
        this.action = actionClass;
    }
}
