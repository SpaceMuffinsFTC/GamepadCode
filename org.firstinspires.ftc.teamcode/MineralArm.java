package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.RobotHW;

public class MineralArm extends OpMode {

    private RobotHW robotTmp;
    public MineralArm(RobotHW robot){ this.robotTmp = robot;
    }

    @Override
    public void init(){
        //   robotTmp.init(hardwareMap);
    }

    @Override
    public void loop(){

        double leftStickY2 = gamepad2.left_stick_y;
        // robotTmp.armChain.setPower(leftStickY2);
    }
}
