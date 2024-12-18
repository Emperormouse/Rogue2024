package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Utility.Vector2D;

public class Drive {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;
    private Robot botReference;

    final double mod = 2.0;
    Telemetry telemetry;

    public Drive(HardwareMap hardwareMap, Telemetry telementary, Robot botReference) {
        this.telemetry = telementary;
        this.botReference = botReference;

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

        
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        
         


        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void frontLeftPower(double power) {
        frontLeft.setPower(power);
    }
    private void backLeftPower(double power) {
        backLeft.setPower(power);
    }
    private void frontRightPower(double power) {
        frontRight.setPower(-power);
    }
    private void backRightPower(double power) {
        backRight.setPower(power);
    }

    public void toVectorOld(int targetX, int targetY) {
        int currentX = (frontLeft.getCurrentPosition()/* - frontRight.getCurrentPosition())/2*/);
        int currentY = (frontLeft.getCurrentPosition()/* + frontRight.getCurrentPosition())/2*/);
        int startX = currentX;
        int startY = currentY;
        int distanceTraveledX = 0;
        int distanceTraveledY = 0;
        while(Math.abs(distanceTraveledX) < Math.abs(targetX) || Math.abs(distanceTraveledY) < Math.abs(targetY)) {
            currentX = frontLeft.getCurrentPosition()/* - frontRight.getCurrentPosition())/2*/;
            currentY = frontLeft.getCurrentPosition()/* + frontRight.getCurrentPosition())/2*/;

            distanceTraveledX = currentX - startX;
            distanceTraveledY = currentY - startY;


            double errorX = (targetX - currentX) * .005; //PID - disabled
            double errorY = (targetY - currentY) * .005;

            errorX = targetX;
            errorY = targetY;

            double denominator = Math.max(1, (Math.abs(errorX) + Math.abs(errorY)));
            frontLeftPower((errorY + errorX)/denominator);
            backLeftPower((errorY - errorX)/denominator);
            frontRightPower((errorY - errorX)/denominator);
            backRightPower((errorY + errorX)/denominator);

            botReference.holdPosition();
            addDriveData();
            telemetry.update();
        }
        frontLeftPower(0);
        backLeftPower(0);
        frontRightPower(0);
        backRightPower(0);
    }
    public boolean toVector(Vector2D vector) {
        int currentX = (frontLeft.getCurrentPosition() - frontRight.getCurrentPosition())/2;
        int currentY = (frontLeft.getCurrentPosition() + frontRight.getCurrentPosition())/2;

        int errorX = vector.getX() - currentX;
        int errorY = vector.getY() - currentY;

        double powerX = (errorX * 0.005);
        double powerY = (errorY * 0.005);

        double denominator = Math.max(1, (Math.abs(powerX) + Math.abs(powerY)));
        frontLeftPower((errorY + errorX)/denominator);
        backLeftPower((errorY - errorX)/denominator);
        frontRightPower((errorY - errorX)/denominator);
        backRightPower((errorY + errorX)/denominator);

        return (errorX < 10 && errorY < 10);
    }

    /**
     *
     * @param targetTicks - self explanatory
     * @param speed - double ranging from 0 to 1
     */
    public void turn(int targetTicks, double speed) {
        int currentTicks = (frontLeft.getCurrentPosition() - frontRight.getCurrentPosition())/2;
        int startTicks = currentTicks;
        int distanceTraveled = 0;
        while(Math.abs(distanceTraveled) < Math.abs(targetTicks)) {
            currentTicks = (frontLeft.getCurrentPosition() - frontRight.getCurrentPosition())/2;

            distanceTraveled = currentTicks - startTicks;

            double error = (targetTicks - currentTicks) * .005; //PID - disabled

            error = targetTicks;

            double denominator = Math.max(1, 1.25 * (Math.abs(error)));
            frontLeftPower(error/denominator * speed);
            backLeftPower(error/denominator * speed);
            frontRightPower(-error/denominator * speed);
            backRightPower(-error/denominator * speed);

            addDriveData();
            telemetry.update();
        }
        frontLeftPower(0);
        backLeftPower(0);
        frontRightPower(0);
        backRightPower(0);
    }

    public void addDriveData() {
        /*
        telemetry.addData("Front Left: ", frontLeft.getCurrentPosition());
        telemetry.addData("Back Left: ", backLeft.getCurrentPosition());
        telemetry.addData("Front Right: ", frontRight.getCurrentPosition());
        telemetry.addData("Back Right: ", backRight.getCurrentPosition());
        telemetry.addData("Average Left: ", (backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/2);
        telemetry.addData("Average Right: ", (backRight.getCurrentPosition() + frontRight.getCurrentPosition())/2);
        telemetry.addData("Average Foreword: ", (backRight.getCurrentPosition() + frontRight.getCurrentPosition() + backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4);
        telemetry.addData("Average Sideways: ", (backRight.getCurrentPosition() - frontRight.getCurrentPosition() - backLeft.getCurrentPosition() + frontLeft.getCurrentPosition())/4);
        */
    }

}
