package main.java.core.control.action;

import main.java.core.control.PlayerController;

public class Idle extends Action {
    public Idle(PlayerController player) {
        super(player);
    }

    @Override
    public void interact() {
        return;
    }
}
