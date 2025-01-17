package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "MAIN AUTO >:(")
public class MainAuto extends LinearOpMode{

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        bot.setArmPos(-750);
        while(!isStarted()) {
            bot.holdPosition();
        }

        //FIRST BLOCK
            bot.setArmPos(-410);

            bot.drive.SetBrakes(false);

            bot.drive.toVectorOld(0, 600, 1.0);

            bot.waitSeconds(0.5);
            bot.drive.toVectorOld(0, 100, 0.3);
            bot.waitSeconds(0.25);

            bot.drive.SetBrakes(true);

            bot.setArmPos(-280);

            bot.setSlidePos(650, 0.6);

            //bot.setRobotPosition(-360, 1500, 1);

            bot.setArmPos(-340);

            bot.waitSeconds(0.3);

            //Pull down block
            bot.setSlidePos(0, 0.5);
            /*
            bot.setArmPos(-390);
            bot.waitSeconds(0.2);

            bot.drive.toVectorOld(0, -60, 0.5);*/
            bot.waitSeconds(0.5);

            bot.claw.open();

            bot.waitSeconds(0.6);

        //SECOND BLOCK
            bot.setArmPos(-380);

            bot.waitSeconds(0.6);

            //Drive backwards away from bar
            bot.drive.toVectorOld(0, -500);

            bot.waitSeconds(0.6);


            //Turn 90 deg clockwise
            bot.drive.turn(230, 1.0);

            bot.waitSeconds(0.6);

            //Drive forward to sample area
            bot.drive.toVectorOld(0, 1900);

            bot.waitSeconds(0.5);

            //Turn clockwise to human player
            bot.drive.turn(285, 1.0);

                /*
            bot.drive.strafe(2800, 1.0);

            bot.waitSeconds(0.5);

            bot.drive.turn(650, 0.5);*/

            bot.waitSeconds(0.5);

            //bot.drive.toVectorOld(0, 200);

            //bot.waitSeconds(0.5);

            //Set arm in position to add block
                bot.setArmPos(-915);


            bot.waitSeconds(0.7);

            //Grab second block
                bot.setSlidePos(1500, 0.7);

                bot.waitSeconds(1.0);

                bot.claw.close();

                bot.waitSeconds(0.5);

                bot.setArmPos(-750);

                bot.setSlidePos(0, 1.0);

                bot.setArmPos(0);
            //Drive to score second sample
                bot.waitSeconds(0.5);

                //bot.drive.toVectorOld(0, -50);

                //bot.waitSeconds(0.5);

                //Turn right parallel to wall and sample hanging bars
                    bot.drive.turn(275, 1.0);

                bot.waitSeconds(0.5);

                //Drive forward to the bars
                    bot.drive.toVectorOld(0,1700);

                bot.waitSeconds(0.5);

                //Turn right to face bars
                bot.drive.turn(260, 1.0);

                bot.waitSeconds(0.5);

        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 600, 1.0);

        bot.waitSeconds(0.5);
        bot.drive.toVectorOld(0, 80, 0.5);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        bot.setArmPos(-260);

        bot.setSlidePos(650, 0.4);

        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-320);

        bot.waitSeconds(0.3);

        //Pull down block
        bot.setSlidePos(0, 0.5);
            /*
            bot.setArmPos(-390);
            bot.waitSeconds(0.2);

            bot.drive.toVectorOld(0, -60, 0.5);*/
        bot.waitSeconds(0.5);

        bot.claw.open();

        bot.waitSeconds(0.6);



            stop();
    }
}