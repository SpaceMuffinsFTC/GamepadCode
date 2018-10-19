package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="MuffinRobo: Teleop POV", group="Practice")

public class MuffinRobo extends LinearOpMode {

    /* Declare OpMode members. */
    RobotHW robot           = new RobotHW();
    private ElapsedTime     runtime = new ElapsedTime();
    double     FORWARD_SPEED = gamepad1.left_stick_y;  // was 0.6 power

    @Override
    public void runOpMode() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        MacenumWheelsTrigger macetrig = new MacenumWheelsTrigger();
        LinearSlide lSlide = new LinearSlide();
        MineralArm arm = new MineralArm();

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        while (runtime.seconds() < 3.0) {

            telemetry.addData("Move forward", "%.2f", FORWARD_SPEED);    //
            telemetry.update();
        }
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            macetrig.loop();

            lSlide.loop();

            arm.loop();

            // Pace this loop so action is reasonable speed.
            sleep(50);
        }
    }
}

