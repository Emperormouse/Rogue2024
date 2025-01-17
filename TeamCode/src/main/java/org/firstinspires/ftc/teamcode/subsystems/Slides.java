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

    private final int maxTicks = 1000;

    public Slides(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "slides");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }



    public void extend() {
        motor.setPower(1.0);
    }

    public void retract() { motor.setPower(-1.0);}

    public void setPower(double power) {motor.setPower(power);}

    public void stop() {
        motor.setPower(0.0);
    }

    public int getPos() { return -motor.getCurrentPosition(); }

    /**
     * @return if the error is less than 10
     */
    public boolean setPosition(int targetTicks, double speed) {
        final double p = 0.01;

        int diff = targetTicks + motor.getCurrentPosition();
        //double divisor = 1.5*Math.max(Math.abs(diff), 1);
        if (Math.abs(diff * p) > 1)
            motor.setPower(speed * (-diff)/Math.abs(diff));
        else
            motor.setPower(speed * (-diff * p));

        return Math.abs(diff) < 10;
    }



}