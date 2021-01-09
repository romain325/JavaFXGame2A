package main.java.utils.effect;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class VisualEffect {
    public static void showTextProgressively(Pane pane) {
        if(pane.isVisible()) return;
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        pane.setVisible(true);
        int it = 0;
        for (var node : pane.getChildren()) {
            it++;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(500*it),
                            new KeyValue(node.visibleProperty(), true)
                    ));
        }
        timeline.play();
    }

    public static void hidePane(Pane pane){
        pane.setVisible(false);
        for (var node: pane.getChildren()) {
            node.setVisible(false);
        }
    }
}
