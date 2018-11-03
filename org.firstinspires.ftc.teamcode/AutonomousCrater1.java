package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.CRServoImpl;

import org.firstinspires.ftc.teamcode.RobotHW;

@Autonomous(name="AutonomousCrater", group="Practice")

public class AutonomousCrater1 extends LinearOpMode {

    RobotHW robot = new RobotHW();
    ElapsedTime runtime = new ElapsedTime();


    public void runOpMode(){

        double maxPower = 0.65;

        robot.init(hardwareMap);

        waitForStart();

        runtime.reset();

        robot.lock.setPosition(0.5);

        telemetry.addData("Linear Slide Status:", "Unlocked");

        telemetry.update();
        // wait for 4 seconds

        //
        // while (runtime.seconds() <= 4) {

        // }
        // raising linear slide a little to unhook linear slide
        // while (runtime.seconds() <= 5){
        //     robot.linearSlide.setPower(-0.09);
        // }

        // strafing out of the hook
        // while (runtime.seconds() <= 6) {
        // robot.leftBack.setPower(0.6);
        // robot.leftFront.setPower(-0.55);
        // robot.rightBack.setPower(0.55);
        // robot.rightFront.setPower(-0.75);
        // }

        // turning towards the crater
        // while (runtime.seconds() <= 6.7) {
        // turnLeft(0.2);
        // }

        //driving toward the crater
        while(runtime.seconds() <=5){
            drive(-0.6);
        }

        while(runtime.seconds() >=8){
            stopDriving();
        }


    }

    public void drive(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(-power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(-power);
    }

    public void stopDriving(){
        //for(double i=0.5; i=0.0; i-=0.1) {
        //    drive(i);
        //Thread.sleep(250);
        // }
        drive(0);
    }

    public void turnRight(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(power);
    }

    public void turnLeft(double power){
        robot.leftBack.setPower(-power);
        robot.rightBack.setPower(-power);
        robot.leftFront.setPower(-power);
        robot.rightFront.setPower(-power);
    }

}