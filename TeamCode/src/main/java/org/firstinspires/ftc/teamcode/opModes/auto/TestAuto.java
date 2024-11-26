package org.firstinspires.ftc.teamcode.opModes.auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@Autonomous(name = "testAuto")
public class TestAuto extends LinearOpMode {
    public void runOpMode() {
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));
        Robot bot = new Robot(hardwareMap, startPose);

        Actions.runBlocking(new SequentialAction(
                bot.drive.actionBuilder(startPose)
                        .turn(Math.toRadians(90))
                        .build())
        );
        /*
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setTargetPosition(100);
        leftBack.setTargetPosition(100);
        rightBack.setTargetPosition(100);
        rightFront.setTargetPosition(100);

         */



    }
}
