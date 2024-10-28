package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slides {
    private final int ticksPerRotation = 100; //placeholder
    private final double rotationsForExtension = 5.5; //placeholder
    private DcMotor motor;

    public Slides(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "slide3");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Manual below here

    public void extend() {
        motor.setPower(1.0);
    }

    public void retract() { motor.setPower(-1.0);
    }

    public void stop() {
        motor.setPower(0.0);
    }

    public int getPos() { return motor.getCurrentPosition(); }

    public class SetHeight implements Action {
        private int targetTicks;
        private final double kP = 0.01;

        public SetHeight(double fractionHeight) {
            targetTicks = (int)(fractionHeight * ticksPerRotation * rotationsForExtension);
        }

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (motor.getCurrentPosition() == targetTicks) {
                motor.setPower(0.0);
                return false;
            }

            int error = targetTicks - motor.getCurrentPosition();
            double p = error * kP;

            motor.setPower(0.3 * p);
            return true;
        }
    }

    public Action setHeight(double fraction) {
        return new SetHeight(fraction);
    }
    public Action extendAction() { return new SetHeight(1.0); }
    public Action retractAction() { return new SetHeight(0.0); }



}