package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Utility.Pos2D;
import org.firstinspires.ftc.teamcode.Utility.Vector2D;
import java.lang.Math;

public class Robot {

    public Drive drive;
    public Arm arm;
    public Claw claw;
    public Slides slides;
    public Hinge hinge;
    public Wrist wrist;

    private int armPos = 0;
    private int slidesPos = 500;

    private Pos2D drivePos;

    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        drive = new Drive(hardwareMap, telemetry, this);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
        drivePos = new Pos2D(0, 0, 0);
        hinge = new Hinge(hardwareMap);
        wrist = new Wrist(hardwareMap);
        this.telemetry = telemetry;
    }

    public void setArmPos(int pos) {
        armPos = pos;
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = arm.setPosition(armPos);
            slides.stop();
        }
    }

    public void setArmPos(int pos, double speed) {
        armPos = pos;
        boolean isAtPos = false;
        while(!isAtPos) {
            isAtPos = arm.setPosition(armPos, speed);
            slides.stop();
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

    public void setRobotPosition(int armPos, double armSpeed, int slidesPos, double slideSpeed) {
        this.armPos = armPos;
        this.slidesPos = slidesPos;
        boolean isAtArmPos = false;
        boolean isAtSlidesPos = false;

        while( !(isAtArmPos && isAtSlidesPos) ) {
            isAtArmPos = arm.setPosition(armPos, armSpeed);
            isAtSlidesPos = slides.setPosition(slidesPos, slideSpeed);

            telemetry.addData("Slides: ", slides.getPos());
            telemetry.addData("Arm: ", arm.getPos());


            telemetry.update();
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
            slides.stop();
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
            slides.stop();
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
            slides.stop();
            drive.addDriveData();
            telemetry.update();
            //drive.toPosition(drivePos);
        }
    }

    public void holdPosition() {
        arm.setPosition(armPos);
        slides.stop();
        //drive.toPosition(drivePos);
    }

    public int testAngle(/*int constant, */int b, int m, double slideLength) {
        /*final double angleToTicks = constant;
        final double height = 1600;
        double angle = (90 - Math.toDegrees(Math.acos(height/slideLength))) * angleToTicks;
        return -1000 - angle;*/

        return (int)(b + (Math.sqrt(slideLength) * m));
    }
}
