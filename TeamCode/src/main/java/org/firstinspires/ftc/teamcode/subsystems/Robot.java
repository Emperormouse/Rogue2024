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
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
        }
    }

    //Sets slide's position
    public void setSlidePos(int pos, double speed) {
        slidesPos = pos;
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = slides.setPosition(slidesPos, speed);
            arm.setPosition(armPos);
        }
    }

    //Sets the arm and slide positions at the same time
    public void setRobotPosition(int armPos, int slidesPos, double slideSpeed) {
        this.armPos = armPos;
        this.slidesPos = slidesPos;
        boolean isAtArmPos = false;
        boolean isAtSlidesPos = false;

        while( !(isAtArmPos || isAtSlidesPos) ) {
            isAtArmPos = arm.setPosition(armPos);
            isAtSlidesPos = slides.setPosition(slidesPos, slideSpeed);
        }
    }

    public void setRobotPosition(int armPos, int slidesPos, double slideSpeed, int x, int y) {
        this.armPos = armPos;
        this.slidesPos = slidesPos;
        boolean isAtArmPos = false;
        boolean isAtSlidesPos = false;

        while( !(isAtArmPos || isAtSlidesPos) ) {
            isAtArmPos = arm.setPosition(armPos);
            isAtSlidesPos = slides.setPosition(slidesPos, slideSpeed);
        }
    }

    public void DriveToPos(int x, int y) {
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = drive.toVector(x, y);
            arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
        }

    }
}
