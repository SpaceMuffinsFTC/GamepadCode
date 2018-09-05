package org.firstinspires.ftc.teamcode;

import java.util.*;
import java.lang.Boolean;

public class ButtonValues extends ControllerValues<Boolean> {
    public final static String buttonA="a";
    public final static String buttonB="b";
    public final static String buttonX="x";
    public final static String buttonY="y";
    public final static String dpadUp="du";
    public final static String dpadDown="dd";
    public final static String dpadLeft="dl";
    public final static String dpadRight="dr";
    public final static String rightbumper = "rb";
    public final static String leftbumper = "lb";



    public ButtonValues() {
        super(false, new ArrayList<String>(Arrays.asList(new String[]{buttonA,buttonB,buttonX,buttonY,dpadUp,dpadDown,dpadLeft,dpadRight,rightbumper,leftbumper})))
        ;}



}

