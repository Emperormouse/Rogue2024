package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private Servo wrist;

    public Wrist(HardwareMap hardwareMap) {
        wrist = hardwareMap.servo.get("wrist");
        wrist.setPosition(0.65);
    }

    public void right(double power) {
        wrist.setPosition(0.4);
    }

    public void left(double power) {
        wrist.setPosition(0.6);
    }
    public void setPosition(double pos) {
        wrist.setPosition(pos);
    }
    public void stop() {
        wrist.setPosition(0.5);
    }
}
