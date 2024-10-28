package org.firstinspires.ftc.teamcode.opModes.auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

@Autonomous(name = "BlueRight")
public class BlueRight extends LinearOpMode {
    @Override
    public void runOpMode() {
        Pose2d startPose = new Pose2d(40, 60, Math.toRadians(0));
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);

        double timeToDropBlock = 0.5;
        double timeToRotateArm = 1.5;
        double timeToGrabBlock = 0.5;

        Actions.runBlocking(new SequentialAction(
                drive.actionBuilder(startPose)
                        .strafeToLinearHeading(new Vector2d(55, 55), Math.toRadians(45))
                        //open claw
                        .waitSeconds(timeToDropBlock)

                        .strafeToLinearHeading(new Vector2d(48, 45), Math.toRadians(-90))
                        //extend arm
                        .waitSeconds(timeToRotateArm)
                        //close claw
                        .waitSeconds(timeToGrabBlock)
                        //retract arm
                        .waitSeconds(timeToRotateArm)

                        .strafeToLinearHeading(new Vector2d(55, 55), Math.toRadians(45))
                        //open claw
                        .waitSeconds(timeToDropBlock)

                        .strafeToLinearHeading(new Vector2d(58, 45), Math.toRadians(-90))
                        //extend arm
                        .waitSeconds(timeToRotateArm)
                        //close claw
                        .waitSeconds(timeToGrabBlock)
                        //retract arm
                        .waitSeconds(timeToRotateArm)

                        .strafeToLinearHeading(new Vector2d(55, 55), Math.toRadians(45))
                        //open claw
                        .waitSeconds(timeToDropBlock)

                        .strafeToLinearHeading(new Vector2d(50, 26), Math.toRadians(0))
                        //extend arm
                        .waitSeconds(timeToRotateArm)
                        //close claw
                        .waitSeconds(timeToGrabBlock)
                        //retract arm
                        .waitSeconds(timeToRotateArm)

                        .strafeToLinearHeading(new Vector2d(55, 55), Math.toRadians(45))
                        //open claw
                        .waitSeconds(timeToDropBlock)


                        .strafeToLinearHeading(new Vector2d(40, 60), Math.toRadians(-90))
                        //extend arm
                        .waitSeconds(timeToRotateArm)

                        .build()
                )
        );
    }
}

