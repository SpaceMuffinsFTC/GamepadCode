package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.RobotHW;

@Autonomous(name="Autonomous 2", group="Practice")
public class Autonomous2 extends LinearOpMode{

    RobotHW robot = new RobotHW();

    @Override
    public void runOpMode(){
        RobotUpDown upDown = new RobotUpDown(robot);
        ElapsedTime runTime = new ElapsedTime();

        double maxPower = 0.8;

        robot.init(hardwareMap);

        waitForStart();

        runTime.reset();

        while(opModeIsActive()){
            // //bring robot down
            // while(runTime.seconds() < 2){
            //     upDown.robotDown();
            // }

            //strafe out of hook
            while(runTime.seconds() < 3){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-0.425);
                robot.rightFront.setPower(maxPower);
            }
            //bring linear slide down
            while(runTime.seconds() < 4){
                upDown.robotUp();
            }
            //back up from lander
            while(runTime.seconds() < 5){
                robot.leftFront.setPower(-maxPower);
                robot.rightFront.setPower(-maxPower);
                robot.leftBack.setPower(-maxPower);
                robot.rightBack.setPower(-0.425);
            }
            //strafe left towards depot
            while(runTime.seconds() < 6){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-0.425);
                robot.rightFront.setPower(maxPower);
            }
            //go straight to depot
            while(runTime.seconds() < 7){
                robot.leftFront.setPower(maxPower);
                robot.rightFront.setPower(maxPower);
                robot.leftBack.setPower(maxPower);
                robot.rightBack.setPower(0.425);
            }
            //strafe into depot
            while(runTime.seconds() < 8){
                robot.leftBack.setPower(maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-0.425);
                robot.rightFront.setPower(maxPower);
            }
        }
    }
}