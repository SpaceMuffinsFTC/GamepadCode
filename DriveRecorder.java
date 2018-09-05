package org.firstinspires.ftc.teamcode.GhostAutonomous;

package org.firstinspires.ftc.teamcode;

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

        ghostRecorder.recordButtonA(gamepad1.a);
        ghostRecorder.recordButtonB(gamepad1.b);
        ghostRecorder.recordButtonX(gamepad1.x);
        ghostRecorder.recordButtonY(gamepad1.y);


        ghostRecorder.recordDpadDown(gamepad1.dpad_down);
        ghostRecorder.recordDpadUp(gamepad1.dpad_up);
        ghostRecorder.recordDpadRight(gamepad1.dpad_right);
        ghostRecorder.recordDpadLeft(gamepad1.dpad_left);

        ghostRecorder.recordrightbumper(gamepad1.right_bumper);
        ghostRecorder.recordleftbumper(gamepad1.left_bumper);

        //code to drive robot
        //have to add code to drive bot

        ghostRecorder.update(); //have to do this to actually record all of the values
    }

    public void stop() {
        codeSharer.share(ghostRecorder.getString());
    }
}
