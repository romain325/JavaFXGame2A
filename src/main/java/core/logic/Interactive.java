package main.java.core.logic;

import main.java.core.control.PlayerController;
import main.java.utils.Vector;

public interface Interactive {
    /**
     * is the entity interactive
     * @return boolean
     */
    boolean isInteractive();

    /**
     * interact with the given entity
     * @param playerController player that interact with the entity
     */
    void interact(PlayerController playerController);

    /**
     * get the entity InteractionZone
     * @return Vector of height/width for the zone
     */
    Vector getInteractZone();

    /**
     * get Interactive position
     * @return posiiton
     */
    Vector getPosition();

    /**
     * get Interactive object height
     * @return height
     */
    int getHeight();

    /**
     * get Interactive object width
     * @return width
     */
    int getWidth();

    /**
     * is the current interactive obejct busy
     * @return boolean
     */
    boolean isBusy();
}
