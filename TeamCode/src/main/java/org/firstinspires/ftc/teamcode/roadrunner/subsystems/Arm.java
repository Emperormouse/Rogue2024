package org.firstinspires.ftc.teamcode.roadrunner.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Arm {

    private Servo arm1, arm2;
    private final double EXTENDED = 0.25;
    private final double RETRACTED = 0.0;

    public Arm(HardwareMap hardwareMap) {
        arm1 = hardwareMap.servo.get("arm1");
        arm2 = hardwareMap.servo.get("arm2");
        arm1.setPosition(RETRACTED);
        arm2.setPosition(RETRACTED);
    }

    public void extend() {
        arm1.setPosition(EXTENDED);
        arm2.setPosition(EXTENDED);
    }

    public void retract() {
        arm1.setPosition(RETRACTED);
        arm2.setPosition(RETRACTED);
    }

    //Roadrunner below here

    public class SetArmPosition implements Action {
        private long startTime;
        private long endTime;
        public SetArmPosition(double position, double duration) {
            arm1.setPosition(position);
            arm2.setPosition(position);
            startTime = System.currentTimeMillis();
            endTime = startTime + (int)(duration * 1000);
        }

        public boolean run(@NonNull TelemetryPacket packet) {
            return (System.currentTimeMillis() < endTime);
        }
    }

    public Action extendAction() {return new SetArmPosition(EXTENDED, 1.0); }
    public Action retractAction() {return new SetArmPosition(RETRACTED, 1.0); }
}
