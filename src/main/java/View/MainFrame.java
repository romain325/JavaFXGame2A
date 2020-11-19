package main.java.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.Core.Control.PlayerController;
import main.java.Core.Personnage.Joueur;

public class MainFrame extends Application {
    private static Scene currentScene;
    @Override
    public void start(Stage stage) throws Exception {
        PlayerController pc = new PlayerController(new Joueur("Pedro"));
        Parent root = FXMLLoader.load(getClass().getResource("/Vues/MainGrid.fxml"));
        stage.setTitle("MainFrame");
        currentScene = new Scene(root, 600,400);
        pc.SetUpListener(currentScene);
        stage.setScene(currentScene);
        stage.show();
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }
}
