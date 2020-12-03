package main.java.view.controller;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.view.MainFrame;

import java.net.URL;
import java.util.ResourceBundle;

public class StartPage implements Initializable {
    @FXML
    private Button changeScene;
    @FXML
    private Label labelTxt;
    @FXML
    private TextField fieldTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelTxt.textProperty().bindBidirectional(fieldTxt.textProperty());
        changeScene.setOnAction(actionEvent -> {
            MainFrame.switchScene("MainCanvas", true);
        });
    }
}
