package main.java.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
    private Navigator navigator;
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    @Override
    public void start(Stage stage){
        navigator = new Navigator(stage);
        setupFixedSize(navigator.getStage());

        navigator.switchScene((Files.exists(Paths.get("player.obj").toAbsolutePath()) ? FRAME.KNOWN_PLAYER_START : FRAME.START_PAGE), false);
        navigator.getStage().show();
    }

    private void setupFixedSize(Stage stage){
        stage.setMinHeight(MainFrame.HEIGHT);
        stage.setMaxHeight(MainFrame.HEIGHT);
        stage.setMinWidth(MainFrame.WIDTH);
        stage.setMaxWidth(MainFrame.WIDTH);
    }
}
