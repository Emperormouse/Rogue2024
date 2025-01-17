package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Claw {

    private Servo claw;
    private Servo hinge;
    private final double CLOSED = 0.6;
    private final double OPEN = 0.4;

    private final double STRAIGHT = 0.2;
    private final double ANGLED = 1.0;


    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.servo.get("claw");
        hinge = hardwareMap.servo.get("hinge");
        hinge.setPosition(ANGLED);
        claw.setPosition(CLOSED);
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

    public void rotStraight() {hinge.setPosition(STRAIGHT);}
    public void rotAngled() {hinge.setPosition(ANGLED);}
    public void rotSet(double rot) {hinge.setPosition(rot);}

    public void toggle() {
        if (claw.getPosition() == CLOSED)
            claw.setPosition(OPEN);
        else
            claw.setPosition(CLOSED);
    }

    public double getPos() {return claw.getPosition(); }

}
