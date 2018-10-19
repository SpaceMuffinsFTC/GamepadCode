package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide extends OpMode {

    RobotHW robot = new RobotHW();

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

    }

    public void stop(){

    }





}
