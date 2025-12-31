package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.LED;
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
    //Sideflap
    private DcMotor rubberBandIntake;
    private Servo Gate;
    private DcMotorEx flyWheel;
    //intake1
    private DcMotor surgicalTubingIntake;

    private LED led_green_flywheel;
    private LED led_red_flywheel;

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
    private boolean isFlyWheelAtCorrectVelocity(){
        double flyWheelVelocity = flyWheel.getVelocity();

        if (flyWheelVelocity <=1520 && flyWheelVelocity > 1480 ){
            return true;
        }
        return false;
    }
    private boolean isGateOpenAtCorrectVelocity(){
        boolean isGateOpen = false;
        
        while(!isFlyWheelAtCorrectVelocity()){
            led_red_flywheel.on();
            led_green_flywheel.off();
            sleep(1000);
        }
        led_red_flywheel.off();
        led_green_flywheel.on();
            
        Gate.setPosition(POSITION_OPEN);
        isGateOpen = true;
        return isGateOpen;
    }

    private void rubberBandIntakeRollIn(){
        rubberBandIntake.setPower(-1);
    }
    private void surgicalTubingIntakeRollIn(){
        surgicalTubingIntake.setPower(1);
    }
    private void rubberBandIntakeRollOut(){
        rubberBandIntake.setPower(1);
    }
    private void surgicalTubingIntakeRollOut(){
        surgicalTubingIntake.setPower(-1);
    }
    private void rubberBandIntakeStop(){
        rubberBandIntake.setPower(0);
    }
    private void surgicalTubingIntakeStop(){
        surgicalTubingIntake.setPower(0);
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
        isGateOpenAtCorrectVelocity();

        //reverse intakes
        surgicalTubingIntake.setPower(-1);
        rubberBandIntake.setPower(1);

        sleep(300);
        //stop intakes

        surgicalTubingIntake.setPower(0);
        rubberBandIntake.setPower(0);

        sleep(200);

        //start intakes
        if(isGateOpenAtCorrectVelocity()){
            surgicalTubingIntake.setPower(1);
            rubberBandIntake.setPower(-1);
        }

        sleep(500);

        surgicalTubingIntake.setPower(0);
        rubberBandIntake.setPower(0);

        sleep(2000);
        if(isGateOpenAtCorrectVelocity()) {
            surgicalTubingIntake.setPower(1);
            rubberBandIntake.setPower(-1);
        }
        sleep(500);

        surgicalTubingIntake.setPower(0);
        rubberBandIntake.setPower(0);

        sleep(2000);

        if(isGateOpenAtCorrectVelocity()) {
            surgicalTubingIntake.setPower(1);
            rubberBandIntake.setPower(-1);
        }

        sleep(2000);

        surgicalTubingIntake.setPower(0);
        rubberBandIntake.setPower(0);

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
        surgicalTubingIntake = hardwareMap.get(DcMotor.class, "intake1");
        rubberBandIntake = hardwareMap.get(DcMotor.class, "RightFlap");
        Gate = hardwareMap.get(Servo.class, "Gate");
        led_red_flywheel = hardwareMap.get(LED.class, "led_red_flywheel");
        led_green_flywheel = hardwareMap.get(LED.class, "led_green_flywheel");
        led_red_flywheel.off();
        led_green_flywheel.off();

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

            moveToStartFromBlueWall();

            shootThreeBalls();

            moveOutsideShootingZoneForBlueWall();
            ((DcMotorEx) flyWheel).setVelocity(0);
            Gate.setPosition(POSITION_CLOSE);
            telemetry.update();
        }
    }
}
