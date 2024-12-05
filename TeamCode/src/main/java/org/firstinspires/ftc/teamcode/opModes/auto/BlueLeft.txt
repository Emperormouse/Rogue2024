package org.firstinspires.ftc.teamcode.opModes.auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "BlueLeft")
public class BlueLeft extends LinearOpMode {
    private static final Pose2d startPose = new Pose2d(55, -60, Math.toRadians(90));
    @Override
    public void runOpMode() {
        Pose2d startPose = new Pose2d(-55, 60, Math.toRadians(0));
        Robot bot = new Robot(hardwareMap, startPose);

        Actions.runBlocking(new SequentialAction(
                bot.drive.actionBuilder(startPose)
                        .strafeTo(new Vector2d(11, -35))
                        .strafeTo(new Vector2d(9, -60))
                        .strafeTo(new Vector2d(61, -62))
                        .build()
                )
        );
    }
}

