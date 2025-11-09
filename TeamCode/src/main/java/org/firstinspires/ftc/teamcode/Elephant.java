package org.firstinspires.ftc.teamcode;


import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;


public class Elephant {
    //Objects
    Telemetry telemetry;
    Innov8HWMap hwmap;
    LinearOpMode opMode;

    Launcher launcher;


    public Elephant(Telemetry telemetry, HardwareMap hwmap, LinearOpMode opMode) {
        this.telemetry = telemetry;
        this.hwmap = new Innov8HWMap(hwmap, opMode);
        this.opMode = opMode;

        launcher = new Launcher(this.telemetry, this.hwmap, this.opMode);

    }



    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Log.d("Sleepy time", "Sleep failed");

        }
    }
    public void teleop(Gamepad gamepad1, Gamepad gamepad2) {
        double minSpeed = -1;
        double maxSpeed = 1;
        Log.d("TeleopCheck","Running teleop");
        while (this.opMode.opModeIsActive()) {
            Log.d("TeleopCheck","In Teleop while loop");
            //wait 5.6 seconds before shoot to give warmup time

            launcher.teleopUpdate(gamepad1,gamepad2,minSpeed,maxSpeed);
            telemetry.update();
        }
    }
    double speed = 0.8;

    public void testLauncher(){
        while (opMode.opModeIsActive()){
            this.hwmap.launcher.setPower(0.5);
        }
    }


}