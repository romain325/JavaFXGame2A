package main.java.utils.effect;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class VisualEffect {
    /**
     * Show elements of a pane progressively given a timespan
     * @param pane given pane
     * @param time timespan between apparition
     */
    public static void showElementProgressively(Pane pane, int time) {
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

    /**
     * Show elements of a pane progressively
     * @param pane given pane
     */
    public static void showElementProgressively(Pane pane) {
        showElementProgressively(pane, 500);
    }

    /**
     * Hide a pane with all hid children
     * @param pane given pane
     */
    public static void hidePane(Pane pane){
        pane.setVisible(false);
        for (var node: pane.getChildren()) {
            node.setVisible(false);
        }
    }
}
