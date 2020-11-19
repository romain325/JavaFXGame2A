package main.java.Visual;

public abstract class Visuel {
    private int CoordX;
    private int CoordY;
    private int Height;
    private int Width;

    public Visuel(int x, int y, int h, int w){
        this.CoordX = x;
        this.CoordY = y;
        this.Height = h;
        this.Width  = w;
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
}
