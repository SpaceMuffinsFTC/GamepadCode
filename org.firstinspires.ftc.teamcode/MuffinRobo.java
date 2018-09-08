package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="MuffinRobo: Teleop POV", group="Practice")

public class MuffinRobo extends LinearOpMode {

    /* Declare OpMode members. */
    RobotHW robot           = new RobotHW();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();
    double     FORWARD_SPEED = gamepad1.left_stick_y;  // was 0.6 power

    @Override
    public void runOpMode() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        MacenumWheels mace = new MacenumWheels();
        ClawArm clawArm = new ClawArm();

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        while (runtime.seconds() < 30) {
            // Send telemetry message to signify robot waiting;
            telemetry.addData("Move forward", "%.2f", FORWARD_SPEED);    //
            telemetry.update();
        }
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            mace.loop();

            clawArm.loop();




            // Pace this loop so jaw action is reasonable speed.
            sleep(50);
        }
    }
}

