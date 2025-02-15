package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "New Auto")
public class NewAuto extends LinearOpMode{

    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);

        waitForStart();
        bot.hinge.outtake();

        //FIRST BLOCK
        bot.claw.close();

        bot.drive.toVectorOld(0, -100, 1.0);

        bot.setArmPos(1500);

        bot.setSlidePos(420);
        bot.waitSeconds(0.5);
        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -700, 1.0);

        bot.drive.toVectorOld(0, -200, 0.5);


        bot.waitSeconds(0.5);
        bot.drive.SetBrakes(false);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        //bot.setSlidePos(650);
        bot.hinge.setPosition(0.25);

        bot.setSlidePos(1120, 0.5);

        bot.claw.open();
        bot.waitSeconds(0.3);
        bot.setSlidePos(100, 0.8);

        //bot.setSlidePos(1050, 0.7);

        bot.setArmPos(700, 0.5);

        bot.waitSeconds(0.3);


        //Pull down block

        //Drive backwards away from bar
        bot.wrist.setPosition(0.65);
        bot.drive.toVectorOld(0, 550);
        bot.waitSeconds(0.3);
        bot.claw.close();

        //Turn 90 deg clockwise
        bot.drive.SetBrakes(true);

        bot.drive.strafe(-2500, 1.0);

        bot.drive.toVectorOld(0, 850, 0.8);
        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -100, 0.8);

        bot.claw.open();
        bot.setArmPos(590, 0.3);
        bot.hinge.setPosition(0.5);
        
        //Grab second block
        bot.waitSeconds(1.0);

        bot.setSlidePos(500, 0.7);

        bot.waitSeconds(0.5);

        bot.claw.close();
        bot.waitSeconds(0.3);
        bot.hinge.outtake();
        bot.waitSeconds(0.3);
        bot.setArmPos(1200);

        bot.drive.toVectorOld(0, -200);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(true);

        bot.drive.strafe(2750, 1.0);
        bot.waitSeconds(0.2);
        bot.drive.SetBrakes(false);

        bot.setArmPos(1500);

        bot.setSlidePos(420);
        bot.waitSeconds(0.5);
        bot.hinge.outtake();
        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -500, 1.0);


        bot.waitSeconds(0.5);
        bot.drive.SetBrakes(false);

        bot.drive.SetBrakes(true);

        //bot.setSlidePos(650);
        bot.hinge.setPosition(0.2);

        bot.setSlidePos(1150, 0.5);

        bot.claw.open();
        bot.waitSeconds(0.3);
        bot.setSlidePos(250);

        //bot.setSlidePos(1050, 0.7);

        bot.setArmPos(700, 0.5);

        bot.waitSeconds(0.3);


        //Pull down block
        bot.setSlidePos(50, 0.6);

        stop();
    }
}

