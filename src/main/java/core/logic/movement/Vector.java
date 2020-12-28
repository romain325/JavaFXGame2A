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

    public Vector invert() {
        return new Vector(-this.getX(), -this.getY());
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

    public void copy(Vector vector){
        this.setX(vector.getX());
        this.setY(vector.getY());
    }
    public void copyTo(Vector vector){
        vector.setX(this.getX());
        vector.setY(this.getY());
    }

    public boolean isIn(Vector minVector, Vector maxVector){
        return (
                this.getX() < minVector.getX() ||
                this.getX() > maxVector.getX() ||
                this.getY() < minVector.getY() ||
                this.getY() > maxVector.getY()
                );
    }
    public boolean isIn(Vector maxVector){
        return this.isIn(new Vector(0,0), maxVector);
    }

    public boolean isIn(Vector minVector, Vector maxVector, int width, int height){
        return (
                this.getX() < minVector.getX() ||
                this.getX() + width > maxVector.getX() ||
                this.getY() < minVector.getY() ||
                this.getY() + height > maxVector.getY()
        );
    }
    public boolean isIn(Vector maxVector, int width, int height){
        return this.isIn(new Vector(0,0), maxVector, width, height);
    }




    @Override
    public String toString() {
        return "("+this.getX()+","+this.getY()+")";
    }
}
