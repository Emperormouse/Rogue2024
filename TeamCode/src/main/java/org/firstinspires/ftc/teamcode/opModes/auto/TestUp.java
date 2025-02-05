package org.firstinspires.ftc.teamcode.opModes.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "testAngle")
public class TestUp extends LinearOpMode{
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(true)
            if (System.currentTimeMillis() - startTime >= seconds * 1000)
                return;
    }

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);

        waitForStart();

        //bot.setSlidePos(500);

        int b = -1100;
        int x = 20;

        while(!gamepad1.b) {
            /*if (gamepad1.y) {
                distance += 25;
            }
            else if (gamepad1.a) {
                distance -= 25;
            }*/
            if (gamepad1.dpad_up) {
                b += 20;
            }
            else if (gamepad1.dpad_down) {
                b -= 20;
            }
            else if (gamepad1.dpad_right) {
                x += 1;
            }
            else if (gamepad1.dpad_left) {
                x -= 1;
            }
            if (gamepad1.right_stick_y != 0)
                bot.slides.setPower(gamepad1.right_stick_y);
            else
                bot.slides.stop();

            //bot.slides.setPosition(distance, 0.5);

            telemetry.addData("b: ", b);
            telemetry.addData("x: ", x);
            //Equation: b + (slideLength / m);

            telemetry.update();
            waitSeconds(0.1);
        }
        bot.slides.stop();


        while(!isStopRequested()) {
            if (gamepad1.right_stick_y != 0)
                bot.slides.setPower(gamepad1.right_stick_y);
            else
                bot.slides.stop();

            if (gamepad2.a) {
                bot.claw.open();
            } else if (gamepad2.b) {
                bot.claw.close();
            }

            bot.arm.setPosition(bot.testAngle(b, x, bot.slides.getPos()), 0.6);

            telemetry.addData("b: ", b);
            telemetry.addData("x: ", x);
            telemetry.addData("Slide Length: ", bot.slides.getPos());
            telemetry.addData("Arm: ", bot.arm.getPos());
            telemetry.addData("Calculated Arm Ticks: ", bot.testAngle(b, x, bot.slides.getPos()));

            telemetry.update();
        }

        stop();
    }
}
