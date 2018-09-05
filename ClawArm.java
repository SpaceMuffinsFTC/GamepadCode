package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class ClawArm extends OpMode {
    RobotHW robot = new RobotHW();

    double clawOffset;

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
            robot.leftClaw.setPosition(clawOffset);
        }

        boolean dpadUp = gamepad2.dpad_up;
        boolean dpadDown = gamepad2.dpad_down;

        if(dpadUp==true){
            robot.leftArm.setPosition(0.5);
            robot.rightArm.setPosition(0.5);
        }
        if(dpadDown==true){
            robot.leftArm.setPosition(-0.5);
            robot.rightArm.setPosition(-0.5);
        }
        if(dpadDown==false && dpadUp==false){
            robot.leftArm.setPosition(0);
            robot.rightArm.setPosition(0);
        }
    }



}
