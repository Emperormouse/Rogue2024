package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "MAIN AUTO")
public class Test extends LinearOpMode{

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);
        bot.setArmPos(-750, 0.4);
        while(!isStarted()) {
            bot.holdPosition();
        }

        //FIRST BLOCK
        bot.setArmPos(-200);
        bot.waitSeconds(0.3);


        bot.drive.toVectorOld(0, 800, 1.0);

        bot.waitSeconds(0.5);
        bot.drive.SetBrakes(false);
        bot.drive.toVectorOld(0, 750, 0.6);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        bot.setSlidePos(650);

        bot.setArmPos(-360);
        bot.waitSeconds(0.3);

        bot.setSlidePos(1150, 1);

        bot.claw.open();
        bot.waitSeconds(0.3);

        bot.setSlidePos(1050, 0.7);

        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-100, 0.5);

        bot.waitSeconds(0.3);


        //Pull down block
        bot.setSlidePos(0, 0.6);
        bot.drive.SetBrakes(false);


        //Drive backwards away from bar
        bot.drive.toVectorOld(0, -450);
        bot.waitSeconds(0.3);
        //bot.drive.toVectorOld(0, -200, 0.5);

        bot.claw.close();
        bot.waitSeconds(0.4);

        //Turn 90 deg clockwise
        bot.drive.SetBrakes(true);
        bot.drive.turn(700, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.SetBrakes(false);


        bot.drive.strafe(150, 0.5);
        bot.drive.SetBrakes(true);
        //Drive forward to sample area
        //bot.drive.toVectorOld(0, 1950);
        bot.drive.toVectorOld(0, 1850);

        bot.waitSeconds(0.4);

        bot.drive.strafe(-100, 1.0);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(true);
        bot.drive.turn(750, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 850, 0.8);
        bot.waitSeconds(0.5);


        //bot.drive.toVectorOld(0, 400, 0.5);
        //bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -10, 0.5);


        //bot.drive.SetBrakes(true);
        //bot.drive.toVectorOld(0, -100);
        //bot.waitSeconds(0.5);
        //bot.drive.SetBrakes(true);

        bot.claw.open();
        //bot.setSlidePos(0, 1.0);
        bot.setArmPos(-820, 0.3);

        bot.waitSeconds(1.0);

        //Grab second block
        bot.setSlidePos(250, 0.7);
        bot.waitSeconds(0.1);
        bot.setArmPos(-845, 0.3);
        bot.waitSeconds(0.2);

        bot.claw.close();
        bot.waitSeconds(0.7);
        bot.setArmPos(-550);
        bot.setSlidePos(0, 1.0);
        bot.setArmPos(-200);
        bot.waitSeconds(0.2);

        bot.drive.toVectorOld(0, -200);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(true);
        bot.drive.turn(800, 1.0);
        bot.waitSeconds(0.3);

        //bot.drive.strafe(-200, 0.7);
        //bot.waitSeconds(0.5);
        //bot.drive.strafe(100, 1.0);


        //bot.drive.SetBrakes(false);

        //=====GRAB=====
        //bot.setArmPos(-1100);
        //bot.setSlidePos(300, 0.6);
        //bot.claw.open();
        //bot.setSlidePos(500, 0.6);
        //bot.claw.close();
        //bot.waitSeconds(0.2);
        //bot.setArmPos(-200);

        //bot.drive.strafe(-500, 0.3);
        bot.drive.SetBrakes(true);

        bot.drive.toVectorOld(0, 1750);
        bot.waitSeconds(0.2);
        bot.drive.turn(750, 1.0);
        bot.waitSeconds(0.2);
        bot.drive.SetBrakes(false);
        //bot.drive.toVectorOld(0, 300);
        //bot.waitSeconds(0.5);
        //bot.drive.toVectorOld(0, -500, 0.3);se


        bot.setArmPos(-170);
        bot.waitSeconds(0.3);


        bot.drive.toVectorOld(0, 600, 1.0);

        bot.waitSeconds(0.5);
        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 500, 0.6);
        bot.waitSeconds(0.4);


        bot.drive.SetBrakes(true);

        bot.drive.toVectorOld(0,-80);

        bot.setSlidePos(880);

        bot.waitSeconds(0.3);

        bot.setArmPos(-460, 0.2);
        bot.waitSeconds(0.5);

        bot.setSlidePos(0, 0.5);
        bot.waitSeconds(0.2);


        //bot.setSlidePos(0, 0.4);

        bot.claw.open();
        bot.waitSeconds(0.3);
        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-100);


        bot.waitSeconds(0.5);

        stop();
    }
}

