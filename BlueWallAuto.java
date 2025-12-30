package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name="BlueWallAuto")
public class BlueWallAuto extends LinearOpMode {

    private DcMotor FrontLeft;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor BackRight;
    private DcMotor RightFlap;
    private Servo Gate;
    private DcMotorEx flyWheel;
    private DcMotor intake1;
    
    private boolean launchSequence = false;
    private boolean servoAtPosition1 = false;
    private boolean prevButtonState = false;

    private final double POSITION_CLOSE = 1;
    private final double POSITION_OPEN = 0;
    
    private void moveToStartFromBlueWall() {
        
        ((DcMotorEx) flyWheel).setVelocity(1500);
        
        ((DcMotorEx) FrontLeft).setVelocity(2050);
        ((DcMotorEx) BackLeft).setVelocity(2050);
        ((DcMotorEx) FrontRight).setVelocity(2050);
        ((DcMotorEx) BackRight).setVelocity(2050);
        
        sleep(1400);
        
        ((DcMotorEx) FrontLeft).setVelocity(00);
        ((DcMotorEx) BackLeft).setVelocity(00);
        ((DcMotorEx) FrontRight).setVelocity(00);
        ((DcMotorEx) BackRight).setVelocity(00);
        
        sleep(300);
        
        ((DcMotorEx) FrontLeft).setVelocity(1025);
        ((DcMotorEx) BackLeft).setVelocity(1025);
        ((DcMotorEx) FrontRight).setVelocity(-1025);
        ((DcMotorEx) BackRight).setVelocity(-1025);
        
        sleep(700);
        
        ((DcMotorEx) FrontLeft).setVelocity(00);
        ((DcMotorEx) BackLeft).setVelocity(00);
        ((DcMotorEx) FrontRight).setVelocity(00);
        ((DcMotorEx) BackRight).setVelocity(00);
    }
    
    private void initiateLaunchSequence(){
        
        launchSequence = true;
        //  intake1.setPower(1);
        //  RightFlap.setPower(-1);
        //  sleep(1000);
         double flyWheelVelocity = flyWheel.getVelocity();
        
         if (flyWheelVelocity <=1520 && flyWheelVelocity > 1480 && launchSequence){
                    Gate.setPosition(POSITION_OPEN);
         }
         else{
             Gate.setPosition(POSITION_CLOSE);  
         }
        
    } 
    
    private void rubberBandIntakeRollIn(){
        RightFlap.setPower(-1);
    }
    private void surgicalTubingIntakeRollIn(){
        intake1.setPower(1);
    }
    private void rubberBandIntakeRollOut(){
        RightFlap.setPower(1);
    }
    private void surgicalTubingIntakeRollOut(){
        intake1.setPower(-1);
    }
    private void rubberBandIntakeStop(){
        RightFlap.setPower(0);
    }
    private void surgicalTubingIntakeStop(){
        intake1.setPower(0);
    }

    private void runIntakesInAndStopWithPause(int firstSleep, int secondSleep){
        rubberBandIntakeRollIn();
        surgicalTubingIntakeRollIn();
        sleep(firstSleep);
        surgicalTubingIntakeStop();
        rubberBandIntakeStop();
        sleep(secondSleep);
    }
    
    private void shootThreeBalls() {
        Gate.setPosition(POSITION_OPEN);
        intake1.setPower(-1);
        RightFlap.setPower(0.80);
        
        sleep(310);

        intake1.setPower(0);
        RightFlap.setPower(0);
        
        sleep(200);
                
        intake1.setPower(1);
        RightFlap.setPower(-1);

        sleep(500);
        
        intake1.setPower(0);
        RightFlap.setPower(0);

        sleep(2000);

        intake1.setPower(1);
        RightFlap.setPower(-1);

        sleep(500);
        
        intake1.setPower(0);
        RightFlap.setPower(0);
        
        sleep(2000);
        
        intake1.setPower(1);
        RightFlap.setPower(-1);

        sleep(2000);
        
        intake1.setPower(0);
        RightFlap.setPower(0);
        
        flyWheel.setPower(0);
        // Gate.setPosition(POSITION_OPEN);
        
        // // telemetry.addData("running ShootThreeBalls log1", ((DcMotorEx) flyWheel).getVelocity());
        // // telemetry.update();
        // // surgicalTubingIntakeRollOut();
        // // sleep(5000);
        // telemetry.addData("on top of intake", ((DcMotorEx) flyWheel).getVelocity());
        // telemetry.update();
        
        // intake1.setPower(-1);
        // // RightFlap.setPower(1);
        // sleep(2000);
        // telemetry.addData("below intake", ((DcMotorEx) flyWheel).getVelocity());
        // telemetry.update();
        // telemetry.addData("running ShootThreeBalls log2", ((DcMotorEx) flyWheel).getVelocity());
        // telemetry.update();
        // rubberBandIntakeStop();
        
        // telemetry.addData("running ShootThreeBalls log3", ((DcMotorEx) flyWheel).getVelocity());
        // telemetry.update();
        // sleep(510);
        // surgicalTubingIntakeStop();
        
        // telemetry.addData("running ShootThreeBalls log4", ((DcMotorEx) flyWheel).getVelocity());
        // telemetry.update();
        // rubberBandIntakeStop(); 
        
        // telemetry.addData("running ShootThreeBalls log5", ((DcMotorEx) flyWheel).getVelocity());
        // telemetry.update();
        // sleep(200);
                
        // runIntakesInAndStopWithPause(500,2000);

        // runIntakesInAndStopWithPause(500,2000);

        // runIntakesInAndStopWithPause(2000,0);
        
        // flyWheel.setPower(0);
    }
    
    private void moveOutsideShootingZoneForBlueWall() {
        ((DcMotorEx) FrontLeft).setVelocity(-1525);
        ((DcMotorEx) BackLeft).setVelocity(-1525);
        ((DcMotorEx) FrontRight).setVelocity(-1525);
        ((DcMotorEx) BackRight).setVelocity(-1525);

        sleep(300);
        ((DcMotorEx) FrontLeft).setVelocity(00);
        ((DcMotorEx) BackLeft).setVelocity(00);
        ((DcMotorEx) FrontRight).setVelocity(00);
        ((DcMotorEx) BackRight).setVelocity(00);

        ((DcMotorEx) flyWheel).setVelocity(0);
    }
    
    public final void autoInit(){
        FrontLeft  = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft   = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight  = hardwareMap.get(DcMotor.class, "BackRight");
        flyWheel = hardwareMap.get(DcMotorEx.class,"flywheelv1");
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        RightFlap = hardwareMap.get(DcMotor.class, "RightFlap");
        Gate = hardwareMap.get(Servo.class, "Gate");
        
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        flyWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        
        
        
        
    }
    
    @Override
    public void runOpMode() {
    
        autoInit();
        

        Gate.setPosition(POSITION_CLOSE);
        servoAtPosition1 = true;
        waitForStart();

        if (opModeIsActive()) {

            //start spinning flywheel
            flyWheel.setPower(98.4);
            moveToStartFromBlueWall();

            shootThreeBalls();

            moveOutsideShootingZoneForBlueWall();
            ((DcMotorEx) flyWheel).setVelocity(0);
            Gate.setPosition(POSITION_CLOSE);
            telemetry.update();
        }
    }
}
