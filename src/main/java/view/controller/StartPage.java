package main.java.view.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.java.core.personnage.Joueur;
import main.java.utils.effect.VisualEffect;
import main.java.view.FRAME;
import main.java.view.MainFrame;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class StartPage implements Controller {
    @FXML
    private Button startEverything;
    @FXML
    private VBox firstText;
    @FXML
    private VBox secondText;
    @FXML
    private Button changeScene;
    @FXML
    private Button validName;
    @FXML
    private TextField fieldTxt;
    @FXML
    private Label lastText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*HIDING*/
        VisualEffect.hidePane(firstText);
        VisualEffect.hidePane(secondText);

        /*BINDING*/
        validName.visibleProperty().bind(fieldTxt.textProperty().isEmpty().not());
        validName.textProperty().bindBidirectional(fieldTxt.textProperty());

        changeScene.visibleProperty().bind(lastText.visibleProperty());


        /*BUTTON*/
        changeScene.setOnAction(actionEvent -> {
            MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new MainCanvasController(new Joueur(fieldTxt.getText())));
        });
        startEverything.setOnAction(actionEvent -> VisualEffect.showTextProgressively(firstText));
        validName.setOnAction(actionEvent -> VisualEffect.showTextProgressively(secondText));
    }

}
