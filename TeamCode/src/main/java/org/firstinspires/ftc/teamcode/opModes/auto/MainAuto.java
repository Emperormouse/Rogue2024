package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "NewMethodsAuto")
public class MainAuto extends LinearOpMode{

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        bot.setArmPos(-750);
        while(!isStarted()) {
            bot.holdPosition();
        }

        //FIRST BLOCK
            bot.setArmPos(-400);

            bot.drive.toVectorOld(0, 900);

            bot.waitSeconds(1);

            bot.setRobotPosition(-370, 1600, 0.5);

            bot.setArmPos(-460);

            //Pull down block
            bot.setSlidePos(250, 0.5);

            bot.claw.open();

            bot.waitSeconds(0.6);

        //SECOND BLOCK
            bot.setArmPos(-380);

            bot.waitSeconds(0.6);

            //Drive backwards away from bar
                bot.drive.toVectorOld(0, -200);

            bot.setArmPos(0);

            bot.waitSeconds(0.6);

            //Turn 90 deg clockwise
                bot.drive.turn(220, 0.5);

            bot.waitSeconds(0.6);

            //Drive forward to sample area
                bot.drive.toVectorOld(0, 1800);

            bot.waitSeconds(0.5);

            //Turn clockwise to human player
                bot.drive.turn(240, 0.5);

            bot.waitSeconds(0.5);

            //Set arm in position to add block
                bot.setArmPos(-930);

            bot.waitSeconds(0.7);

            //Grab second block
                bot.setSlidePos(2000, 0.5);

                bot.waitSeconds(1.0);

                bot.claw.close();

                bot.waitSeconds(0.5);

                bot.setArmPos(-750);

                bot.setSlidePos(0, 0.6);

                bot.setArmPos(0);
            //Drive to score second sample
                bot.waitSeconds(0.5);

                bot.drive.toVectorOld(0, -50);

                bot.waitSeconds(0.5);

                //Turn right parallel to wall and sample hanging bars
                    bot.drive.turn(220, 0.5);

                bot.waitSeconds(0.5);

                //Drive forward to the bars
                    bot.drive.toVectorOld(0,1800);

                bot.waitSeconds(0.5);

                //Turn right to face bars
                    bot.drive.turn(250, 0.5);

                bot.waitSeconds(0.5);

                //Drive up to bars
                    bot.drive.toVectorOld(0,750);

                bot.waitSeconds(0.5);

                //DELETE ( back up after running into bars
                    bot.drive.toVectorOld(0, -100);

                bot.waitSeconds(1);

                //Raise arm up to bar
                    bot.setRobotPosition(-370, 1800, 0.5);

                //Hang sample
                    bot.setArmPos(-440);

                    bot.setSlidePos(150, 0.5);

                    bot.claw.open();

            bot.waitSeconds(0.6);

            bot.setArmPos(-380);

            bot.waitSeconds(0.6);

            //PARKING
                bot.drive.toVectorOld(0, -200);

            stop();
    }
}