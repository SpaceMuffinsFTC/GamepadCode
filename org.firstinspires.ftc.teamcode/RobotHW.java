package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class RobotHW {

    public RobotHW(){

    }

    /* Public OpMode members. */
    public DcMotor  leftBack;
    public DcMotor  rightBack;
    public DcMotor  leftFront;
    public DcMotor  rightFront;
    public DcMotor  linearSlide;
    public Servo    teamMarker;
    public DcMotor  collectionHex;
    public Servo lock;


    /* local OpMode members. */
    HardwareMap hwMap           =  null;

    private ElapsedTime period  = new ElapsedTime();



    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftBack  = hwMap.get(DcMotor.class, "leftBack");
        rightBack = hwMap.get(DcMotor.class, "rightBack");
        leftFront  = hwMap.get(DcMotor.class, "leftFront");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        linearSlide = hwMap.get(DcMotor.class, "linearSlide");
        teamMarker = hwMap.get(Servo.class, "teamMarker");
        collectionHex = hwMap.get(DcMotor.class, "collectionHex");
        lock = hwMap.get(Servo.class, "lock");

        final double MID_SERVO       =  0.0 ;

        leftBack.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightBack.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftFront.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightFront.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        linearSlide.setDirection(DcMotor.Direction.FORWARD);
        collectionHex.setDirection(DcMotor.Direction.FORWARD);
        lock.setDirection(Servo.Direction.FORWARD);
        teamMarker.setDirection(Servo.Direction.REVERSE);

        // Set all motors to zero power
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
        linearSlide.setPower(0);
        collectionHex.setPower(0);
        lock.setPosition(MID_SERVO);
        teamMarker.setPosition(0.0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        linearSlide.setMode((DcMotor.RunMode.RUN_WITHOUT_ENCODER));
        collectionHex.setMode((DcMotor.RunMode.RUN_WITHOUT_ENCODER));



    }
}

