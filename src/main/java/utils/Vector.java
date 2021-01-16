package main.java.utils;

import java.io.Serializable;

public class Vector implements Serializable {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter
     * @return value
     */
    public int getX() {
        return x;
    }

    /**
     * Setter
     * @param x newValue
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter
     * @return value
     */
    public int getY() {
        return y;
    }

    /**
     * Setter
     * @param y new Value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * return the invert vector of our current vector
     * @return inverted vector
     */
    public Vector invert() {
        return new Vector(-getX(),-getY());
    }

    /**
     * return the sum of instance + mov
     * @param movement vector to add
     * @return sum of both
     */
    public Vector sum(Vector movement){
        return new Vector(getX() + movement.getX(), getY() + movement.getY());
    }

    /**
     * return the sum of instance + x/y
     * @param x x to add
     * @param y y to add
     * @return result of it
     */
    public Vector sum(int x, int y){
        return new Vector(getX() + x , getY() + y);
    }

    /**
     * Sum two given vector
     * @param pos vec1
     * @param movement vec2
     * @return sum of both
     */
    public static Vector sum(Vector pos, Vector movement){
        return pos.sum(movement);
    }

    /**
     * substract vec to given vector
     * @param pos vector that get substracted
     * @return sub of vectors
     */
    public Vector subTo(Vector pos){
        return new Vector(pos.getX() - getX(), pos.getY() - getY());
    }

    /**
     * Substract the given vector to our isntance
     * @param pos the vector to substract
     * @return result
     */
    public Vector sub(Vector pos){
        return new Vector(getX() - pos.getX(), getY() - pos.getY());
    }

    /**
     * Substract two vector
     * @param vector substract this
     * @param subTo to this one
     * @return result
     */
    public static Vector sub(Vector vector, Vector subTo){ return vector.subTo(subTo); }

    /**
     * Copy a vector to current vector
     * @param vector vector to copy
     */
    public void copy(Vector vector){
        this.setX(vector.getX());
        this.setY(vector.getY());
    }

    /**
     * Copy the current vector to another one
     * @param vector vector that recieve data
     */
    public void copyTo(Vector vector){
        vector.setX(this.getX());
        vector.setY(this.getY());
    }

    /**
     * Is the vector in a space defined by two vectors
     * @param minVector min of the space
     * @param maxVector max of the space
     * @return is in the defined space
     */
    public boolean isIn(Vector minVector, Vector maxVector){
        return (
                this.getX() < minVector.getX() ||
                this.getX() > maxVector.getX() ||
                this.getY() < minVector.getY() ||
                this.getY() > maxVector.getY()
                );
    }

    /**
     * Si the vector in a space defined by the max vector
     * @param maxVector max
     * @return is the vector between 0.0 and max
     */
    public boolean isIn(Vector maxVector){
        return this.isIn(new Vector(0,0), maxVector);
    }

    /**
     * Is the vector in a space defiend by a min/max taking count of the w/h
     * @param minVector min
     * @param maxVector max
     * @param width width
     * @param height height
     * @return is in the defined space
     */
    public boolean isIn(Vector minVector, Vector maxVector, int width, int height){
        return (
                this.getX() < minVector.getX() ||
                this.getX() + width > maxVector.getX() ||
                this.getY() < minVector.getY() ||
                this.getY() + height > maxVector.getY()
        );
    }
    /**
     * Is the vector in a space defiend by a max taking count of the w/h
     * @param maxVector max
     * @param width width
     * @param height height
     * @return is in the defined space
     */
    public boolean isIn(Vector maxVector, int width, int height){
        return this.isIn(new Vector(0,0), maxVector, width, height);
    }

    /**
     * Does to space intersects
     * @param r1_1 min of space 1
     * @param r1_2 max of space 1
     * @param r2_1 min of space 2
     * @param r2_2 max of space 2
     * @return are the soaces intersecting
     */
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
