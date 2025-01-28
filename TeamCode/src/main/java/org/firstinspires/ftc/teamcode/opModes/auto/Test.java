package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "TEST AUTO")
public class Test extends LinearOpMode{

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
        bot.drive.toVectorOld(0, 400, 0.6);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        bot.setSlidePos(600);

        bot.setArmPos(-325);
        bot.waitSeconds(0.3);

        bot.setSlidePos(1050, 0.7);

        bot.claw.open();
        bot.waitSeconds(0.3);

        bot.setSlidePos(900, 0.7);

        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-100);

        bot.waitSeconds(0.3);

        bot.drive.SetBrakes(false);

        //Pull down block
        bot.setSlidePos(0, 0.5);

        //Drive backwards away from bar
        bot.drive.toVectorOld(0, -450);
        bot.waitSeconds(0.3);
        //bot.drive.toVectorOld(0, -200, 0.5);

        bot.claw.close();
        bot.waitSeconds(0.6);

        //Turn 90 deg clockwise
        bot.drive.SetBrakes(true);
        bot.drive.turn(700, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.SetBrakes(false);


        bot.drive.strafe(150, 0.5);
        bot.drive.SetBrakes(true);
        //Drive forward to sample area
        bot.drive.toVectorOld(0, 2000);
        bot.waitSeconds(0.5);

        bot.drive.strafe(-100, 1.0);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(true);
        bot.drive.turn(720, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 600, 0.4);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(true);
        bot.drive.toVectorOld(0, -100);
        bot.waitSeconds(0.5);
        bot.drive.SetBrakes(true);

        bot.setArmPos(-860);
        bot.claw.open();

        bot.waitSeconds(2.0);

        //Grab second block
        bot.setSlidePos(350, 0.7);
        bot.waitSeconds(1.0);
        bot.claw.close();
        bot.waitSeconds(0.5);
        bot.setArmPos(-700);
        bot.setSlidePos(0, 1.0);
        bot.setArmPos(-200);
        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -50);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(true);
        bot.drive.turn(700, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.SetBrakes(false);

        //=====GRAB=====
        /*bot.setArmPos(-1100);
        bot.setSlidePos(300, 0.6);
        bot.claw.open();
        bot.setSlidePos(500, 0.6);
        bot.claw.close();
        bot.waitSeconds(0.2);
        bot.setArmPos(-200);*/

        bot.drive.strafe(-500, 0.3);
        bot.drive.toVectorOld(0, 1400);
        bot.waitSeconds(0.5);
        bot.drive.SetBrakes(true);
        bot.drive.turn(700, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.SetBrakes(false);
        bot.drive.toVectorOld(0, -150, 0.3);


        bot.setArmPos(-200);
        bot.waitSeconds(0.5);

        bot.drive.SetBrakes(false);

        bot.drive.toVectorOld(0, 600, 1.0);

        bot.waitSeconds(0.5);
        bot.drive.toVectorOld(0, 400, 0.5);
        bot.waitSeconds(0.25);

        bot.drive.SetBrakes(true);

        bot.setSlidePos(480);

        bot.setArmPos(-300);
        bot.waitSeconds(0.3);

        bot.setSlidePos(0, 0.4);

        bot.claw.open();
        bot.waitSeconds(0.3);
        //bot.setRobotPosition(-360, 1500, 1);

        bot.setArmPos(-100);

        stop();
    }
}

