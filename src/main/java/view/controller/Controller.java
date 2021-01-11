package main.java.view.controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.view.Navigator;

import java.io.Serializable;

public interface Controller extends Initializable {
    void setNavigator(Navigator navigator);
    default void stop(){
        return;
    }
}
