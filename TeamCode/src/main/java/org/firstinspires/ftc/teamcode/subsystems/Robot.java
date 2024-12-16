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

    private int armPos = 0;
    private int slidesPos = 0;

    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        drive = new Drive(hardwareMap, telemetry);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
    }

    public void setArmPos(int pos) {
        armPos = pos;
        boolean notDone = true;
        while(notDone) {
            notDone = arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
        }
    }


}
