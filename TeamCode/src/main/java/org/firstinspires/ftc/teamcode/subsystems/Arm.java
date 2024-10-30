package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Arm {

    private DcMotor arm1, arm2;

    public Arm(HardwareMap hardwareMap) {
        DcMotor arm1 = hardwareMap.dcMotor.get("arm1");
        DcMotor arm2 = hardwareMap.dcMotor.get("arm2");
    }

    public void raise() {
        arm1.setPower(1.0);
        arm1.setPower(-1.0);

    }

    public void lower() {
        arm1.setPower(-1.0);
        arm1.setPower(1.0);
    }

    public void stop() {
        arm1.setPower(0.0);
        arm2.setPower(0.0);
    }

    public void setPosition(int targetTicks) {
        final double p = 0.01;
        int diff = targetTicks - arm1.getCurrentPosition();
        arm1.setPower(diff * p);
        arm2.setPower(-1 * diff * p);
    }

    public int getPos() {
        return arm1.getCurrentPosition();
    }

    //Roadrunner below here

    public class Raise implements Action {
        private final int targetTicks = 1000;
        private final double kP = 0.01;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (arm1.getCurrentPosition() == targetTicks) {
                arm1.setPower(0.0);
                arm2.setPower(0.0);
                return false;
            }

            int error = targetTicks - arm1.getCurrentPosition();
            double p = error * kP;

            arm1.setPower(0.8 * p);
            arm1.setPower(0.8 * p);
            return true;
        }
    }

    public class Lower implements Action {
        private final int targetTicks = 100;
        private final double kP = 0.01;


        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (arm1.getCurrentPosition() == targetTicks) {
                arm1.setPower(0.0);
                arm2.setPower(0.0);
                return false;
            }

            int error = targetTicks - arm1.getCurrentPosition();
            double p = error * kP;

            arm1.setPower(0.8 * p);
            arm2.setPower(0.8 * p);
            return true;
        }
    }

    public Action raiseAction() {return new Raise(); }
    public Action lowerAction() {return new Lower(); }


}
