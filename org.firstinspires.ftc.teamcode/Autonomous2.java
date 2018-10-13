package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Autonomous2 extends LinearOpMode{

    @Override
    public void runOpMode(){
        RobotHW robot = new RobotHW();
        RobotUpDown upDown = new RobotUpDown();
        ElapsedTime runTime = new ElapsedTime();

        double maxPower = 0.8;

        robot.init(hardwareMap);


        waitForStart();

        runTime.reset();

        while(opModeIsActive()){

            while(runTime.seconds() < 2.5){
                upDown.robotDown();
            }

            while(runTime.seconds() < 3){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-maxPower);
                robot.rightFront.setPower(maxPower);
            }

            while(runTime.seconds() < 4){
                upDown.robotUp();
            }

            while(runTime.seconds() < 5){
                robot.leftFront.setPower(-maxPower);
                robot.rightFront.setPower(-maxPower);
                robot.leftBack.setPower(-maxPower);
                robot.rightBack.setPower(-maxPower);
            }

            while(runTime.seconds() < 6){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-maxPower);
                robot.rightFront.setPower(maxPower);
            }

            while(runTime.seconds() < 7){
                robot.leftFront.setPower(maxPower);
                robot.rightFront.setPower(maxPower);
                robot.leftBack.setPower(maxPower);
                robot.rightBack.setPower(maxPower);
            }

            while(runTime.seconds() < 8){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-maxPower);
                robot.rightFront.setPower(maxPower);
            }
        }
    }

}
