package org.firstinspires.ftc.teamcode.Utility;

public class Vector3D extends Vector2D {
    private int x;
    private int y;
    private int z;

    public Vector3D(int x, int y, int z) {
        super(x, y);
        this.z = z;

    }

    //Accessors
    public int getZ() {
        return z;
    }

    //Mutators
    public void setZ(int z) {
        this.z = z;
    }
    public void set(int x, int y, int z) {
        super.set(x,y);
        this.z = z;

    }
}
