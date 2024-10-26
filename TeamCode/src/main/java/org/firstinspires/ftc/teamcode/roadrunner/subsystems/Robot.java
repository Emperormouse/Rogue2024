package org.firstinspires.ftc.teamcode.roadrunner.subsystems;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    public MecanumDrive drive;
    public Arm arm;
    public Claw claw;
    public Slides slides;
    Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Pose2d pos, Telemetry telemetry){
        this.telemetry = telemetry;

        drive = new MecanumDrive(hardwareMap, pos);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
    }
}
