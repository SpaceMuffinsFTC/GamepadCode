package org.firstinspires.ftc.teamcode;


public class AutoOpMode extends OpMode{

    GhostController ghostController = new GhostController(//put generated opmode string here);
            /*we need to download an app called Simple Notepad on the robot controller phone
            to to save the created opmode to external storage to access with a computer*/

    public init(){

    }

    public loop(){
        ghostController.update();

        ghostController.getLeftStickX();
        ghostController.getLeftStickY();
        ghostController.getRightStickX();
        ghostController.getRightStickY();

        ghostController.getButtonX();
        ghostController.getButtonA();
        ghostController.getButtonB();
        ghostController.getButtonY();

        ghostController.getDpadUp();
        ghostController.getDpadDown();
        ghostController.getDpadLeft();
        ghostController.getDpadRight();
    }

}