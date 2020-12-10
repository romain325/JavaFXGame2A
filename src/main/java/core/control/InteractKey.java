package main.java.core.control;

import javafx.scene.input.KeyCode;
import main.java.core.control.action.ActionDeprecated;

public enum InteractKey {
    U_KEY(KeyCode.Z, ActionDeprecated.UP),
    D_KEY(KeyCode.S, ActionDeprecated.DOWN),
    L_KEY(KeyCode.Q, ActionDeprecated.LEFT),
    R_KEY(KeyCode.D, ActionDeprecated.RIGHT),
    INTERACT_KEY(KeyCode.E, ActionDeprecated.INTERACT),
    END_KEY(KeyCode.ESCAPE, ActionDeprecated.END)
    ;


    private final KeyCode code;
    private final ActionDeprecated actionDeprecated;

    public KeyCode getKeyCode(){
        return this.code;
    }

    public ActionDeprecated getAction() {
        return this.actionDeprecated;
    }

    InteractKey(KeyCode code, ActionDeprecated actionDeprecated) {
        this.code = code;
        this.actionDeprecated = actionDeprecated;
    }
}
