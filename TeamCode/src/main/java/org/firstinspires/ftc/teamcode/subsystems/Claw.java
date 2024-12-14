package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Claw {

    private Servo claw;
    private final double CLOSED = 0.6;
    private final double OPEN = 0.4;
    private final double START = -1.0;


    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.servo.get("claw");
        claw.setPosition(CLOSED);
    }

    //Manual below here

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

    //Roadrunner below here

    public class SetClawPosition implements Action {
        private long endTime;
        public SetClawPosition(double position, double duration) {
            claw.setPosition(position);
            long startTime = System.currentTimeMillis();
            endTime = startTime + (int)(duration * 1000);
        }

        public boolean run(@NonNull TelemetryPacket packet) {
            return (System.currentTimeMillis() < endTime);
        }
    }

    public Action closeAction() {return new SetClawPosition(CLOSED, 0.3); }
    public Action openAction() {return new SetClawPosition(OPEN, 0.3); }

}
