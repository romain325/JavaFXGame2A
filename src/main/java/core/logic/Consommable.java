package main.java.core.logic;

import main.java.core.control.PlayerController;

public interface Consommable {
    /**
     * Is the entity consumed
     * @return boolean is consumed ?
     */
    boolean isConsumed();

    /**
     * Does the entity has unlimited consommation
     * @return boolean
     */
    boolean hasIllimitedConsommation();

    /**
     * Consume the entity
     * @param playerController player that consume the entity
     */
    void consume(PlayerController playerController);
}
