package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "Slides")
public class TestSlides extends LinearOpMode {
    public void runOpMode() {
        Robot bot = new Robot(hardwareMap, telemetry);

        waitForStart();

        while(opModeIsActive())
            bot.slides.setPosition(1000);
    }

}
