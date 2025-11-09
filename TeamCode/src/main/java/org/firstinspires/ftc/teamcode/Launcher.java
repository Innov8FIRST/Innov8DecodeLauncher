package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher extends RobotPart {
    double pulsesPerRev = 1425.1;
    double launcherStartPos;
    double launcherPosChange;
    double launcherPosTarget;
    boolean primed = false;

    public Launcher(Telemetry telemetry, Innov8HWMap elephant, LinearOpMode opMode) {
        super(telemetry, elephant, opMode);
        launcherStartPos = this.elephant.launcher.getCurrentPosition();

    }

    public void teleopUpdate(Gamepad gamepad1, Gamepad gamepad2, double minSpeed, double maxSpeed) {
        if (gamepad1.x && !elephant.TouchSensor1.isPressed()) {
            this.elephant.launcher.setPower(0.5);
            primed = false;
        }
        if(elephant.TouchSensor1.isPressed() && !primed){
            this.elephant.launcher.setPower(0.0);
            primed = true;
        }
        if(gamepad1.y && primed){
            launcherStartPos = this.elephant.launcher.getCurrentPosition();
            launcherPosChange = 0;
            launcherPosTarget = 120;
            Log.d("launcherPos","current: " + this.elephant.launcher.getCurrentPosition());
            Log.d("launcherPos","change: " + this.launcherPosChange);
            while(launcherPosChange < launcherPosTarget && this.opMode.opModeIsActive()){
                this.elephant.launcher.setPower(0.5);
                launcherPosChange = -launcherStartPos + this.elephant.launcher.getCurrentPosition();
                Log.d("launcherPos","current: " + this.elephant.launcher.getCurrentPosition());
                Log.d("launcherPos","change: " + this.launcherPosChange);
            }
            this.elephant.launcher.setPower(0);
            primed = false;
            Log.d("launcherPos","current: " + this.elephant.launcher.getCurrentPosition());
            Log.d("launcherPos","change: " + this.launcherPosChange);
        }

    }
}