package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "NewMethodsAuto")
public class Test3 extends LinearOpMode{

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

        bot.setRobotPosition(-280, 950, 0.5);

        bot.setArmPos(-340);

        bot.setSlidePos(0, 0.5);

        bot.claw.open();

        bot.waitSeconds(1);

        bot.setArmPos(-380);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -500);

        bot.setArmPos(0);

        bot.drive.toVectorOld(2400, 0);

        bot.waitSeconds(0.5);

        bot.drive.toVectorOld(0, -250);


        stop();
    }
}