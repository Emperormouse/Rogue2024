package org.firstinspires.ftc.teamcode.Utility;

public class Vector2D {
    private int x, y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    //Accessors
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //Mutators
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2D other) {
        this.x += other.getX();
        this.y += other.getY();
    }
}


