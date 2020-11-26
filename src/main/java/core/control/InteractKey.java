package main.java.core.control;

import javafx.scene.input.KeyCode;

import java.util.EnumMap;

public enum InteractKey {
    U_KEY(KeyCode.Z, Action.UP),
    D_KEY(KeyCode.S, Action.DOWN),
    L_KEY(KeyCode.Q, Action.LEFT),
    R_KEY(KeyCode.D, Action.RIGHT),
    INTERACT_KEY(KeyCode.E, Action.INTERACT),
    END_KEY(KeyCode.ESCAPE, Action.END)
    ;


    private final KeyCode code;
    private static final EnumMap<KeyCode, Action> action = new EnumMap<>(KeyCode.class);

    public KeyCode getKeyCode(){
        return this.code;
    }
    public static Action getAction(KeyCode k){
        return action.get(k) == null ? Action.IDLE : action.get(k);
    }

    private void addPair(KeyCode code, Action action){
        InteractKey.action.put(code,action);
    }

    InteractKey(KeyCode code, Action action) {
        this.code = code;
        addPair(code,action);
    }
}
