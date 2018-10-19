package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class RobotUpDown {

    RobotHW robot = new RobotHW();

    public void robotDown(){ robot.linearSlide.setPower(-0.2);}

    public void robotUp(){
        robot.linearSlide.setPower(0.6);
    }

}
