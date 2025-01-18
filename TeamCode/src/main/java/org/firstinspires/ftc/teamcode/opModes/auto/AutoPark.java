package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "Auto PARK")
public class AutoPark extends LinearOpMode {

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        bot.setArmPos(-750);
        while(!isStarted()) {
            bot.holdPosition();
        }

        //FIRST BLOCK
        bot.setArmPos(-200);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 600, 1.0);

        bot.waitSeconds(0.5);
        bot.drive.toVectorOld(0, 250, 0.3);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        bot.setSlidePos(450);

        bot.setArmPos(-325);
        bot.waitSeconds(0.3);

        bot.setSlidePos(1000, 0.4);

        bot.claw.open();
        bot.waitSeconds(0.3);
        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-100);

        bot.waitSeconds(0.3);

        //Pull down block
        bot.setSlidePos(0, 0.5);

        //Drive backwards away from bar
        bot.drive.toVectorOld(0, -550);

        bot.waitSeconds(0.6);


        //Turn 90 deg clockwise
        bot.drive.turn(230, 1.0);

        bot.waitSeconds(0.6);

        //Drive forward to sample area
        bot.drive.toVectorOld(0, 2000);

        bot.waitSeconds(0.5);


        //Turn clockwise to human player


        bot.drive.turn(280, 1.0);

        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 200, 1.0);

        stop();
        /*
        bot.drive.toVectorOld(0, 300, 0.5);
        bot.waitSeconds(0.3);

        bot.drive.SetBrakes(true);
        bot.waitSeconds(0.3);
        bot.drive.toVectorOld(0, -150);




        //bot.drive.toVectorOld(0,100);


            bot.drive.strafe(2800, 1.0);

            bot.waitSeconds(0.5);

            bot.drive.turn(650, 0.5);

        bot.waitSeconds(0.5);

        //bot.drive.toVectorOld(0, 200);

        //bot.waitSeconds(0.5);

        //Set arm in position to add block
        bot.setArmPos(-860);


        bot.waitSeconds(0.7);

        //Grab second block
        bot.setSlidePos(630, 0.7);

        bot.waitSeconds(1.0);

        bot.claw.close();

        bot.waitSeconds(0.5);

        bot.setArmPos(-750);

        bot.setSlidePos(0, 1.0);

        bot.setArmPos(-200);
        //Drive to score second sample
        bot.waitSeconds(0.5);

        //bot.drive.toVectorOld(0, -50);

        //bot.waitSeconds(0.5);

        //Turn right parallel to wall and sample hanging bars
        bot.drive.turn(300, 1.0);

        bot.waitSeconds(0.5);

        //Drive forward to the bars
        bot.drive.toVectorOld(0,1900);

        bot.waitSeconds(0.5);

        //Turn right to face bars
        bot.drive.turn(280, 1.0);

        bot.waitSeconds(0.5);



        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 400, 1.0);

        bot.waitSeconds(0.5);
        bot.drive.toVectorOld(0, 250, 0.5);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        //bot.setArmPos(-200);


        bot.setSlidePos(800, 0.6);

        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-280);

        bot.waitSeconds(0.3);

        //Pull down block
        bot.setSlidePos(0, 0.5);

            bot.setArmPos(-390);
            bot.waitSeconds(0.2);

            bot.drive.toVectorOld(0, -60, 0.5);
        bot.waitSeconds(0.5);

        bot.claw.open();

        bot.waitSeconds(0.6);



*/
        stop();
    }
    }

