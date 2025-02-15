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
import org.firstinspires.ftc.teamcode.subsystems.Wrist;

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
        Wrist wrist = new Wrist(hardwareMap);

        /* Reverse the right side motors. This may be wrong for your setup.
        If your robot moves backwards when commanded to go forwards,
        reverse the left side instead.
        See the note about this earlier on this page.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE); */

        waitForStart();

        if (isStopRequested()) return;

        int targetArmTicks = 1000;
        boolean previousXButton = false;
        int mode = 0;
        int direction = 1; // direction of movement for drivetrain

        wrist.setPosition(0.65);

        while (opModeIsActive()) {
            double y = direction * gamepad1.left_stick_y;
            double x = -direction * gamepad1.left_stick_x * 1.1;
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
            frontRightMotor.setPower(-frontRightPower);
            backRightMotor.setPower(backRightPower);

            if (gamepad1.dpad_up) {
                direction = 1;
            } else if (gamepad1.dpad_down) {
                direction = -1;
            }

            // DRIVER TWO BELOW


            if (gamepad2.dpad_down) {
                mode = 1; // sample intake
                hinge.intake();
                targetArmTicks = 440;
            } else if (gamepad2.dpad_left) {
                mode = 2; // specimen intake
                claw.open();
                hinge.setPosition(0.4);
                targetArmTicks = 465;
            } else if (gamepad2.dpad_up) {
                hinge.intake();
                targetArmTicks = 1250;
                mode = 4; // Basket Outtake
            } else if (gamepad2.dpad_right) {
                mode = 5; // specimen outtake
                hinge.outtake();
            } else if (gamepad2.a) {
                mode = 3;
            }

            if (mode != 3) {
                if (gamepad2.right_stick_y != 0)
                    slides.setPower(gamepad2.right_stick_y);
                else
                    slides.stop();
            }



            switch (mode) {
                case 1: // Sample Intake
                    //arm.setPosition(bot.testAngle(-1000, 3, slides.getPos()), 0.3);
                    /*if (gamepad2.left_stick_y != 0) {
                        mode = 0;
                    }*/
                    if (gamepad2.x || gamepad2.right_bumper) {
                        claw.close();
                        waitSeconds(0.3);
                        while(!slides.setPosition(10, 1.0));
                        targetArmTicks = 1300;

                        mode = 3;
                    }
                    break;
                case 2: // Specimen Intake
                    /*hinge.setPosition(0.5);
                    targetArmTicks = -900;*/
                    if (gamepad2.x || gamepad2.right_bumper) {
                        claw.close();
                        waitSeconds(0.3);
                        hinge.outtake();
                        waitSeconds(0.3);
                        targetArmTicks = 1390;
                        mode = 3;
                    }
                    break;
                case 3: // Ready
                    slides.setPosition(0, 0.8);

                    if (gamepad2.right_stick_y != 1) {
                        mode = 5;
                    }
                    /*if (slides.getPos() < 400) {
                        targetArmTicks = -30;
                    }*/
                    break;
                case 4: // Sample Outtake
                    if (gamepad2.x || gamepad2.right_bumper) {
                        hinge.outtake();
                    }
                    if (gamepad2.a) {
                        claw.open();
                        waitSeconds(0.3);
                        hinge.intake();
                        waitSeconds(0.2);
                        mode = 3;
                    }
                    break;
                case 5: // Specimen Outtake
                    if (gamepad2.x || gamepad2.right_bumper) {
                        hinge.setPosition(0.3);
                        waitSeconds(0.3);
                        arm.setPower(0.1);
                        while(!slides.setPosition(650, 0.7));
                        arm.setPower(0);
                        waitSeconds(0.2);
                        claw.open();
                        while(!slides.setPosition(0, 1));
                        waitSeconds(0.2);

                        hinge.intake();
                        mode = 3;
                    }
                    break;

                default:
            }

            if (gamepad2.left_stick_y != 0) {
                arm.setPower(-(gamepad2.left_stick_y/3));
                targetArmTicks = arm.getPos();
            } else {
                if (targetArmTicks > 1390) targetArmTicks = 1390;
                arm.setPosition(targetArmTicks, 0.4);
            }

            /*if (gamepad2.right_trigger != 0) {
                wrist.right(gamepad2.right_trigger);
            } else if (gamepad2.left_trigger != 0) {
                wrist.left(gamepad2.left_trigger);
            } else {
                wrist.stop();
            }*/

            if (gamepad2.a && !gamepad2.x) {
                claw.open();
            } else if (gamepad2.b) {
                claw.close();
            }

            /*if (gamepad2.dpad_down) {
                hinge.setPosition(1.0);
            } else if (gamepad2.dpad_up) {
                hinge.setPosition(0.0);
            } else if (gamepad2.dpad_left) {
                hinge.setPosition(0.5);
            }*/

            if (gamepad2.right_bumper && gamepad2.left_bumper) {
                slides.setPower(1.0);
                while(opModeIsActive()) {
                    if (gamepad2.a && gamepad2.x) break;
                }
            }



            telemetry.addData("slides: ", slides.getPos());
            telemetry.addData("arm: ", arm.getPos());
            telemetry.addData("Left: ", frontLeftMotor.getCurrentPosition());
            telemetry.addData("Right: ", frontRightMotor.getCurrentPosition());

            telemetry.update();


        }
    }
}