package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class SimpleAutonomous {

    public void main() throws InterruptedException {
        RobotHW robot = new RobotHW();

        waitForStart();

        drive(0.8);
        Thread.sleep(2000);
        stopDriving();
        Thread.sleep(500);
        turnRight(0.8));
        Thread.sleep(1000);
        stopDriving();
        Thread.sleep(500);
        turnLeft(0.8);
        Thread.sleep(1000);
        stopDriving();
        Thread.sleep(500);
        drive(-0.8));
        Thread.sleep(2000);
        stopDriving();

    }

    public void drive(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(power);
    }

    public void stopDriving(){
        driveForward(0);
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
