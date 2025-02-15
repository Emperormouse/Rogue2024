package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Claw {

    private Servo claw;
    private final double CLOSED = 0.7;
    private final double OPEN = 0.0;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.servo.get("claw");
    }

    public void close() {
        claw.setPosition(CLOSED);
    }

    public void open() {
        claw.setPosition(OPEN);
    }
    public void stop() {
        claw.setPosition(0.5);
    }

    public void toggle() {
        if (claw.getPosition() == CLOSED)
            claw.setPosition(OPEN);
        else
            claw.setPosition(CLOSED);
    }

    public double getPos() {return claw.getPosition(); }

}
