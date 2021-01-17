package main.java.core.visual;

import javafx.scene.canvas.GraphicsContext;
import main.java.utils.Vector;

public abstract class Visual implements IVisual {
    private final int height;
    private final int width;
    private final Vector position;
    private ZIndex renderType;
    private boolean isVisible = true;

    public Visual(int x, int y, int h, int w, ZIndex renderType){
        this.height = h;
        this.width = w;
        this.position = new Vector(x,y);
        this.renderType = renderType;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    /**
     * get x coordianate
     * @return x coord
     */
    public int getCoordX() {
        return position.getX();
    }

    /**
     * set X coordinate
     * @param coordX new X coord
     */
    public void setCoordX(int coordX) {
        position.setX(coordX);
    }

    /**
     * get y coord
     * @return y coord
     */
    public int getCoordY() {
        return position.getY();
    }

    /**
     * set y coord
     * @param coordY new y coord
     */
    public void setCoordY(int coordY) {
        position.setY(coordY);
    }

    /**
     * has collision
     * @return has collison
     */
    public boolean hasCollision() {
        return renderType.hasCollision();
    }

    /**
     * get zindex
     * @return zindex
     */
    public int getZindex(){
        return this.renderType.getIndex();
    }

    /**
     * get position
     * @return position vector
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * set pposition
     * @param pos new pos vector
     */
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

    /**
     * debug mode render
     * @param context graphic ccontext
     */
    public void debugVision(GraphicsContext context){
        context.strokeRect(this.getCoordX(),this.getCoordY(),this.getWidth(), this.getHeight());
    }
}
