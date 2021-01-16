package main.java.core.item;

import main.java.utils.Vector;

public interface ItemProcuration {
    /**
     * Getter
     * @return value
     */
    boolean hasIllimitedConsommation();
    /**
     * Getter
     * @return value
     */
    String getMessage();
    /**
     * Getter
     * @return value
     */
    Vector getPosition();
    /**
     * Getter
     * @return value
     */
    int getWidth();
    /**
     * Getter
     * @return value
     */
    int getHeight();
    /**
     * Getter
     * @return value
     */
    String getNom();
    /**
     * Getter
     * @return value
     */
    boolean hasCollision();
    /**
     * Getter
     * @return value
     */
    int getHintValue();
    /**
     * Getter
     * @return value
     */
    int getApparitionDay();
}
