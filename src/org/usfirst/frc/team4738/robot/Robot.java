package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import vision.Camera;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.Timer;
import wrapper.ToggleButton;
import wrapper.XboxController;

public class Robot extends IterativeRobot {
	Gamepad gamepad = new Gamepad(0);
	XboxController xbox = new XboxController(1);
	Compressor compressor = new Compressor(0);
	Drive drive;
	Climber winch;
	Elevator elevator;
	Timer timer;
	Camera cam = new Camera();

	@Override
	public void robotInit() {
		 drive = new Drive(2, 3);
		 winch = new Climber(0);
		 elevator = new Elevator(1, 0, 1);
		 timer = new Timer();
	  	 cam.startCamera();
	   //cam.detectObjects();
	   //cam.enableObjectDetection(focalLength, actualHeight, FOV, erode_size, dialate_size, upper, lower);	
	}

	@Override
	public void autonomousInit() {
	
	}

	@Override
	public void autonomousPeriodic() {
		
	}
	

	
	@Override
	public void teleopPeriodic() {
		//drive.parabolicArcade((-xbox.getAxis(4) * speedMultiplier), xbox.getAxis(1) * speedMultiplier); used with speedMultiplier
		drive.parabolicArcade((-xbox.getAxis(4)), xbox.getAxis(1), .75);
		//drive.linearArcade(-xbox.getLeftStick().getY(), xbox.getRightStick().getX());
		
	/*	if(xbox.getToggle(5)){
			speedMultiplier = .75;
		}else{
			speedMultiplier = .5;
		}
		*/
		//drive.speedCap(xbox.getToggle(5), .75);
		elevator.setLift(gamepad.getAxis(1));
		elevator.setArms(gamepad.getButton(0));
		winch.set(gamepad.getButton(2), gamepad.getButton(1));
		
	/*	if(timer.wait(105 * 1000)){
			xbox.setRumble(RumbleType.kRightRumble, 1);
			xbox.setRumble(RumbleType.kLeftRumble, 1);
			*/
	
		if(xbox.getToggle(3)){
			drive.parabolicArcade((-xbox.getAxis(4)), xbox.getAxis(1) * -1, .75);
		}
	}
	

	@Override
	public void testPeriodic() {
	
	}
}
