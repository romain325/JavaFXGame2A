package main.java.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.core.control.KeyBinder;
import main.java.view.controller.Controller;
import main.java.view.controller.DefaultCanvasController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFrame extends Application {
    private static Stage rootStage;
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    @Override
    public void start(Stage stage){
        rootStage = stage;

        setupFixedSize(rootStage); // CHANGE TO VAR

        System.out.println(Files.exists(Paths.get("player.obj").toAbsolutePath()));
        switchScene((Files.exists(Paths.get("player.obj").toAbsolutePath()) ? FRAME.KNOWN_PLAYER_START : FRAME.START_PAGE), false);

        rootStage.initStyle(StageStyle.UNDECORATED);
        rootStage.setTitle("SuperJeu");

        rootStage.show();
    }

    public static void switchScene(FRAME frame, boolean listening, Controller controller){
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(MainFrame.class.getResource(frame.getLink()));

        if(controller != null) {
            fxmlLoader.setController(controller);
        }
        if(frame == FRAME.PLAYABLE_CANVAS && controller == null) throw new IllegalArgumentException("A playable Canvas should have a specified controller");

        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            fxmlLoader = new FXMLLoader(MainFrame.class.getResource(FRAME.START_PAGE.getLink()));
            e.printStackTrace();
            try {
                root =fxmlLoader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        assert root != null;
        Scene currentScene = new Scene(root, WIDTH, HEIGHT);

        // setup keyListener
        if(listening){
            KeyBinder.initContext(currentScene);
        }

        rootStage.setScene(currentScene);
    }

    public static void switchScene(FRAME frame, boolean listening){
        switchScene(frame, listening, null);
    }

    private void setupFixedSize(Stage stage){
        stage.setMinHeight(MainFrame.HEIGHT);
        stage.setMaxHeight(MainFrame.HEIGHT);
        stage.setMinWidth(MainFrame.WIDTH);
        stage.setMaxWidth(MainFrame.WIDTH);
    }
}
