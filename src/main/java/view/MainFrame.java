package main.java.view;

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

    @Override
    public void start(Stage stage){
        rootStage = stage;

        setupFixedSize(rootStage); // CHANGE TO VAR

        switchScene(FRAME.START_PAGE, false);

        rootStage.setTitle("SuperJeu");

        rootStage.show();
    }

    public static void switchScene(FRAME frame, boolean listening){
        Parent root = null;

        root = getView(frame);

        Scene currentScene = new Scene(root, WIDTH, HEIGHT);

        // setup keyListener
        if(listening){
            KeyBinder.initContext(currentScene);
        }

        rootStage.setScene(currentScene);
    }

    protected static Parent getView(FRAME frame) {
        try {
            return FXMLLoader.load(MainFrame.class.getResource(frame.getLink()));
        } catch (IOException e) { return null; }
    }


    private void setupFixedSize(Stage stage){
        stage.setMinHeight(MainFrame.HEIGHT);
        stage.setMaxHeight(MainFrame.HEIGHT);
        stage.setMinWidth(MainFrame.WIDTH);
        stage.setMaxWidth(MainFrame.WIDTH);
    }
}
