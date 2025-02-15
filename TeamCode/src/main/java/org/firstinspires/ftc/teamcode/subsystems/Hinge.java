package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Hinge {

    private Servo hinge;
    private final double INTAKE = 0.0;
    private final double OUTAKE = 1.0;

    public Hinge(HardwareMap hardwareMap) {
        hinge = hardwareMap.servo.get("hinge");
    }

    public void intake() {
        hinge.setPosition(0.9);
    }

    public void outtake() {
        hinge.setPosition(0.0);
    }


    public void setPosition(double pos) {
        hinge.setPosition(pos);
    }


    public double getPos() {return hinge.getPosition(); }

}
