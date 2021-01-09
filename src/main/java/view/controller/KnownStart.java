package main.java.view.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.JoueurDTO;
import main.java.utils.effect.VisualEffect;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;
import main.java.view.MainFrame;

import java.net.URL;
import java.util.ResourceBundle;

public class KnownStart implements Controller{
    @FXML
    private Button startEverything;
    @FXML
    private VBox firstText;
    @FXML
    private VBox secondText;
    @FXML
    private Button validIdentity;
    @FXML
    private Label playerName;
    @FXML
    private Button startAgain;
    @FXML
    private Label lastText;

    private Joueur joueur;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.joueur = new Joueur(SerializationManager.<JoueurDTO>deserializeObject("player.obj"));
        playerName.setText(".." + this.joueur.getNom() + " ??" );

        /*HIDING*/
        VisualEffect.hidePane(firstText);
        VisualEffect.hidePane(secondText);

        /*BINDING*/
        validIdentity.visibleProperty().bind(playerName.visibleProperty());
        startAgain.visibleProperty().bind(lastText.visibleProperty());

        /*BUTTON*/
        startEverything.setOnAction(actionEvent -> VisualEffect.showTextProgressively(firstText));
        validIdentity.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Is that you ? " + joueur.getNom() + " ?", ButtonType.YES, ButtonType.NO);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            if(ButtonType.YES.equals(result)){
                MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new MainCanvasController(this.joueur));
            }else {
                VisualEffect.showTextProgressively(secondText);
            }
        });
        startAgain.setOnAction(actionEvent -> MainFrame.switchScene(FRAME.START_PAGE, false));
    }
}
