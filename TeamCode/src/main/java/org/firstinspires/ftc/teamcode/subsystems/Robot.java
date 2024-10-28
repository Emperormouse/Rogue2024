package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    public MecanumDrive drive;
    public Arm arm;
    public Claw claw;
    public Slides slides;
    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Pose2d pos){
        drive = new MecanumDrive(hardwareMap, pos);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
        telemetry.addLine("Auto mode started"); //test of telementary feature
    }

    public Action grab() {
        return new SequentialAction(
                new ParallelAction(
                        arm.lowerAction(),
                        slides.retractAction()
                ),

                claw.closeAction(),

                new ParallelAction(
                        arm.raiseAction(),
                        slides.extendAction()
                )
        );
    }
}
