package main.java.Core.Visual;

import main.java.View.Renderer.ZIndex;

public abstract class Visuel implements IVisuel{
    private int CoordX;
    private int CoordY;
    private final int Height;
    private final int Width;
    private ZIndex renderType;

    public Visuel(int x, int y, int h, int w, ZIndex renderType){
        this.CoordX = x;
        this.CoordY = y;
        this.Height = h;
        this.Width  = w;
        this.renderType = renderType;
    }

    public int getCoordX() {
        return CoordX;
    }

    public void setCoordX(int coordX) {
        CoordX = coordX;
    }

    public int getCoordY() {
        return CoordY;
    }

    public void setCoordY(int coordY) {
        CoordY = coordY;
    }

    public boolean hasCollision() {
        return renderType.hasCollision();
    }

    public int getZindex(){
        return this.renderType.getIndex();
    }
}
