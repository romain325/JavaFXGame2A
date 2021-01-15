package main.java.view.controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.JoueurDTO;
import main.java.utils.effect.VisualEffect;
import main.java.utils.serialization.SerializationManager;
import main.java.view.FRAME;
import main.java.view.MainFrame;
import main.java.view.Navigator;

import javax.naming.Binding;
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
    private Navigator navigator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*PLAYER INFORMATION*/
        this.joueur = new Joueur(SerializationManager.<JoueurDTO>deserializeObject("player.obj"));
        playerName.textProperty().bind(Bindings.format("..%s ?? Am I right?", this.joueur.getNom()));

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
            if(ButtonType.YES.equals(alert.showAndWait().orElse(ButtonType.NO))){
                navigator.switchScene(FRAME.PLAYABLE_CANVAS, true, new MainCanvasController(this.joueur));
            }else {
                VisualEffect.showTextProgressively(secondText);
            }
        });
        startAgain.setOnAction(actionEvent -> navigator.switchScene(FRAME.START_PAGE, false));
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
