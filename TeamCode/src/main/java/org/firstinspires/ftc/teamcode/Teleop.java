package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name = "Innov8Teleoping", group = "Linear Opmode")

public class Teleop extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Elephant elephant = new Elephant(telemetry, hardwareMap, this);

        waitForStart();
        runtime.reset();
//kok
        elephant.teleop(gamepad1, gamepad2);
    }
}