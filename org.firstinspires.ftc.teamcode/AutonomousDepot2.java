package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class AutonomousDepot2 extends LinearOpMode{

    RobotHW robot = new RobotHW();
    GoldDetector gold = new GoldDetector();
    ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() throws InterruptedException{


        double maxPower = 0.65;

        robot.init(hardwareMap);
        robot.teamMarker.setPosition(0);
        Thread.sleep(2000);
        waitForStart();

        runtime.reset();

        //getting robot down
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
            telemetry.addData("Status: ", "Turned out of hook");
            telemetry.update();
        }

        //sampling
        while(runtime.seconds()>= 12.25 && runtime.seconds()<=18.25){
            if(gold.isFound()){
                drive(0.5);
                telemetry.addData("Sampled: ","Gold hit");
                telemetry.update();
            } else{
                strafeLeft(0.4);
                if(gold.isFound()){
                    drive(0.5);
                    telemetry.addData("Sampled: ","Gold hit");
                    telemetry.update();
                } else {
                    strafeLeft(0.4);
                    if(gold.isFound()){
                        drive(0.5);
                        telemetry.addData("Sampled: ","Gold hit");
                    } else {
                        telemetry.addData("Problem: ","We couldn't find a gold block");
                        telemetry.update();
                    }
                }
            }
        }

        //driving towards depot
        while(runtime.seconds()>=18.25 && runtime.seconds()<= 21){
            drive(0.5);
            telemetry.addData("Status: ","Driving towards depot" );
            telemetry.update();
        }
        // turning so that the team marker faces the depot
        while(runtime.seconds()>=21 && runtime.seconds()<=22.5){
            turnRight(0.5);
            telemetry.addData("Status: ","Turned towards depot");
            telemetry.update();
        }
        // moving backwards towards the depot to drop team marker
        while(runtime.seconds()>=22.5 && runtime.seconds()<=24){
            drive(-0.4);
            telemetry.addData("Status: ","Moving towards depot");
            telemetry.update();
        }

        //dropping team marker
        while(runtime.seconds()>=24 && runtime.seconds()<= 25.5){
            robot.teamMarker.setPosition(0.2);
            telemetry.addData("Status: ","Dropping team marker");
            telemetry.update();
        }

        //turns towards crater
        while(runtime.seconds()>= 25.5 && runtime.seconds()<=27){
            turnRight(0.4);
            telemetry.addData("Status: ", "Turning towards crater");
            telemetry.update();
        }

        //drives into crater
        while(runtime.seconds()>=27 && runtime.seconds()<=230){
            drive(-0.5);
            telemetry.addData("Status: ","Driving into crater");
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

    //strafe left
    public void strafeLeft(double power){
        robot.leftBack.setPower(-power);
        robot.rightBack.setPower(power);
        robot.leftFront.setPower(power);
        robot.rightFront.setPower(-power);
    }

    //strafe right
    public void strafeRight(double power){
        robot.leftBack.setPower(power);
        robot.rightBack.setPower(-power);
        robot.leftFront.setPower(-power);
        robot.rightFront.setPower(power);
    }
}