package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "tuner")
public class Tuner extends LinearOpMode {
    public void runOpMode() {
        Robot bot = new Robot(hardwareMap, telemetry);


        waitForStart();

        while(opModeIsActive()) {
            bot.drive.addDriveData();
            telemetry.addData("Arm: ", bot.arm.getPos());
            telemetry.addData("Slides: ", bot.slides.getPos());

            telemetry.update();
        }
    }
}
