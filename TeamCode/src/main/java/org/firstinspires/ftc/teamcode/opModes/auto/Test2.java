package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "MainAuto-Near-Basket")
public class Test2 extends LinearOpMode{
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
            bot.arm.setPosition(-750);
        }
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 1.5 * 1000) {
            bot.arm.setPosition(-400);
        }

        waitSeconds(10);

        bot.drive.toVectorOld(700, 0);

        waitSeconds(1);

        bot.drive.toVectorOld(0, 1200 );


        waitSeconds(1);

        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 3 * 1000) {
            bot.arm.setPosition(-220);
            bot.slides.setPosition(1150, 0.5);
        }
        /*startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(1000);
            bot.slides.setPosition(700, 0.5);
        }*/
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 1 * 1000) {
            bot.arm.setPosition(-280);
            bot.slides.setPosition(1150, 0.5);
        }
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(-280);
            bot.slides.setPosition(200, 0.5);
        }
        bot.claw.open();
        waitSeconds(1);
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(-380);
            bot.slides.setPosition(0, 0.5);
        }

        waitSeconds(0.5);

        bot.drive.toVectorOld(0, -500);

        while(bot.arm.setPosition(0) || bot.slides.setPosition(0, 0.5));

        waitSeconds(0.5);

        bot.drive.toVectorOld(2400, 0);

        waitSeconds(1);

        bot.drive.toVectorOld(0, -250);


        stop();
    }
}