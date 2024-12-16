package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Slides;

@TeleOp(name = "TeleOpWithInit")
public class TeleOpWithInit extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftFront");
        DcMotor backLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftBack");
        DcMotor frontRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightFront");
        DcMotor backRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightBack");

        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        //Defined in org.firstinspires.ftc.teamcode.subsystems
        Slides slides = new Slides(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap);



        /* Reverse the right side motors. This may be wrong for your setup.
        If your robot moves backwards when commanded to go forwards,
        reverse the left side instead.
        See the note about this earlier on this page.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE); */

        while(!isStarted()) {
            arm.setPosition(-750);
        }

        if (isStopRequested()) return;

        int targetArmTicks = arm.getPos();
        boolean previousXButton = false;

        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x * 1.1;
            double rx = -gamepad1.right_stick_x;

            /* Denominator is the largest motor power (absolute value) or 1
            This ensures all the powers maintain the same ratio,
            but only if at least one is out of the range [-1, 1] */
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            if (gamepad2.left_stick_y != 0) {
                arm.setPower(-gamepad2.left_stick_y);
                targetArmTicks = arm.getPos();
            } else {
                arm.setPosition(targetArmTicks);
            }

            /*
            if (gamepad2.left_stick_y < 0) { //Reversed direction, may or may not be more intuitive
                arm.raise();
                targetArmTicks = arm.getPos();
            } else if (gamepad2.left_stick_y > 0) {
                arm.lower();
                targetArmTicks = arm.getPos();
            } else {
                arm.setPosition(targetArmTicks);
            }*/

            if (gamepad2.right_stick_y != 0)
                slides.setPower(gamepad2.right_stick_y);
            else
                slides.stop();

            /*
            if (gamepad2.right_stick_y > 0) {
                slides.extend();
            } else if (gamepad2.right_stick_y < 0) {
                slides.retract();
            } else {
                slides.stop();
            }*/

            if (gamepad2.a) {
                claw.open();
            } else if (gamepad2.b) {
                claw.close();
            }


            if ((gamepad2.x || gamepad2.right_bumper) && !previousXButton) {
                claw.toggle();
            }
            previousXButton = gamepad2.x;




            telemetry.addData("arm", arm.getPos());
            telemetry.addData("slides", slides.getPos());
            telemetry.update();


        }
    }
}