package org.firstinspires.ftc.teamcode.Utility;

public class Vector3D<T> extends Vector2D<T> {
    private T x;
    private T y;
    private T z;

    public Vector3D(T x, T y, T z) {
        super(x, y);
        this.z = z;

    }

    //Accessors
    public T getZ() {
        return z;
    }

    //Mutators
    public void setZ(T z) {
        this.z = z;
    }
    public void set(T x, T y, T z) {
        super.set(x,y);
        this.z = z;

    }
}
