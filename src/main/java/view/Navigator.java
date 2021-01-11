package main.java.view;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.core.control.KeyBinder;
import main.java.view.controller.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Navigator implements Initializable {
    private final Stage rootStage;

    public Navigator(Stage rootStage) {
        this.rootStage = rootStage;
        initialize(null, null);
    }

    public void switchScene(FRAME frame, boolean listening, Controller controller){
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(frame.getLink()));

        if(controller != null) {
            fxmlLoader.setController(controller);
        }
        if(frame == FRAME.PLAYABLE_CANVAS && controller == null) throw new IllegalArgumentException("A playable Canvas should have a specified controller");


        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            fxmlLoader = new FXMLLoader(getClass().getResource(FRAME.START_PAGE.getLink()));
            e.printStackTrace();
            try {
                root = fxmlLoader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }finally {
            ((Controller)fxmlLoader.getController()).setNavigator(this);
        }

        assert root != null;
        Scene currentScene = new Scene(root, MainFrame.WIDTH, MainFrame.HEIGHT, Color.BLACK);

        // setup keyListener
        if(listening){
            KeyBinder.initContext(currentScene);
        }

        rootStage.setScene(currentScene);
        rootStage.show();
    }

    public void switchScene(FRAME frame, boolean listening){
        switchScene(frame, listening, null);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootStage.initStyle(StageStyle.UNDECORATED);
        rootStage.setTitle("SuperJeu");
    }

    public Stage getStage(){
        return rootStage;
    }
}
