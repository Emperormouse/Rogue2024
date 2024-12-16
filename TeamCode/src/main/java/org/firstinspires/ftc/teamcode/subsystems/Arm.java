package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Arm {

    private DcMotor arm1, arm2;
    private final int maxTicks = 1000;

    public Arm(HardwareMap hardwareMap) {
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");

        arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void raise() {
        arm1.setPower(-0.5);
        arm2.setPower(0.5);
    }

    public void lower() {
        arm1.setPower(0.5);
        arm2.setPower(-0.5);
    }

    public void setPower(double power) {
        arm1.setPower(-power / 2);
        arm2.setPower(power / 2);
    }

    public void stop() {
        arm1.setPower(0.0);
        arm2.setPower(0.0);
    }

    /**
     *
     * @param targetTicks self-explanatory
     * @return returns true if the error between the arm's position and desired position is less
     * than the desired amount
     */
    public boolean setPosition(int targetTicks) {
        final double p = 0.003;

        int diff = targetTicks - arm1.getCurrentPosition();
        //double divisor = 1.5*Math.max(Math.abs(diff), 1);
        arm1.setPower(diff * p);
        arm2.setPower(-diff * p);

        return Math.abs(diff) < 10;
    }

    public int getPos() {
        return arm1.getCurrentPosition();
    }

    //Roadrunner below here

    /*
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
    */


}
