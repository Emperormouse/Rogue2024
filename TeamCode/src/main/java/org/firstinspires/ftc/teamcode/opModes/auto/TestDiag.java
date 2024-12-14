package org.firstinspires.ftc.teamcode.opModes.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "testDiag")
public class TestDiag extends LinearOpMode{
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

        int distanceX = 1000;
        int distanceY = 1000;

        while(!gamepad1.b) {
            if (gamepad1.dpad_right)
                distanceX+=5;
            else if (gamepad1.dpad_left)
                distanceX-=5;
            else if (gamepad1.x)
                distanceX *= -1;
            else if (gamepad1.dpad_up)
                distanceY+=5;
            else if (gamepad1.dpad_down)
                distanceY-=5;
            else if (gamepad1.y)
                distanceY *= -1;

            telemetry.addData("DistanceX: ", distanceX);
            telemetry.addData("DistanceY: ", distanceY);
            telemetry.update();
            waitSeconds(0.1);
            /*while(gamepad1.dpad_up || gamepad1.dpad_down || gamepad1.dpad_left ||
                    gamepad1.dpad_right || gamepad1.x || gamepad1.y ); //wait until they stop pressing a button*/
        }
        telemetry.addLine("X is configured");
        telemetry.update();

        drive.toVector(distanceX, distanceY);

        stop();
    }
}