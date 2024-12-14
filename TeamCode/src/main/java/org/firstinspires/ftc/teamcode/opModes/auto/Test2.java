package org.firstinspires.ftc.teamcode.opModes.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "test2")
public class Test2 extends LinearOpMode{
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(true)
            if (System.currentTimeMillis() - startTime >= seconds * 1000)
                return;
    }

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        Drive drive = new Drive(hardwareMap, telemetry);

        while(!isStarted()) {
            bot.arm.setPosition(-400);
        }

        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 3 * 1000) {
            bot.arm.setPosition(-150);
        }

        drive.toVector(0, 300);

        waitSeconds(1);

        drive.turn(-900);

        waitSeconds(0.5);

        drive.toVector(0, 250);

        waitSeconds(0.5);


        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 3 * 1000) {
            bot.arm.setPosition(-150);
            bot.slides.setPosition(2220, 0.5);
        }

        waitSeconds(1.5);

        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(-150);
            bot.slides.setPosition(0, 0.5);
        }

        waitSeconds(2);

        drive.toVector(0, -200);
        drive.turn(-860);

        stop();

        stop();
    }
}
