package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.RobotHW;

public class RobotUpDown {

    private RobotHW robot;
    public RobotUpDown(RobotHW robot){
        this.robot = robot;
    }

    public void robotDown() {
        robot.lock.setPosition(0.5);
        robot.linearSlide.setPower(-0.1);
    }

    public void robotUp() {
        robot.linearSlide.setPower(0.6);
        robot.lock.setPosition(1);
    }

}
