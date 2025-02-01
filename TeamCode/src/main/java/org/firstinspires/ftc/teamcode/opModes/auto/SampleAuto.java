package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "Sample Auto")
public class SampleAuto extends LinearOpMode {

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        bot.setArmPos(-750);
        while (!isStarted()) {
            bot.holdPosition();
        }
        bot.claw.close();
        bot.setArmPos(-50);

        bot.drive.toVectorOld(0,700);

        bot.drive.toVectorOld(0, 450, 0.5);

        bot.waitSeconds(0.4);

        bot.drive.turn(-20,1);


        bot.drive.toVectorOld(0,100,0.5);
        bot.setSlidePos(2300,1);


        bot.setArmPos(-150);

        bot.waitSeconds(1d);

        bot.claw.open();

        bot.waitSeconds(1);

        stop();
        /*
        bot.setArmPos(-50);

        bot.setSlidePos(0); */
    }
}