package main.java.core.visual;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.java.core.logic.movement.Vector;
import main.java.view.renderer.Rendable;
import main.java.view.renderer.ZIndex;

public abstract class Visuel implements IVisuel, Rendable {
    private final int Height;
    private final int Width;
    private final Vector position;
    private ZIndex renderType;
    private boolean isVisible = true;

    public Visuel(int x, int y, int h, int w, ZIndex renderType){
        this.Height = h;
        this.Width  = w;
        this.position = new Vector(x,y);
        this.renderType = renderType;
    }

    @Override
    public int getHeight() {
        return Height;
    }

    @Override
    public int getWidth() {
        return Width;
    }

    public int getCoordX() {
        return position.getX();
    }

    public void setCoordX(int coordX) {
        position.setX(coordX);
    }

    public int getCoordY() {
        return position.getY();
    }

    public void setCoordY(int coordY) {
        position.setY(coordY);
    }

    public boolean hasCollision() {
        return renderType.hasCollision();
    }

    public int getZindex(){
        return this.renderType.getIndex();
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector pos){
        position.copy(pos);
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void debugVision(GraphicsContext context){
        context.strokeRect(this.getCoordX(),this.getCoordY(),this.getWidth(), this.getHeight());
    }
}
