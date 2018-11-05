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

@Autonomous(name="AutonomousScrimmageDepot", group="Practice")

public class AutonomousScrimmageDepot extends LinearOpMode {

    RobotHW robot = new RobotHW();
    ElapsedTime runtime = new ElapsedTime();

    public void runOpMode () throws InterruptedException {

        double maxPower = 0.65;

        robot.init(hardwareMap);

        waitForStart();

        runtime.reset();

        // unlock the linear slide
        robot.lock.setPosition(0.5);

        telemetry.addData("Linear Slide Status:", "Unlocked");

        telemetry.update();

        // wait for 4 seconds
        //  while (runtime.seconds() <= 2){
        // robot.leftBack.setPower(-0.6);
        // robot.leftFront.setPower(-0.6);
        // robot.rightBack.setPower(0.6);
        // robot.rightFront.setPower(0.6);
        // }



        // wait for 4 seconds to let the robot come down
        while (runtime.seconds() <= 4) {
        }

        // raising linear slide a little to unhook linear slide
        while (runtime.seconds() <= 4.5){
            robot.linearSlide.setPower(0.09);

        }
        // turn out of hook
        while (runtime.seconds() <= 5) {
            robot.leftBack.setPower(0.6);
            robot.leftFront.setPower(0.6);
            robot.rightBack.setPower(0.6);
            robot.rightFront.setPower(0.6);
        }
        //move backwards
        while (runtime.seconds() <= 6) {
            robot.leftBack.setPower(0.6);
            robot.leftFront.setPower(0.6);
            robot.rightBack.setPower(-0.6);
            robot.rightFront.setPower(-0.6);
        }
        //turn towards depot
        while (runtime.seconds() <= 7){
            robot.leftBack.setPower(-0.6);
            robot.leftFront.setPower(-0.6);
            robot.rightBack.setPower(-0.6);
            robot.rightFront.setPower(-0.6);
        }
        // move towards depot
        while (runtime.seconds() <= 8.5) {
            robot.leftBack.setPower(0.6);
            robot.leftFront.setPower(0.6);
            robot.rightBack.setPower(-0.6);
            robot.rightFront.setPower(-0.6);
        }
        //put team marker in depot
        robot.teamMarker.setPosition(1.0);
        Thread.sleep(2000);
        robot.teamMarker.setPosition(0.3);
        Thread.sleep(4000);
        robot.teamMarker.setPosition(0.5);


        // lower line slide from 6.5 seconds to 8 seconds
        while (runtime.seconds() > 6 && runtime.seconds() < 7.5) {

            robot.linearSlide.setPower(0.1);
        }

        // back up 3.75 feet and lower arm into depot to drop team markerf
        // turn left 100 degrees and move 3 feet
        // move forward into crater while detetecting for obstacles
        // if obstacles are detected then stop
    }

}