# Gamepad-Code
This took us(A rookie FTC team) around 3 weeks to fully debug and get working. If you want this to work for yourself you would have to go into your robot controller and see what you have configured your motors to. Replace the leftBack, rightBack, leftFront, rightFront with what your motors are named in RobotHardware. Then rename the motors in the MacenumWheels and MuffinRobo code and change or delete some telemetry statements. 

The android sensors code is a template for using the light sensor, gyroscope, and accelerometer of a phone in ftc. You can add values and stuff inside the onAccuracyChanged and onSensorChanged methods for each sensor.

The buttonvalues, stickvalues, ghostrecorder, ghostcontroller, codesharer, controllervalues, and driverecorder are all classes for the autonomous section. They work together to record any activity on the gamepad and turn the values into an opmode.
