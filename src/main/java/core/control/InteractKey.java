package main.java.core.control;

import javafx.scene.input.KeyCode;

import java.util.EnumMap;
import java.util.HashMap;

public enum InteractKey {
    U_KEY(KeyCode.Z, Action.UP),
    D_KEY(KeyCode.S, Action.DOWN),
    L_KEY(KeyCode.Q, Action.LEFT),
    R_KEY(KeyCode.D, Action.RIGHT),
    INTERACT_KEY(KeyCode.E, Action.INTERACT),
    END_KEY(KeyCode.ESCAPE, Action.END)
    ;


    private final KeyCode code;
    private static HashMap<KeyCode,Action> action = new HashMap<>();

    public KeyCode getKeyCode(){
        return this.code;
    }
    public static Action getAction(KeyCode k){
        return action.get(k) == null ? Action.IDLE : action.get(k);
    }
    public Action getAction() {
        return InteractKey.getAction(this.getKeyCode());
    }

    private void addPair(KeyCode code, Action action){
        if (InteractKey.action == null){
            InteractKey.action = new HashMap<>();
        }
        InteractKey.action.put(code,action);
    }

    InteractKey(KeyCode code, Action action) {
        this.code = code;
        addPair(code,action);
    }
}
