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
        hinge.setPosition(OUTAKE);
    }

    public void outake() {
        hinge.setPosition(OUTAKE);
    }


    public double getPos() {return hinge.getPosition(); }

}
