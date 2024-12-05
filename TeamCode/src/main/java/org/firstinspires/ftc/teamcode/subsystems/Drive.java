package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;

    final double mod = 2.0;
    Telemetry telemetry;

    public Drive(HardwareMap hardwareMap, Telemetry telementary) {
        this.telemetry = telementary;

        frontLeft = (DcMotorEx) hardwareMap.dcMotor.get("leftFront");
        backLeft = (DcMotorEx) hardwareMap.dcMotor.get("leftBack");
        frontRight = (DcMotorEx) hardwareMap.dcMotor.get("rightFront");
        backRight = (DcMotorEx) hardwareMap.dcMotor.get("rightBack");

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void frontLeftPower(double power) {
        frontLeft.setPower((power == 0) ? 0 : Math.max(power, 0.3));
    }
    private void backLeftPower(double power) {
        backLeft.setPower((power == 0) ? 0 : Math.max(power, 0.3) * 1.2);
    }
    private void frontRightPower(double power) {
        frontRight.setPower((power == 0) ? 0 : -Math.max(power, 0.3));
    }
    private void backRightPower(double power) {
        backRight.setPower((power == 0) ? 0 : Math.max(power, 0.3) * 1.2);
    }

    public void toVector(int targetX, int targetY) {
        int currentX = (backRight.getCurrentPosition() - frontRight.getCurrentPosition() - backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4;
        int currentY = (backRight.getCurrentPosition() + frontRight.getCurrentPosition() + backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4;
        int startX = currentX;
        int startY = currentY;
        int distanceTraveledX = 0;
        int distanceTraveledY = 0;
        while(Math.abs(distanceTraveledX) < Math.abs(targetX) || Math.abs(distanceTraveledY) < Math.abs(targetY)) {
            currentX = (backRight.getCurrentPosition() - frontRight.getCurrentPosition() - backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4;
            currentY = (backRight.getCurrentPosition() + frontRight.getCurrentPosition() + backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4;

            distanceTraveledX = currentX - startX;
            distanceTraveledY = currentY - startY;


            double errorX = (targetX - currentX) * .005;
            double errorY = (targetY - currentY) * .005;


            /*
            double errorX = targetX;
            double errorY = targetY;

             */

            double denominator = Math.max(1, 1.25 * (Math.abs(errorX) + Math.abs(errorY)));
            frontLeftPower((errorY + errorX)/denominator);
            backLeftPower((errorY - errorX)/denominator);
            frontRightPower((errorY - errorX)/denominator);
            backRightPower((errorY + errorX)/denominator);

            addDriveData();
            telemetry.update();
        }
        frontLeftPower(0);
        backLeftPower(0);
        frontRightPower(0);
        backRightPower(0);
    }

    public void addDriveData() {
        telemetry.addData("Front Left: ", frontLeft.getCurrentPosition());
        telemetry.addData("Back Left: ", backLeft.getCurrentPosition());
        telemetry.addData("Front Right: ", frontRight.getCurrentPosition());
        telemetry.addData("Back Right: ", backRight.getCurrentPosition());
        telemetry.addData("Average Left: ", (backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/2);
        telemetry.addData("Average Right: ", (backRight.getCurrentPosition() + frontRight.getCurrentPosition())/2);
        telemetry.addData("Average Foreword: ", (backRight.getCurrentPosition() + frontRight.getCurrentPosition() + backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4);
        telemetry.addData("Average Sideways: ", (backRight.getCurrentPosition() - frontRight.getCurrentPosition() - backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4);
    }
}
