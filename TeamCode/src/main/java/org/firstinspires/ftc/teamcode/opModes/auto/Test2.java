package org.firstinspires.ftc.teamcode.opModes.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "test2")
public class Test2 extends LinearOpMode{
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

        drive.toVector(0, 600);

        waitSeconds(2);

        drive.toVector(0, -500);

        waitSeconds(0.5);

        drive.toVector(2400, 0);

        stop();

        stop();
    }
}
