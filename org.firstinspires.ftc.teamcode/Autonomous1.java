package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.RobotHW;

@Autonomous(name="Autonomous1", group="Practice")

public class Autonomous1 extends LinearOpMode {

    RobotHW robot = new RobotHW();

    public void runOpMode(){
        //AndroidSensors sensors = new AndroidSensors();

        ElapsedTime runtime = new ElapsedTime();
        RobotUpDown upDown = new RobotUpDown(robot);

        double maxPower = 0.65;

        robot.init(hardwareMap);

        waitForStart();

        runtime.reset();

        while(opModeIsActive()){
            //bring robot down
            while(runtime.seconds() < 1){
                upDown.robotDown();
            }

            //strafe out of hook
            while(runtime.seconds() < 2){
                robot.leftBack.setPower(-maxPower);
                robot.leftFront.setPower(maxPower);
                robot.rightBack.setPower(-0.425);
                robot.rightFront.setPower(maxPower);
            }

            //bring linear slide down
            while(runtime.seconds() < 3){
                upDown.robotUp();
            }

            //back into depot
            while(runtime.seconds() < 5){
                robot.leftBack.setPower(-maxPower);
                robot.leftFront.setPower(-maxPower);
                robot.rightBack.setPower(-0.425);
                robot.rightFront.setPower(-maxPower);
            }

        }

    }
}
