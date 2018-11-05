package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.RobotHW;
import com.qualcomm.robotcore.hardware.Gamepad;

//Name of Opmode on phone
@TeleOp(name="MuffinRobo: Practice", group="Practice")

public class MuffinRobo extends LinearOpMode {

    /* Declare OpMode members. */
    RobotHW robot = new RobotHW();

    @Override
    public void runOpMode() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        boolean rightTrigger2 = gamepad2.right_bumper;
        double rightstickY2 = gamepad2.right_stick_y;
        boolean Y2 = gamepad2.y;
        boolean A2 = gamepad2.a;
        boolean G1rightBumper = gamepad1.right_bumper;
        boolean G1leftBumper = gamepad1.left_bumper;
        double forwardSpeed = gamepad1.right_stick_y;
        double drive;
        double turn;
        double left = 0.1;
        double right = 0.1;
        boolean collectionIn = gamepad2.x;
        boolean collectionOut = gamepad2.b;

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "SpaceMuffins are ready");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            robot.lock.setPosition(0.5);

            telemetry.addData("Move forward", "%.2f", forwardSpeed);
            telemetry.update();

            turn = -gamepad1.left_stick_y;
            drive = gamepad1.right_stick_x;

            // calculating power for left and right wheels using previous variables
            left  = drive + turn;
            right = drive - turn;

            // giving power to all motors
            robot.leftBack.setPower(left);
            robot.rightBack.setPower(right);
            robot.leftFront.setPower(left);
            robot.rightFront.setPower(right);

            //strafing right
            if(gamepad1.right_bumper){
                robot.leftBack.setPower(0.6);
                robot.leftFront.setPower(-0.6);
                robot.rightBack.setPower(0.7);
                robot.rightFront.setPower(-0.7);

                telemetry.addData("Status:","Robot is strafing to the right");
                telemetry.update();
            }

            //strafing left
            if(gamepad1.left_bumper){
                robot.leftBack.setPower(-0.6);
                robot.leftFront.setPower(0.75);
                robot.rightBack.setPower(-0.7);
                robot.rightFront.setPower(0.6);

                telemetry.addData("Status:","Robot is strafing to the left");
                telemetry.update();
            }

            //letting driver know if mecanum wheels aren't recieving signals
            if(gamepad1.right_bumper == false && gamepad1.left_bumper == false){
                telemetry.addData("Status", "No Bumpers pressed");
                telemetry.update();
            }

            //if robot isn't moving forward
            if(gamepad1.right_stick_y == 0){
                telemetry.addData("Status", "Robot isn't tank driving");
                telemetry.update();
            }

            if(gamepad2.x){
                robot.collectionHex.setDirection(DcMotor.Direction.FORWARD);
                robot.collectionHex.setPower(-0.8);
            }
            else{
                robot.collectionHex.setPower(0);
            }

            if(gamepad2.b){
                robot.collectionHex.setDirection(DcMotor.Direction.REVERSE);
                robot.collectionHex.setPower(0.8);
            }
            else{
                robot.collectionHex.setPower(0);
            }

            //right bumper locks the slide
            if(gamepad2.right_bumper){
                robot.lock.setPosition(180);
                telemetry.addData("Status:","The linear slide is locked");
                telemetry.update();

            }
            else{
                robot.lock.setPosition(90);
                telemetry.addData("Status:","The lock is unlocked");
                telemetry.update();
            }

            //pressing 'A' to move LS down
            if(gamepad2.a){
                robot.linearSlide.setPower(-0.95);

                telemetry.addData("Status:","The linear slide is going down");

                telemetry.update();
            }

            //keeping linear slide power lower than +(-) 0.2
            if(gamepad2.right_stick_y > 0.2){
                robot.linearSlide.setPower(-0.2);
            }
            else{
                robot.linearSlide.setPower(gamepad2.right_stick_y);
            }

            //to prevent gamepad from moving LS down
            if(gamepad2.right_stick_y < 0){
                robot.linearSlide.setPower(0);

                telemetry.addData("Don't do that:","Use button A to move linear slide down");
                telemetry.update();
            }
            else{
                robot.linearSlide.setPower(gamepad2.right_stick_y);
            }


            //checking if either gamepad is receiving signals
            if(gamepad2.atRest()==true && gamepad1.atRest()==true){
                telemetry.addData("Status", "The robot isn't receiving any signals");
                telemetry.update();
            }

        }
    }
}