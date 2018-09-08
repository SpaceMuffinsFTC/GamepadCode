package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.widget.Toast;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
public class MacenumWheelsTrigger extends OpMode {

    RobotHW robot = new RobotHW();

    int maxvalue = 1;

    float MacenumPowerLeft = gamepad1.left_trigger;
    float MacenumPowerRight = gamepad1.right_trigger;

    
    public void init() {
        robot.init(hardwareMap);


    }

    public void start() {

    }

    @Override
    public void loop() {
        if (MacenumPowerLeft > maxvalue) {
            MacenumPowerLeft = 1;

        }
        if (MacenumPowerLeft < -maxvalue) {
            MacenumPowerLeft = -1;
        }
        if (MacenumPowerRight > maxvalue) {
            MacenumPowerRight = 1;

        }
        if (MacenumPowerRight < -maxvalue) {
            MacenumPowerRight = -1;
        }
        if (MacenumPowerLeft >= 0.05) {
            robot.leftBack.setPower(MacenumPowerLeft);
            robot.rightFront.setPower(MacenumPowerRight);
        }
        if (MacenumPowerRight >= 0.05) {
            robot.rightBack.setPower(MacenumPowerLeft);
            robot.leftFront.setPower(MacenumPowerRight);


        }
    }
}