package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "test1")
public class Test1 extends LinearOpMode{
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(true)
            if (System.currentTimeMillis() - startTime >= seconds * 1000)
                return;
    }

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        while(!isStarted()) {
            bot.arm.setPosition(1000);
        }

        bot.drive.toVector(0, 600);

        waitSeconds(1);

        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(800);
            bot.slides.setPosition(600);
        }    
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(700);
            bot.slides.setPosition(600);
        }
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(700);
            bot.slides.setPosition(0);
        }

        bot.drive.toVector(0, -500);

        while(bot.arm.setPosition(0) || bot.slides.setPosition(0));

        waitSeconds(1);

        bot.drive.toVector(2000, 0);

        stop();
    }
}
