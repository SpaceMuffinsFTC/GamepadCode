package org.firstinspires.ftc.teamcode.GhostAutonomous;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="DriveRecorder: Teleop POV", group="Practice")
public class DriveRecorder extends OpMode {

    GhostRecorder ghostRecorder=new GhostRecorder();
    CodeSharer codeSharer=new CodeSharer(hardwareMap.appContext);

    public void init() {
    }

    public void loop() {

        //only record values you are using to control robot
        ghostRecorder.recordLeftStickY(gamepad1.left_stick_y);
        ghostRecorder.recordRightStickY(gamepad1.right_stick_y);
        ghostRecorder.recordLeftStickX(gamepad1.left_stick_x);
        ghostRecorder.recordRightStickX(gamepad1.right_stick_x);

        ghostRecorder.recordButtonA(gamepad1.x);
        //and B,X or Y

        ghostRecorder.recordDpadDown(gamepad1.dpad_down);
        //and Up,Left or Right

        //code to drive robot
        //have to add code to drive bot

        ghostRecorder.update(); //have to do this to actually record all of the values
    }

    public void stop() {
        codeSharer.share(ghostRecorder.getString());
    }
}
