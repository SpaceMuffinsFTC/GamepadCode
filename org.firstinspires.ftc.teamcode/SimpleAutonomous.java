package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class SimpleAutonomous {

    public void main() throws InterruptedException {
        RobotHW robot = new RobotHW();

        waitForStart();

        drive(0.5);
        Thread.sleep(2000);
        stopDriving();
        Thread.sleep(500);
        turnRight(0.5));
        Thread.sleep(1000);
        stopDriving();
        Thread.sleep(500);
        turnLeft(0.5);
        Thread.sleep(1000);
        stopDriving();
        Thread.sleep(500);
        drive(-0.5);
        Thread.sleep(2000);
        //my code is very good
        stopDriving();

    }

    public void drive(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(power);
    }

    public void stopDriving(){
        for(int i=0.5; i=0; i-0.1) {
            driveForward(i);
            Thread.sleep(250);
        }
    }

    public void turnRight(double power){
        robot.leftBack.setPower(-power);
        robot.rightBack.setPower(power);
        robot.leftFront.setPower(-power);
        robot.rightFront.setPower(power);
    }

    public void turnLeft(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(-power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(-power);
    }


}
