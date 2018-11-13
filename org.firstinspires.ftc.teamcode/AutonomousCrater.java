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

public class AutonomousCrater extends LinearOpMode {
    //initializing motors throguh RobotHW
    RobotHW robot = new RobotHW();
    //Timer system
    ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        //initializing the max power(the power we are mainly going to use) so it isn't hardcoded
        double maxPower = 0.65;

        robot.init(hardwareMap);
        //waiting to move until start is pressed on the driver station
        waitForStart();
        //reseting the timer to 0
        runtime.reset();
        //updating telemetry to show on the driver station
        telemetry.update();

        //raising linear slide to drop robot
        while (runtime.seconds() <= 5.45){
            robot.linearSlide.setPower(-0.6);
        }

        //moving back a little bit in the hook
        while (runtime.seconds() >= 5.45 && runtime.seconds() <= 5.65){
            robot.linearSlide.setPower(0);
            drive(-0.3);
        }

        //raise the linear slide so we can get out
        while(runtime.seconds() >= 5.65 && runtime.seconds() <= 7.65){
            stopDriving();
            robot.linearSlide.setPower(-0.6);
            telemetry.addData("Status: ", "Linear Slide Up");
            telemetry.update();
        }

        // turning out of the hook
        while (runtime.seconds() >= 7.65 && runtime.seconds() <= 8.65) {
            robot.linearSlide.setPower(0);
            turnRight(0.3);
            telemetry.addData("Status: ", "Turned Right");
            telemetry.update();
        }

        //going back after hook
        while(runtime.seconds() >= 8.65 && runtime.seconds() <= 9.65){
            stopDriving();
            drive(-0.3);
        }

        //  //stopping
        //  while(runtime.seconds() >=9.65 && runtime.seconds() >= 10.65){
        //     stopDriving();
        //     telemetry.addData("Status: ", "Bottom of the hook.");
        //     telemetry.update();
        //  }

        //turn left to face the crater
        while(runtime.seconds() >= 9.65 && runtime.seconds() <= 11.15){
            stopDriving();
            turnLeft(0.3125);
        }

        //  while(runtime.seconds() >= 10.85 && runtime.seconds() <= 16.85){
        //      stopDriving();
        //      drive(-0.6);
        //  }

        //driving toward the crater
        while(runtime.seconds() >= 11.15 && runtime.seconds() <= 14.95){
            robot.linearSlide.setPower(0);
            stopDriving();
            drive(-0.5);
            telemetry.addData("Status: ", "Going to Crater");
            telemetry.update();
        }

        //stopping in the crater
        while(runtime.seconds() >= 14.95 && runtime.seconds() <= 16.95){
            stopDriving();
            telemetry.addData("Status: ", "In the Crater");
            telemetry.update();
        }











        //  //turning to face the crater
        //  while(runtime.seconds() >= 8.65 && runtime.seconds() <= 10.85){
        //     stopDriving();
        //     //turnRight(0.3);
        //     robot.leftBack.setPower(0.6);
        //     robot.leftFront.setPower(-0.6);
        //     robot.rightBack.setPower(0.7);
        //     robot.rightFront.setPower(-0.7);
        //     robot.linearSlide.setPower(0.7);
        //     telemetry.addData("Status: ", "Facing Crater");
        //     telemetry.update();
        //  }

        //  //driving toward the crater
        //  while(runtime.seconds() >= 10.85 && runtime.seconds() <= 16.85){
        //      robot.linearSlide.setPower(0);
        //      stopDriving();
        //      drive(0.7);
        //      telemetry.addData("Status: ", "Going to Crater");
        //      telemetry.update();
        //  }

        //  //stopping in the crater
        //  while(runtime.seconds() >= 16.85 && runtime.seconds() <= 18.85){
        //      stopDriving();
        //      telemetry.addData("Status: ", "In the Crater");
        //      telemetry.update();
        //  }

        if (isStopRequested()){
            stopDriving();
            telemetry.addData("Status: ", "Robot is Stoped");
            telemetry.update();
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
        //for(double i=0.5; i=0.0; i-=0.1) {
        //    drive(i);
        //Thread.sleep(250);
        // }
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
