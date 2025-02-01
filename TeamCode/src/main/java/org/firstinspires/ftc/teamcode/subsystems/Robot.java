package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Utility.Pos2D;
import org.firstinspires.ftc.teamcode.Utility.Vector2D;

public class Robot {

    public Drive drive;
    public Arm arm;
    public Claw claw;
    public Slides slides;

    private int armPos = 0;
    private int slidesPos = 0;

    private Pos2D drivePos;

    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        drive = new Drive(hardwareMap, telemetry, this);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
        drivePos = new Pos2D(0, 0, 0);
        this.telemetry = telemetry;
    }

    public void setArmPos(int pos) {
        armPos = pos;
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
        }
    }

    public void setArmPos(int pos, double speed) {
        armPos = pos;
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = arm.setPosition(armPos, speed);
            slides.setPosition(slidesPos, 0.5);
        }
    }

    //Set's slide's position (0.5 default speed)
    public void setSlidePos(int pos) {
        slidesPos = pos;
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = slides.setPosition(slidesPos, 0.5);
            arm.setPosition(armPos);
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

        while( !(isAtArmPos && isAtSlidesPos) ) {
            isAtArmPos = arm.setPosition(armPos);
            isAtSlidesPos = slides.setPosition(slidesPos, slideSpeed);
        }
    }

    /**
     * @param diffPos Vector that holds the x and y of the drive position. Use: new Vector2D(x,y) to set a drive position
     */
    //won't work until we get more encoders
    public void setRobotPosition(int armPos, int slidesPos, double slideSpeed, Pos2D diffPos) {
        this.armPos = armPos;
        this.slidesPos = slidesPos;
        this.drivePos = drivePos.add(diffPos);
        boolean isAtArmPos = false;
        boolean isAtSlidesPos = false;
        boolean isAtDrivePos = false;
        while( !(isAtArmPos && isAtSlidesPos && isAtDrivePos) ) {
            isAtArmPos = arm.setPosition(armPos);
            isAtSlidesPos = slides.setPosition(slidesPos, slideSpeed);
            //isAtDrivePos = drive.toPosition(drivePos); //won't work until we get more encoders

        }

    }

    public void driveToPos(Pos2D diffPos) {
        drivePos = drivePos.add(diffPos);
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = drive.toPosition(drivePos);
            arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
            /*
            drive.addDriveData();
            telemetry.update();*/
        }
        drive.turnOff();
    }

    public void turnTo(int ticks) {
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = drive.turnTo(ticks);
            arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
            /*
            drive.addDriveData();
            telemetry.update();*/
        }
        drive.turnOff();
    }

    public void waitSeconds(double seconds) {
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < (seconds * 1000)) {
            arm.setPosition(armPos);
            slides.setPosition(slidesPos, 0.5);
            drive.addDriveData();
            telemetry.update();
            //drive.toPosition(drivePos);
        }
    }

    public void holdPosition() {
        arm.setPosition(armPos);
        slides.setPosition(slidesPos, 0.5);
        //drive.toPosition(drivePos);
    }


}
