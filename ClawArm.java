package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class ClawArm extends OpMode {
    RobotHW robot = new RobotHW();

    double armOffset = 0.0;

    public void init(){
        robot.init(hardwareMap);

    }

    public void loop(){
        boolean rightbumper = gamepad2.right_bumper;
        boolean leftbumper = gamepad2.left_bumper;

        if(rightbumper == true){
            robot.rightClaw.setPosition(0.5);
        }
        else {
            robot.rightClaw.setPosition(-0.5);
        }

        if(leftbumper == true){
            robot.leftClaw.setPosition(0.5);
        }
        else{
            robot.leftClaw.setPosition(-0.5);
        }

        if(leftbumper == false && rightbumper == false){
            robot.leftClaw.setPosition(armOffset);
        }

        float rightStickY2 = gamepad2.right_stick_y;
        float leftStickY2 = gamepad2.left_stick_y;

        if(leftStickY2 > 0){
            robot.arm.setDirection(DcMotorSimple.Direction.FORWARD);
            robot.arm.setPower(1.0);
        }

        if(rightStickY2 > 0){
            robot.arm.setDirection(DcMotorSimple.Direction.FORWARD);
            robot.arm.setPower(-1.0);
        }

        if(rightStickY2 == 0.0f && leftStickY2 == 0.0f){
            robot.arm.setPower(armOffset);
        }
    }



}
