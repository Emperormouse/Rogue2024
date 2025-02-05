package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Hinge;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Slides;

@TeleOp(name = "MainTele")
public class MainTeleOp extends LinearOpMode {
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < (seconds * 1000));
    }

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftFront");
        DcMotor backLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftBack");
        DcMotor frontRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightFront");
        DcMotor backRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightBack");

        /*frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        //frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);

        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //Defined in org.firstinspires.ftc.teamcode.subsystems
        Slides slides = new Slides(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap);
        Hinge hinge = new Hinge(hardwareMap);

        Robot bot = new Robot(hardwareMap, telemetry);

        /* Reverse the right side motors. This may be wrong for your setup.
        If your robot moves backwards when commanded to go forwards,
        reverse the left side instead.
        See the note about this earlier on this page.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE); */

        waitForStart();

        if (isStopRequested()) return;

        int targetArmTicks = arm.getPos();
        boolean previousXButton = false;
        int mode = 0; // 0 = normal, 1 = intake

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

            frontLeftMotor.setPower(-frontLeftPower);
            backLeftMotor.setPower(-backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            // DRIVER TWO BELOW

            if (gamepad2.dpad_left)
                mode = 0;
            else if (gamepad2.dpad_right)
                mode = 1;


            if (gamepad2.right_stick_y != 0)
                slides.setPower(gamepad2.right_stick_y);
            else
                slides.stop();


            if (mode == 1) { // INTAKE MODE
                hinge.intake();
                arm.setPosition(bot.testAngle(-1200, 3, slides.getPos()), 0.3);

                if (gamepad2.right_bumper) {
                    arm.setPower(0.3);
                    waitSeconds(0.4);
                    arm.setPower(0.0);
                    claw.close();
                    while(!slides.setPosition(300, 1.0));
                    targetArmTicks = -100;
                    mode = 0;
                } else {
                    claw.open();
                }
            } else {
                hinge.outake();
                if (gamepad2.left_stick_y != 0) {
                    arm.setPower(-gamepad2.left_stick_y);
                    targetArmTicks = arm.getPos();
                } else {
                    arm.setPosition(targetArmTicks, 0.5);
                }
            }


            if (gamepad2.a && !gamepad2.x) {
                claw.open();
            } else if (gamepad2.b) {
                claw.close();
            }

            if (gamepad2.dpad_down) {
                targetArmTicks = -810;
            }

            if (gamepad2.right_bumper && gamepad2.left_bumper) {
                slides.setPower(1.0);
                while(opModeIsActive()) {
                    if (gamepad2.a && gamepad2.x) break;
                };
            }

            if (gamepad2.right_bumper && !previousXButton) {
                claw.toggle();
            }
            previousXButton = gamepad2.right_bumper;



            telemetry.addData("slides: ", slides.getPos());
            telemetry.addData("arm: ", arm.getPos());
            telemetry.addData("Left: ", frontLeftMotor.getCurrentPosition());
            telemetry.addData("Right: ", frontRightMotor.getCurrentPosition());

            telemetry.update();


        }
    }
}