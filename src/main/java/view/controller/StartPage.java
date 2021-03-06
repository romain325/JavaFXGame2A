package main.java.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import main.java.core.control.InteractKey;
import main.java.core.personnage.Joueur;
import main.java.utils.effect.VisualEffect;
import main.java.view.FRAME;
import main.java.view.Navigator;

import java.net.URL;
import java.util.ResourceBundle;

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

    private Navigator navigator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*Add Elements*/
        String[] keysInfo = new String[]{
                "Little advice from me !",
                "Use " + InteractKey.U_KEY.getKeyCode() + InteractKey.L_KEY.getKeyCode() + InteractKey.D_KEY.getKeyCode() + InteractKey.R_KEY.getKeyCode() + " to move",
                InteractKey.INTERACT_KEY.getKeyCode() + " to interact with an element",
                "And " + InteractKey.END_KEY.getKeyCode() +  " to exit the game!"
        };

        for(var e : keysInfo){
            secondText.getChildren().add(secondText.getChildren().size()-1, new Label(e));
        }

        /*HIDING*/
        VisualEffect.hidePane(firstText);
        VisualEffect.hidePane(secondText);

        /*BINDING*/
        validName.visibleProperty().bind(fieldTxt.textProperty().isEmpty().not());
        validName.textProperty().bindBidirectional(fieldTxt.textProperty());

        changeScene.visibleProperty().bind(lastText.visibleProperty());


        /*BUTTON*/
        changeScene.setOnAction(actionEvent -> {
            navigator.switchScene(FRAME.PLAYABLE_CANVAS, true, new MainCanvasController(new Joueur(fieldTxt.getText())));
        });
        startEverything.setOnAction(actionEvent -> VisualEffect.showElementProgressively(firstText));
        validName.setOnAction(actionEvent -> VisualEffect.showElementProgressively(secondText));
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
