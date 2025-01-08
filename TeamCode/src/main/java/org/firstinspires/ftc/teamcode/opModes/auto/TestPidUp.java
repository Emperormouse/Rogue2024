package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Utility.Pos2D;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "testPidUp")
public class TestPidUp extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot bot = new Robot(hardwareMap, telemetry);
        //Drive drive = new Drive(hardwareMap, telemetry);

        waitForStart();

        bot.driveToPos(new Pos2D(0, 2000, 0));
        bot.waitSeconds(1.0);

        bot.driveToPos(new Pos2D(0, -2000, 0));

        bot.waitSeconds(1.0);

        bot.driveToPos(new Pos2D(0, 1000, 0));

        bot.waitSeconds(1.0);

        bot.turnTo(2000);
        bot.waitSeconds(1.0);
        bot.turnTo(0);
        bot.waitSeconds(1.0);

        stop();
    }
}
