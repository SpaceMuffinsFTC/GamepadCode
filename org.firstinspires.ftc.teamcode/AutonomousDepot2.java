package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.CRServoImpl;

import org.firstinspires.ftc.teamcode.RobotHW;

@Autonomous

public class AutonomousDepot2 extends LinearOpMode{

    RobotHW robot = new RobotHW();
    ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() throws InterruptedException{


        double maxPower = 0.65;

        robot.init(hardwareMap);
        robot.teamMarker.setPosition(0);
        Thread.sleep(2000);
        waitForStart();

        runtime.reset();

        while (runtime.seconds() <= 5.45){
            robot.linearSlide.setPower(-0.6);
        }

        //moving back a little bit in the hook
        while (runtime.seconds() >= 5.45 && runtime.seconds() <= 5.65){
            robot.linearSlide.setPower(0);
            drive(-0.3);
        }

        //raise the linear slide so we can get out
        while(runtime.seconds() >= 5.65 && runtime.seconds() <= 7.75){
            stopDriving();
            robot.linearSlide.setPower(-0.6);
            telemetry.addData("Status: ", "Linear Slide Up");
            telemetry.update();
        }

        // turning out of the hook
        while (runtime.seconds() >= 7.75 && runtime.seconds() <= 12.25) {
            robot.linearSlide.setPower(0);
            turnRight(0.3);
            telemetry.addData("Status: ", "Turned Right");
            telemetry.update();
        }

        //driving towards depot
        while(runtime.seconds()>=12.25 && runtime.seconds()<= 16){
            drive(0.5);
        }
        // turning so that the team marker faces the depot
        while(runtime.seconds()>=16 && runtime.seconds()<=17.5){
            turnRight(0.5);
        }
        // moving backwards towards the depot to drop team marker
        while(runtime.seconds()>=17.5 && runtime.seconds()<=19){
            drive(-0.4);
        }

        //dropping team marker
        while(runtime.seconds()>=19 && runtime.seconds()<= 20.5){
            robot.teamMarker.setPosition(0.2);
        }

        while (runtime.seconds() >= 20.5 && runtime.seconds()<= 22){
            stopDriving();
        }

        //turns towards crater
        while(runtime.seconds()>= 22 && runtime.seconds()<=23){
            turnRight(0.4);
        }

        //drives into crater
        while(runtime.seconds()>=23 && runtime.seconds()<=27){
            drive(-0.5);

        }

        while(runtime.seconds()>=27 && runtime.seconds()<=30){
            stopDriving();
        }




    }

    //drive forward/backward
    public void drive(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(-power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(-power);
    }
    //stop driving
    public void stopDriving(){
        drive(0);
    }
    //turn right
    public void turnRight(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(power);
    }
    //turn left
    public void turnLeft(double power){
        robot.leftBack.setPower(-power);
        robot.rightBack.setPower(-power);
        robot.leftFront.setPower(-power);
        robot.rightFront.setPower(-power);
    }
}
