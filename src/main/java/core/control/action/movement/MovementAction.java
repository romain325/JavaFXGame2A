package main.java.core.control.action.movement;

import main.java.core.control.action.Action;
import main.java.core.logic.movement.Vector;

public interface MovementAction extends Action {
    void move(Vector position, int velocity);
}
