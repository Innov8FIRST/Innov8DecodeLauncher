package org.firstinspires.ftc.teamcode;

import static com.sun.tools.doclint.HtmlTag.BR;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

/* Defines hardware used in the robot
Not an opmode
first word in names lowercase, after that all first letters of words capitalized (camelback)
 */
public class Innov8HWMap {
    // Motors

    public DcMotor launcher = null;



    // Servos



    //CRServos
//    public CRServo intakeLeft = null;
//    public CRServo intakeRight = null;
    // Sensors

    public TouchSensor TouchSensor1 = null;
    //Webcam


    // IMU
    public BNO055IMU imu;

    // Defining servo position numbers/ranges


    //setting up variables for constructor
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();
    private LinearOpMode opMode;
    // Constructor
    public Innov8HWMap(HardwareMap ahwMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.hwMap = ahwMap;
        this.init(ahwMap);
    }

    // Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap) {

        // Define and initialize motors

        launcher = this.hwMap.get(DcMotor.class, "launcher");

        // Define and initialize servos


        // Define and initialize CRServos
//        intakeLeft = this.hwMap.get(CRServo.class,"intakeLeft");
//        intakeRight = this.hwMap.get(CRServo.class,"intakeRight");

        //Define and initialize sensors

        TouchSensor1 = this.hwMap.get(TouchSensor.class,"TouchSensor1");
        //define direction motors spin

        launcher.setDirection(DcMotor.Direction.REVERSE);

        //set servo starting position


        //define direction servos spin

        //define direction CRServos spin
//        intakeLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        intakeRight.setDirection(DcMotorSimple.Direction.FORWARD);

        // set all motors to 0 power on initialization


        // set all CRServo to 0 power on initialization


        // setting up encoders so you can use them to code motors

        //setting up webcam

        //setting up IMU
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        imu = this.hwMap.get(BNO055IMU.class, "imu");
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        this.imu.initialize(parameters);
        while(!this.opMode.isStopRequested() && imu.isGyroCalibrated()) {
            this.opMode.sleep(50);
            this.opMode.idle();
        }
    }

}