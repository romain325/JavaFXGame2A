package main.java.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.Core.Control.KeyBinder;
import main.java.Core.Control.PlayerController;
import main.java.Core.Personnage.Joueur;

public class MainFrame extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vues/MainCanvas.fxml"));
        Scene currentScene = new Scene(root, 700, 700);
        setupFixedSize(stage,700,700); // CHANGE TO VAR

        // setup KeyListener by passing the scene
        KeyBinder.initContext(currentScene);

        stage.setTitle("MainFrame");
        stage.setScene(currentScene);
        stage.show();
    }

    private void setupFixedSize(Stage stage,int height, int width){
        stage.setMinHeight(height);
        stage.setMaxHeight(height);
        stage.setMinWidth(width);
        stage.setMaxWidth(width);
    }
}
