package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.widget.Toast;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

public class MacenumWheelsTrigger extends OpMode {
    // defining and initializing variables
    private RobotHW robot;
    double MAXVALUE = 0.8;
    double MacenumPowerLeft = gamepad1.left_trigger;
    double MacenumPowerRight = gamepad1.right_trigger;
    double left= 0.1;
    double right = 0.1;
    double drive;
    double turn;
    Gamepad gamePad1;
    // creating an object reference for robot hardware
    public MacenumWheelsTrigger(RobotHW robotTmp, Gamepad gamepadTmp) {
        this.robot = robotTmp;
        gamePad1 = gamepadTmp;
    }


    @Override
    public void init () {
    }

    public void start () {
    }

    @Override
    public void loop () {
        // define variables for tanks drive

        drive = -gamePad1.left_stick_y;
        turn = gamePad1.right_stick_x;

        // calculating power for left and right wheels using previous variables

        left  = drive + turn;
        right = drive - turn;

        // making sure left and right don't go over set maxvalue which is 0.8

        MAXVALUE = Math.max(Math.abs(left), Math.abs(right));
        if (MAXVALUE > 0.8)
        {
            left /= MAXVALUE;
            right /= MAXVALUE;
        }

        // giving power to all motors
        robot.leftBack.setPower(left);
        robot.rightBack.setPower(right);
        robot.leftFront.setPower(left);
        robot.rightFront.setPower(right);

          /*  if (drive == 0){
                for (double i=drive; i == 0; i-=0.1) {
                    robot.rightFront.setPower(i);
                    robot.leftFront.setPower(i);
                    robot.leftBack.setPower(i);
                    robot.rightBack.setPower(i);
                }
            } */

        // if statement to check if triggers are being pressed at all, if they are then give power to correct motors
        // if right trigger is pressed then strafe right
        if (MacenumPowerLeft >= 0.01) {
            robot.leftBack.setPower(-MacenumPowerLeft);
            robot.rightFront.setPower(-MacenumPowerRight);
            robot.leftFront.setPower(MacenumPowerLeft);
            robot.rightBack.setPower(MacenumPowerLeft);
        }
        if (MacenumPowerRight >= 0.01) {
            robot.rightBack.setPower(-MacenumPowerLeft);
            robot.leftFront.setPower(-MacenumPowerRight);
            robot.rightFront.setPower(MacenumPowerRight);
            robot.leftBack.setPower(MacenumPowerLeft);

            // making sure power values don't go over max value
            // if trigger power goes over
        }
        if (MacenumPowerLeft > MAXVALUE) {
            MacenumPowerLeft = MAXVALUE;

        }

        if (MacenumPowerRight > MAXVALUE) {
            MacenumPowerRight = MAXVALUE;

        }


    }
}