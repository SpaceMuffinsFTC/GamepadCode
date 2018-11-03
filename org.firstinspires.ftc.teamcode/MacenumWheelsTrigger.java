package org.firstinspires.ftc.teamcode;

import android.content.Context;
import com.qualcomm.robotcore.hardware.Gamepad;
import android.widget.Toast;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.RobotHW;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


public class MacenumWheelsTrigger extends OpMode {

    // defining and initializing variables
    private RobotHW robot;
    double MAXVALUE = 0.8;
    //  double MacenumPowerLeft = gamepad1.left_trigger;
    //double MacenumPowerRight = gamepad1.right_trigger;
    double left= 0.1;
    double right = 0.1;
    double drive;
    double turn;
// creating an object reference for robot hardware

    public MacenumWheelsTrigger(RobotHW robotTmp) {
        this.robot = robotTmp;

    }




    @Override
    public void init () {

    }



    @Override
    public void loop () {
        // initializing variables for tanks drive

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;

        // calculating power for left and right wheels using previous variables

        left  = drive + turn;
        right = drive - turn;

        // making sure left and right don't go over set maxvalue which is 0.8

        MAXVALUE = Math.max(Math.abs(left), Math.abs(right));
        if (MAXVALUE > 1.0)
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

        // if statement to check if triggers are being pressed at all, if they are then give power to right motors
        // if right trigger is pressed then strafe right
        boolean G1rightBumper = gamepad1.right_bumper;
        boolean G1leftBumper = gamepad1.left_bumper;

        if(G1rightBumper){
            robot.leftBack.setPower(MAXVALUE);
            robot.leftFront.setPower(-MAXVALUE);
            robot.rightBack.setPower(-MAXVALUE);
            robot.rightFront.setPower(MAXVALUE);
        }
        else if(G1leftBumper){
            robot.leftBack.setPower(-MAXVALUE);
            robot.leftFront.setPower(MAXVALUE);
            robot.rightBack.setPower(MAXVALUE);
            robot.rightFront.setPower(-MAXVALUE);
        }


    }
}

