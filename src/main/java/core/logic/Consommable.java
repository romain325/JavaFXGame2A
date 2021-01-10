package main.java.core.logic;

import main.java.core.control.PlayerController;

public interface Consommable {
    boolean isConsumed();
    boolean hasIllimitedConsommation();
    void consume(PlayerController playerController);
}
