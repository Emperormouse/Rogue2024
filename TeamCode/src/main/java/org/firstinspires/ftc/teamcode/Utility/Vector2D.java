package org.firstinspires.ftc.teamcode.Utility;

public class Vector2D<T> {
    private T x, y;

    public Vector2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    //Accessors
    public T getX() {
        return x;
    }
    public T getY() {
        return y;
    }

    //Mutators
    public void setX(T x) {
        this.x = x;
    }
    public void setY(T y) {
        this.y = y;
    }
    public void set(T x, T y) {
        this.x = x;
        this.y = y;
    }
}


