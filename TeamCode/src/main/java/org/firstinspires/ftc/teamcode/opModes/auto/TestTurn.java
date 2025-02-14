package org.firstinspires.ftc.teamcode.opModes.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "testTurn")
public class TestTurn extends LinearOpMode{
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(true)
            if (System.currentTimeMillis() - startTime >= seconds * 1000)
                return;
    }

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        int holdTime = 0;
        waitForStart();

        int distance = 1000;

        while(!gamepad1.b) {
            if (gamepad1.dpad_up) {
                distance += ((holdTime > 20 && distance % 50 == 0) ? 50 : 5);
                holdTime++;
            } else if (gamepad1.dpad_down) {
                distance -= ((holdTime > 20 && distance % 50 == 0) ? 50 : 5);
                holdTime++;
            } else if (gamepad1.y) {
                holdTime = 0;
                distance *= -1;
            }
            else holdTime = 0;
            telemetry.addData("Distance: ", distance);
            telemetry.update();
            waitSeconds(0.1);
            //while(gamepad1.dpad_up || gamepad1.dpad_down || gamepad1.y); //wait until they stop pressing a button
        }

        bot.drive.turn(distance, 1);

        bot.waitSeconds(1.0);

        stop();
    }
}
