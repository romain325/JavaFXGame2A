package main.java.view;

import com.sun.glass.ui.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.core.control.KeyBinder;

import java.io.IOException;
import java.util.Map;

public class MainFrame extends Application {
    private static Stage rootStage;
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    protected static final Map<String, String> VIEWS = Map.of("MainCanvas", "/Vues/MainCanvas.fxml", "StartPage", "/Vues/StartPage.fxml");

    @Override
    public void start(Stage stage){
        rootStage = stage;

        setupFixedSize(rootStage); // CHANGE TO VAR

        switchScene("StartPage", false);

        rootStage.setTitle("SuperJeu");

        rootStage.show();
    }

    public static void switchScene(String name, boolean listening){
        Parent root = null;

        root = getView(name);

        Scene currentScene = new Scene(root, WIDTH, HEIGHT);

        // setup keyListener
        if(listening){
            KeyBinder.initContext(currentScene);
        }

        rootStage.setScene(currentScene);
    }

    protected static Parent getView(String name) {
        String val = (VIEWS.get(name) == null) ? VIEWS.get("StartPage") : VIEWS.get(name);
        try {
            return FXMLLoader.load(MainFrame.class.getResource(val));
        } catch (IOException e) { return null; }
    }

    private void setupFixedSize(Stage stage){
        stage.setMinHeight(MainFrame.HEIGHT);
        stage.setMaxHeight(MainFrame.HEIGHT);
        stage.setMinWidth(MainFrame.WIDTH);
        stage.setMaxWidth(MainFrame.WIDTH);
    }
}
