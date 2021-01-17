package main.java.view.controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.view.Navigator;

import java.io.Serializable;

public interface Controller extends Initializable {
    /**
     * Set the navigator used for the controller
     * @param navigator navigator which will be used
     */
    void setNavigator(Navigator navigator);

    /**
     * Stop the usage of the controller
     */
    default void stop(){
        return;
    }
}
