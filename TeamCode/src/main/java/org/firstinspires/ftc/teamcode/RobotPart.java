package org.firstinspires.ftc.teamcode;
import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public abstract class RobotPart {
    private String caption;
    Telemetry telemetry;
    Innov8HWMap elephant;
    LinearOpMode opMode;
    boolean lock = false;
    public RobotPart(Telemetry telemetry, Innov8HWMap elephant, LinearOpMode opMode){
        this.opMode = opMode;
        this.caption = this.getClass().getName();
        this.elephant = elephant;
        //this.innov8HWMap = innov8HWMap;
        this.telemetry = telemetry;
        this.telemetry.update();
    }

    public abstract void teleopUpdate(Gamepad gamepad1, Gamepad gamepad2, double minSpeed, double maxSpeed);

    public void showData (String caption, String value) {
        this.telemetry.addData(caption, value);
        this.telemetry.update();
        Log.d(caption, value);
    }

}