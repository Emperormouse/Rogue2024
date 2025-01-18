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

        bot.drive.SetBrakes(false);

        //Pull down block
        bot.setSlidePos(0, 0.5);

        //Drive backwards away from bar
        bot.drive.toVectorOld(0, -550);
        bot.waitSeconds(0.3);
        bot.drive.toVectorOld(0, -200, 0.5);

        bot.claw.close();
        bot.waitSeconds(0.6);

        //Turn 90 deg clockwise
        bot.drive.turn(200, 1.0);

        bot.waitSeconds(0.6);

        bot.drive.strafe(300, 0.5);
        //Drive forward to sample area
        bot.drive.toVectorOld(0, 2000);
        bot.waitSeconds(0.3);
        bot.drive.toVectorOld(0, 200, 0.5);


        bot.drive.toVectorOld(0, -200);
        bot.waitSeconds(0.3);

        bot.drive.strafe(300, 0.5);

        bot.waitSeconds(1);
        //=====GRAB=====
        bot.setArmPos(-1300);
        bot.setSlidePos(250, 0.6);
        bot.claw.open();
        bot.setSlidePos(500, 0.6);
        bot.claw.close();
        bot.waitSeconds(0.2);
        bot.setArmPos(-200);

        bot.drive.strafe(200, 0.5);
        bot.drive.toVectorOld(0, -1800);
        bot.waitSeconds(0.5);
        bot.drive.turn(-200, 1.0);
        bot.waitSeconds(0.3);
        bot.drive.toVectorOld(0, -300, 0.4);


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

        stop();
    }
}

