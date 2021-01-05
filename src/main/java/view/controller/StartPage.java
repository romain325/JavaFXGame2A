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
        hidePane(firstText);
        hidePane(secondText);

        /*BINDING*/
        validName.visibleProperty().bind(fieldTxt.textProperty().isEmpty().not());
        validName.textProperty().bindBidirectional(fieldTxt.textProperty());

        changeScene.visibleProperty().bind(lastText.visibleProperty());


        /*BUTTON*/
        changeScene.setOnAction(actionEvent -> {
            MainFrame.switchScene(FRAME.PLAYABLE_CANVAS, true, new MainCanvasController(new Joueur(fieldTxt.getText())));
        });
        startEverything.setOnAction(actionEvent -> showTextProgressively(firstText));
        validName.setOnAction(actionEvent -> showTextProgressively(secondText));
    }

    private void hidePane(Pane pane){
        pane.setVisible(false);
        for (var node: pane.getChildren()) {
            node.setVisible(false);
        }
    }

    private void showTextProgressively(Pane pane) {
        if(pane.isVisible()) return;
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        pane.setVisible(true);
        int it = 0;
        for (var node : pane.getChildren()) {
            it++;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(500*it),
                            new KeyValue(node.visibleProperty(), true)
                    ));
        }
        timeline.play();
    }
}
