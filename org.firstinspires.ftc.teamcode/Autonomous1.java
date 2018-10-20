package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous

public class Autonomous1 extends LinearOpMode {

    @Override
    public void runOpMode(){
        RobotHW robot = new RobotHW();
        AndroidSensors sensors = new AndroidSensors();
        ElapsedTime runtime = new ElapsedTime();
        RobotUpDown upDown = new RobotUpDown();

        double maxPower = 0.8;

        robot.init(hardwareMap);


        waitForStart();

        runtime.reset();

        while(opModeIsActive()){

            while(runtime.seconds() < 2){
                upDown.robotDown();
            }

            while(runtime.seconds() < 3){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-maxPower);
                robot.rightFront.setPower(maxPower);
            }

            while(runtime.seconds() < 4){
                upDown.robotUp();
            }

            while(runtime.seconds() < 6){
                robot.leftBack.setPower(-maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-maxPower);
                robot.rightFront.setPower(-maxPower);
            }
            //*drive into depot


        }

    }
}
