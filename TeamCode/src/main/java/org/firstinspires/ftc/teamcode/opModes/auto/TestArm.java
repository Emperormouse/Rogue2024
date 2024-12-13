package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "Arm")
public class TestArm extends LinearOpMode {
    public void runOpMode() {
        Robot bot = new Robot(hardwareMap, telemetry);

        while(!isStarted()) {
            bot.arm.setPosition(300);
        }

        while(opModeIsActive()) {
            telemetry.addData("arm: ", bot.arm.setPosition(800));
            telemetry.addData("slides: ", bot.slides.setPosition(500, 1.0));
            telemetry.update();
        }
    }
}
