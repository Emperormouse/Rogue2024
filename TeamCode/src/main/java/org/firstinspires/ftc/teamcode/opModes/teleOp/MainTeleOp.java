package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor frontLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftFront");
        DcMotor backLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftBack");
        DcMotor frontRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightBack");
        DcMotor backRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightFront");
        DcMotor slidemotor1 = (DcMotorEx) hardwareMap.dcMotor.get("slide1");
        DcMotor slidemotor2 = (DcMotorEx) hardwareMap.dcMotor.get("slide2");
        DcMotor slidemotor3 = (DcMotorEx) hardwareMap.dcMotor.get("slide3");

        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        //frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            slidemotor1.setPower(0);
            slidemotor2.setPower(0);

            if (gamepad1.a) {

                slidemotor1.setPower(1);
                slidemotor2.setPower(1);
            }
            if (gamepad1.b) {

                slidemotor1.setPower(-1);
                slidemotor2.setPower(-1);

            }
            slidemotor3.setPower(0);
            if (gamepad1.y ){

                slidemotor3.setPower(1);
            }
            if (gamepad1.x ){
                slidemotor3.setPower(-1);
            }

        }}}