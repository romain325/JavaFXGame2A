package main.java.core.item;

import main.java.core.logic.movement.Vector;

public interface ItemProcuration {
    boolean hasIllimitedConsommation();
    String getMessage();
    Vector getPosition();
    int getWidth();
    int getHeight();
    String getNom();
    boolean hasCollision();
    int getHintValue();
    int getApparitionDay();
}
