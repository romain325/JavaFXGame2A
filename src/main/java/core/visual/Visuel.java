package main.java.core.visual;

import main.java.core.logic.movement.Vector;
import main.java.view.renderer.ZIndex;

public abstract class Visuel implements IVisuel{
    private final int Height;
    private final int Width;
    private final Vector position;
    private ZIndex renderType;

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

}
