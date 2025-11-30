package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="auto")
public class Auto extends LinearOpMode {

    private DcMotor FrontLeft;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor BackRight;
    private DcMotor RightFlap;
    private Servo Gate;
    private DcMotor flyWheel;
    private DcMotor intake1;
    
    private boolean servoAtPosition1 = false; 
    private boolean prevButtonState = false;
  
    private final double POSITION_1 = 1; 
    private final double POSITION_2 = 0;
    

    @Override
    public void runOpMode() {

        FrontLeft  = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft   = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight  = hardwareMap.get(DcMotor.class, "BackRight");
        flyWheel = hardwareMap.get(DcMotor.class, "flywheelv1");
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        RightFlap = hardwareMap.get(DcMotor.class, "RightFlap");
        Gate = hardwareMap.get(Servo.class, "Gate");

        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        Gate.setPosition(POSITION_1);
        servoAtPosition1 = true;
        

        waitForStart();

        if (opModeIsActive()) {

            
            FrontLeft.setPower(0.5);
            BackLeft.setPower(0.5);
            FrontRight.setPower(0.5);
            BackRight.setPower(0.5);

            sleep(500); // <- change it if you want (ms)

            // turn left
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            
            // start spinning flywheel
            flyWheel.setPower(1);
            
            sleep(1000);
            
            FrontRight.setPower(0);
            BackRight.setPower(0);
            
            // open gate
            Gate.setPosition(POSITION_2);
            
            sleep(1000);
            
            // launch more balls
            intake1.setPower(0.5);
            RightFlap.setPower(0.5);
            
            sleep(1000);
            
            // stop flywheel
            flyWheel.setPower(0);
            
            FrontRight.setPower(-0.5);
            BackRight.setPower(-0.5);
            
            sleep(500);
            
            FrontLeft.setPower(-0.5);
            BackLeft.setPower(-0.5);
            
            
        }
    }
}
