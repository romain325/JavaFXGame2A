package main.java.core.control;

import javafx.scene.input.KeyCode;
import main.java.core.control.action.*;
import main.java.core.control.action.movement.Down;
import main.java.core.control.action.movement.Left;
import main.java.core.control.action.movement.Right;
import main.java.core.control.action.movement.Up;

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

    /**
     * get enum keycode
     * @return KeyCode
     */
    public KeyCode getKeyCode(){
        return this.code;
    }

    /**
     * get an action instance from an Interactkey
     * @param player Ingame player controlelr
     * @return instance of an action
     */
    public Action getAction(PlayerController player) {
        try{
            return (Action) this.action.getConstructor(PlayerController.class).newInstance(player);
        }catch(Exception e){
            return new Idle(player);
        }
    }

    /**
     * get the correlated interact key from a KeyCode
     * @param code KeyCode
     * @return correlated InteractKey
     */
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
