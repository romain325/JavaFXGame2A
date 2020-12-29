package main.java.view.renderer;

import javafx.scene.canvas.GraphicsContext;

public interface Rendable extends Comparable<Rendable> {
    boolean isVisible();
    void setVisible(boolean isVisible);
    int getZindex();
    int getHeight();
    int getWidth();
    void render(GraphicsContext context);

    @Override
    default int compareTo(Rendable rendable){
        return - Integer.compare(this.getZindex(), rendable.getZindex());
    }
}
