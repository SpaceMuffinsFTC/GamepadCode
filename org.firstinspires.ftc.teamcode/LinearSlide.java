package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide extends OpMode {

    private RobotHW robot;
    public LinearSlide(RobotHW robot){ this.robot = robot;
    }

    double maxValue = 0.7;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {

        double rightTrigger2 = gamepad2.right_trigger;
        robot.lock.setPosition(rightTrigger2);

        double rightstickY2 = gamepad2.right_stick_y;
        robot.linearSlide.setPower(rightstickY2);

        if(gamepad2.right_stick_y > 0.7){
            robot.linearSlide.setPower(maxValue);

        }

    }

    public void stop(){

    }





}
