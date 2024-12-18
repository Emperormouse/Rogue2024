package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "NewMethodsAuto")
public class TestNewMethods extends LinearOpMode{

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        bot.setArmPos(-750);
        while(!isStarted()) {
            bot.holdPosition();
        }

        bot.setArmPos(-400);

        bot.drive.toVectorOld(0, 900);

        bot.waitSeconds(1);

        bot.setRobotPosition(-280, 1000, 0.5);

        bot.setArmPos(-360);

        bot.setSlidePos(0, 0.5);

        bot.claw.open();

        bot.waitSeconds(0.6);

        bot.setArmPos(-380);



        bot.waitSeconds(0.6);

        bot.drive.toVectorOld(0, -400);

        bot.setArmPos(0);

        bot.waitSeconds(0.6);

        bot.drive.turn(200, 0.5);

        bot.waitSeconds(0.6);

        bot.drive.toVectorOld(0, 1200);

        bot.waitSeconds(0.5);

        bot.drive.turn(200, 0.5);

        bot.waitSeconds(0.2);

        bot.setRobotPosition(-890,1900,0.5);

        bot.waitSeconds(0.4);

        bot.claw.close();

        bot.waitSeconds(0.5);

        bot.setArmPos(-750);

        bot.setSlidePos(0,0.8);

        bot.waitSeconds(0.5);

        bot.drive.turn(350, 0.5);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0,1200);

        bot.waitSeconds(0.5);

        bot.drive.turn(350, 0.5);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0,500);

        stop();
    }
}