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

        bot.drive.toVectorOld(0, 1100);

        bot.waitSeconds(1);

        bot.drive.toVectorOld(0, -100);

        bot.waitSeconds(1);

        bot.setRobotPosition(-370, 1800, 0.5);

        bot.setArmPos(-440);

        bot.setSlidePos(150, 0.5);

        bot.claw.open();

        bot.waitSeconds(0.6);

        bot.setArmPos(-380);

        bot.waitSeconds(0.6);

        bot.drive.toVectorOld(0, -200);

        bot.setArmPos(0);

        bot.waitSeconds(0.6);

        bot.drive.turn(220, 0.5);

        bot.waitSeconds(0.6);

        bot.drive.toVectorOld(0, 1800);

        bot.waitSeconds(0.5);

        bot.drive.turn(240, 0.5);

        bot.waitSeconds(0.5);

        bot.setArmPos(-930);

        bot.waitSeconds(0.7);

        bot.setSlidePos(2000, 0.5);

        bot.waitSeconds(1.0);

        bot.claw.close();

        bot.waitSeconds(0.5);

        bot.setArmPos(-750);

        bot.setSlidePos(0, 0.6);

        bot.setArmPos(0);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -50);

        bot.waitSeconds(0.5);

        bot.drive.turn(220, 0.5);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0,1800);

        bot.waitSeconds(0.5);

        bot.drive.turn(250, 0.5);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0,750);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -100);

        bot.waitSeconds(1);

        bot.setRobotPosition(-370, 1800, 0.5);

        bot.setArmPos(-440);

        bot.setSlidePos(150, 0.5);

        bot.claw.open();

        bot.waitSeconds(0.6);

        bot.setArmPos(-380);

        bot.waitSeconds(0.6);

        bot.drive.toVectorOld(0, -200);

        stop();
    }
}