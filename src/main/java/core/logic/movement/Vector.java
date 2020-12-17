package main.java.core.logic.movement;

public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector sum(Vector movement){
        return new Vector(getX() + movement.getX(), getY() + movement.getY());
    }
    public static Vector sum(Vector pos, Vector movement){
        return pos.sum(movement);
    }

    public Vector subTo(Vector pos){
        return new Vector(pos.getX() - getX(), pos.getY() - getY());
    }
    public static Vector sub(Vector vector, Vector subTo){ return vector.subTo(subTo); }

    @Override
    public String toString() {
        return "("+this.getX()+","+this.getY()+")";
    }
}
