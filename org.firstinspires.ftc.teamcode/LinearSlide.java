package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotHW;

public class LinearSlide extends OpMode {

    private RobotHW robotTmp;
    public LinearSlide(RobotHW robot){ this.robotTmp = robot;
    }

    double maxValue = 0.7;

    @Override
    public void init() {
        //robot.init(hardwareMap);
    }

    @Override
    public void loop() {

        double rightTrigger2 = gamepad2.right_trigger;
        robotTmp.lock.setPosition(rightTrigger2);

        double leftTrigger2 = gamepad2.left_trigger;
        robotTmp.lock.setPosition(leftTrigger2);

        double rightstickY2 = gamepad2.right_stick_y;
        robotTmp.linearSlide.setPower(rightstickY2);

        if(gamepad2.right_stick_y > 0.7){
            robotTmp.linearSlide.setPower(maxValue);

        }

    }

    public void stop(){

    }





}
