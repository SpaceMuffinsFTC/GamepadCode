package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcontroller.external.samples.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import java.util.*;

@TeleOp

public class MacenumWheels extends OpMode{
   RobotHW robot = new RobotHW();
   int MAX_VALUE = 1;
   public void init(){
      robot.init(hardwareMap);
      telemetry.addData("STATUS", "Initialized");
   }

   public void init_loop(){
   }

   public void start(){
   }

   public void loop(){
      double G1rightStickY = gamepad1.right_stick_y;
      double G1leftStickY = gamepad1.left_stick_y;
      boolean G1rightBumper = gamepad1.right_bumper;
      boolean G1leftBumper = gamepad1.left_bumper;

      if(G1rightBumper){
         robot.leftBack.setPower(MAX_VALUE);
         robot.leftFront.setPower(-MAX_VALUE);
         robot.rightBack.setPower(-MAX_VALUE);
         robot.rightFront.setPower(MAX_VALUE);
      }
      else if(G1leftBumper){
         robot.leftBack.setPower(-MAX_VALUE);
         robot.leftFront.setPower(MAX_VALUE);
         robot.rightBack.setPower(MAX_VALUE);
         robot.rightFront.setPower(-MAX_VALUE);
      }
      else{
         robot.leftBack.setPower(G1leftStickY);
         robot.leftFront.setPower(G1leftStickY);
         robot.rightBack.setPower(-G1leftStickY);
         robot.rightFront.setPower(-G1leftStickY);
      }

   }

}
