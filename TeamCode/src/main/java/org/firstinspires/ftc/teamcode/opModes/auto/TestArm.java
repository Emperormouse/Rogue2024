package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "TestArm")
public class TestArm extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);

        bot.setArmPos(-400);
        while(!isStarted()) {
            bot.holdPosition();
        }

        bot.setSlidePos(1700, 0.5);

        bot.setSlidePos(1200, 0.2);

        bot.waitSeconds(1.0);

        bot.setArmPos(0);

        bot.setSlidePos(0, 0.8);


    }
}
