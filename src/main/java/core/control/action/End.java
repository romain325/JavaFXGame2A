package main.java.core.control.action;

import javafx.application.Platform;
import main.java.core.control.PlayerController;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.JoueurDTO;
import main.java.utils.serialization.SerializationManager;

public class End extends Action {
    public End(PlayerController player) {
        super(player);
    }

    @Override
    public void interact() {
        SerializationManager.serializeObject("player.obj", this.player.getJoueur());
        Platform.exit();
    }
}
