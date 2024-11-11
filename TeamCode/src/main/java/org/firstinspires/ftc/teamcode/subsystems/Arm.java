package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

public class Arm {

    private DcMotor arm1, arm2;


    public Arm(HardwareMap hardwareMap) {
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");

        arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
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
    private double prevTime =  Double.NaN;
    private double lastError = 0, integError = 0;
    //Limits of the arm (in ticks, I guess?)
    private double minLim = 0, maxLim = 0;

    /* KP is used for moving arm to its desired position
       KI adjusts for a unchanging variable, such as gravity
       KD adjusts for a random variable, like a bot bumping into yours
        (KD is VERY sensitive compared to the other two)
     */
    final double kP = 0, kI = 0, kD = 0;
    /**
     *
     * @param target The desired value the arm wants to match
     * @param pos The current position of the arm
     * @param time The current time (Just pass '1' into it since it's being constantly ran)
     * @return - Returns the result of the PID
     */
    public double PID(int target, int pos, int time) {
        final double error = target - pos;
        final double dt = (prevTime != Double.NaN) ?
                (double)(time - prevTime) : 0;

        //Derivative and integral error
        final double derivError = (dt != 0) ? ((error - lastError) / dt) : 0;
        integError += error * dt;

        prevTime = time;
        lastError = error;

        return checkLims((kP * error) + (kI * integError) + (kD * derivError));
    }

    /**
     *
     * @param output - The output for the PID.
     * @return - If the output is less than the minimum limit, it will return the min.
     * if greater than the maximum limit, it will return the max.
     */
    private double checkLims(final double output){
        if (!Double.isNaN(minLim) && output < minLim)
            return minLim;
        else if (!Double.isNaN(maxLim) && output > maxLim)
            return maxLim;
        else
            return output;
    }

    public void setLims(final double minLim, final double maxLim) {
        if(minLim < maxLim) {
            this.minLim = minLim;
            this.maxLim = maxLim;
        }else{
            this.minLim = maxLim;
            this.maxLim = minLim;
        }

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
