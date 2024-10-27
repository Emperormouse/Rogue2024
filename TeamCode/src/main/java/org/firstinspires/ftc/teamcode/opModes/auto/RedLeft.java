package org.firstinspires.ftc.teamcode.opModes.auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.roadrunner.subsystems.Robot;

//This op mode uses the claw and slides but they haven't been tuned yet. Use one of the other ones
// to test trajectory
@Autonomous(name = "RedLeft")
public class RedLeft extends LinearOpMode {
    @Override
    public void runOpMode() {
        Pose2d startPose = new Pose2d(-40, -60, Math.toRadians(180));
        Robot bot = new Robot(hardwareMap, startPose);

        Actions.runBlocking(new SequentialAction(
                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-55, -55), Math.toRadians(-135)).build(),

                bot.claw.openAction(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-48, -45), Math.toRadians(90)).build(),

                bot.grab(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-55, -55), Math.toRadians(-135)).build(),

                bot.claw.openAction(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-58, -45), Math.toRadians(90)).build(),

                bot.grab(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-55, -55), Math.toRadians(-135)).build(),

                bot.claw.openAction(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-50, -26), Math.toRadians(180)).build(),

                bot.grab(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-55, -55), Math.toRadians(-135)).build(),

                bot.claw.openAction(),

                bot.drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(-40, -60), Math.toRadians(90)).build()

                )
        );
    }
}
