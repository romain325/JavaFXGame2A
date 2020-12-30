package main.java.core.logic.movement;

import java.awt.*;

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
        return new Vector(-getX(),-getY());
    }

    public Vector sum(Vector movement){
        return new Vector(getX() + movement.getX(), getY() + movement.getY());
    }
    public Vector sum(int x, int y){
        return new Vector(getX() + x , getY() + y);
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

    public static boolean intersects(Vector r1_1,Vector r1_2,Vector r2_1,Vector r2_2) {
        int tw = r1_2.getX() - r1_1.getX();
        int th = r1_2.getY() - r1_1.getY();
        int rw = r2_2.getX() - r2_1.getX();
        int rh = r2_2.getY() - r2_1.getY();
        if (rw > 0 && rh > 0 && tw > 0 && th > 0) {
            int tx = r1_1.getX();
            int ty = r1_1.getY();
            int rx = r2_1.getX();
            int ry = r2_1.getY();
            rw += rx;
            rh += ry;
            tw += tx;
            th += ty;
            return (rw < rx || rw > tx) && (rh < ry || rh > ty) && (tw < tx || tw > rx) && (th < ty || th > ry);
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "("+this.getX()+","+this.getY()+")";
    }
}
