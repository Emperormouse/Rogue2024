package org.firstinspires.ftc.teamcode.opModes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "Slides")
public class TestSlides extends LinearOpMode {
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(true)
            if (System.currentTimeMillis() - startTime >= seconds * 1000)
                return;
    }
    public void runOpMode() {
        Robot bot = new Robot(hardwareMap, telemetry);

        waitForStart();

        double time = 1;
        int direction = 1;
        double speed = 0.5;

        while(!gamepad1.b) {
            if (gamepad1.dpad_up)
                time += 0.1;
            else if (gamepad1.dpad_down)
                time -= 0.1;
            else if (gamepad1.y) {
                direction *= -1;
                waitSeconds(0.5);
            }
            telemetry.addData("Time: ", time);
            telemetry.addData("Direction: ", direction);

            telemetry.update();
            waitSeconds(0.1);
        }

        bot.slides.setPower(speed * direction);
        waitSeconds(time);
        bot.slides.stop();

        while(!isStopRequested());
        stop();
    }

}
