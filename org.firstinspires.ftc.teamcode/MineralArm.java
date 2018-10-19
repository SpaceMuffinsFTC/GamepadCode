package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class MineralArm extends OpMode {

    RobotHW robot = new RobotHW();

    @Override
    public void init(){
        robot.init(hardwareMap);
    }

    @Override
    public void loop(){

        float leftStickY2 = gamepad2.left_stick_y;
        robot.armChain.setPower(leftStickY2);
    }
}
