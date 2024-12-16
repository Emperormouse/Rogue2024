package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Utility.Vector2D;
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

    /**
     * @param drivePos Vector that holds the x and y of the drive position. Use: new Vector2D(x,y) to set a drive position
     */
    public void setRobotPosition(int armPos, int slidesPos, double slideSpeed, Vector2D drivePos) {
        this.armPos = armPos;
        this.slidesPos = slidesPos;
        boolean isAtArmPos = false;
        boolean isAtSlidesPos = false;
        boolean isAtDrivePos = false;
        while( !(isAtArmPos || isAtSlidesPos || isAtDrivePos) ) {
            isAtArmPos = arm.setPosition(armPos);
            isAtSlidesPos = slides.setPosition(slidesPos, slideSpeed);
            isAtDrivePos = drive.toVector(drivePos.getX(), drivePos.getY());

        }

    }

    public void DriveToPos(Vector2D drivePos) {
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = drive.toVector(drivePos.getX(), drivePos.getY());
            arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
        }

    }

}
