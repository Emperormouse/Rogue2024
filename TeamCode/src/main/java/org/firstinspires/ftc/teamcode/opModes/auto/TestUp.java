package org.firstinspires.ftc.teamcode.opModes.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "testUp")
public class TestUp extends LinearOpMode{
    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(true)
            if (System.currentTimeMillis() - startTime >= seconds * 1000)
                return;
    }

    public void runOpMode() throws InterruptedException {
        //Robot bot = new Robot(hardwareMap, telemetry);
        Drive drive = new Drive(hardwareMap, telemetry);

        waitForStart();

        int distance = 1000;

        while(!gamepad1.b) {
            if (gamepad1.dpad_up)
                distance+=10;
            else if (gamepad1.dpad_down)
                distance-=10;
            waitSeconds(0.25);
            telemetry.addData("Distance: ", distance);
            telemetry.update();
        }

        drive.toVector(0, distance);


        stop();
    }
}
