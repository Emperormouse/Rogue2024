package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "AutoTimed")
public class AutoTimed extends LinearOpMode{
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
            bot.arm.setPosition(-700);
        }

        bot.drive.toVector(0, 900);


        waitSeconds(1);

        long startTime = System.currentTimeMillis();
        bot.slides.setPower(0.3);
        while(System.currentTimeMillis() - startTime < 2.5 * 1000) { //Time 1
            bot.arm.setPosition(-220);
        }
        bot.slides.stop();
        /*startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) {
            bot.arm.setPosition(1000);
            bot.slides.setPosition(700, 0.5);
        }*/
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 1 * 1000) {
            bot.arm.setPosition(-260);
        }
        bot.slides.setPower(-0.3);
        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 2 * 1000) { //Time 2
            bot.arm.setPosition(-260);
        }
        bot.slides.stop();
        bot.claw.open();
        waitSeconds(1);

        bot.drive.toVector(0, -500);

        bot.claw.close();

        startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 1 * 1000) {
            bot.arm.setPosition(-380);
        }

        waitSeconds(1);

        bot.drive.toVector(2400, 0);

        waitSeconds(1);

        bot.drive.toVector(0, -250);


        stop();
    }
}