package org.firstinspires.ftc.teamcode;

import java.util.*;
public class StickValues extends ControllerValues<Float> {
    public final static String leftStickY="ly";
    public final static String rightStickY="ry";
    public final static String leftStickX="lx";
    public final static String rightStickX="rx";
    public final static String rightTrigger = "rt";
    public final static String leftTrigger = "lt";
    public final static String leftStickY2 = "ly2";
    public final static String rightStickY2 = "ry2";


    public StickValues() {
        super(3.5f,
                new ArrayList<String>(Arrays.asList(new String[]{leftStickY,rightStickY,leftStickX,rightStickX, rightTrigger, leftTrigger, leftStickY2, rightStickY2}))
        );
    }
}

