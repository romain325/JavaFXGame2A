package main.java.view.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.java.core.personnage.Joueur;
import main.java.core.personnage.JoueurDTO;
import main.java.utils.effect.VisualEffect;
import main.java.utils.serialization.SerializationManager;
import main.java.view.Navigator;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GameOver implements Controller {
    @FXML
    private VBox rootText;

    private Navigator navigator;
    private Joueur joueur;
    private List<String> text = new LinkedList<>();

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.joueur = new Joueur(SerializationManager.<JoueurDTO>deserializeObject("player.obj"));
        loadSave( joueur.getAdvancement().hasSuspicion() ? "win" : "loose");

        for (var mess : text){
            rootText.getChildren().add(new Label(mess));
        }
        Button end = new Button("Farewell Narrator");
        end.setOnAction(actionEvent -> {
            Platform.exit();
        });
        rootText.getChildren().add(end);

        VisualEffect.hidePane(rootText);

        VisualEffect.showTextProgressively(rootText, 1000);

        new File("player.obj").delete();
    }

    private void loadSave(String source){
        try {
            Scanner scanner = new Scanner(getClass().getResourceAsStream("/dialog/gameOver/" + source + ".txt"));
            while (scanner.hasNextLine()){
                this.text.add(scanner.nextLine()
                                .replace("{{name}}", joueur.getNom())
                                .replace("{{dead}}", String.valueOf(joueur.getAdvancement().getDayElapsed()))
                );
            }
        }catch (Exception e){
            this.text.add("Error Opening file");
        }
    }
}
