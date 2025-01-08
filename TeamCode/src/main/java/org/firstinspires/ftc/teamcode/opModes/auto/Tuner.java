package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "tuner")
public class Tuner extends LinearOpMode {
    public void runOpMode() {
        Robot bot = new Robot(hardwareMap, telemetry);

        bot.drive.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bot.drive.backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bot.drive.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bot.drive.backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        waitForStart();

        while(opModeIsActive()) {
            bot.drive.addDriveData();
            telemetry.addData("Arm: ", bot.arm.getPos());
            telemetry.addData("Slides: ", bot.slides.getPos());
            telemetry.addData("Claw: ", bot.claw.getPos());


            telemetry.update();
        }
    }
}
