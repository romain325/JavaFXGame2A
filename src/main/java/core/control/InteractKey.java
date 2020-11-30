package main.java.core.control;

import javafx.scene.input.KeyCode;

public enum InteractKey {
    U_KEY(KeyCode.Z, Action.UP),
    D_KEY(KeyCode.S, Action.DOWN),
    L_KEY(KeyCode.Q, Action.LEFT),
    R_KEY(KeyCode.D, Action.RIGHT),
    INTERACT_KEY(KeyCode.E, Action.INTERACT),
    END_KEY(KeyCode.ESCAPE, Action.END)
    ;


    private final KeyCode code;
    private final Action action;

    public KeyCode getKeyCode(){
        return this.code;
    }

    public Action getAction() {
        return this.action;
    }

    InteractKey(KeyCode code, Action action) {
        this.code = code;
        this.action = action;
    }
}
