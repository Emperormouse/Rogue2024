package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;

public class Robot {

    public Drive drive;
    public Arm arm;
    public Claw claw;
    public Slides slides;
    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        drive = new Drive(hardwareMap, telemetry);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
    }

    public Action grab() {
        return new SequentialAction(
                arm.lowerAction(),
                claw.closeAction(),
                new ParallelAction(
                        arm.raiseAction(),
                        slides.extendAction()
                )
        );
    }
}
