package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class MineralArm extends OpMode {

    private RobotHW robot;
    public MineralArm(RobotHW robot){ this.robot = robot;
    }

    @Override
    public void init(){
        robot.init(hardwareMap);
    }

    @Override
    public void loop(){

        double leftStickY2 = gamepad2.left_stick_y;
        robot.armChain.setPower(leftStickY2);
    }
}
