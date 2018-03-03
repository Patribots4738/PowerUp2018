package org.usfirst.frc.team4738.robot;

import autonomous.Autonomous;
import autonomous.Smashboard;
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
import org.usfirst.frc.team4738.robot.RobotPosition;

public class Robot extends IterativeRobot {
	Gamepad gamepad = new Gamepad(0);
	XboxController xbox = new XboxController(1);
	Compressor compressor = new Compressor(0);
	Drive drive;
	Climber winch;
	Elevator elevator;
	Timer timer;
	Autonomous autonomous;
	RobotPosition robitPos;
	Camera cam = new Camera();

	@Override
	public void robotInit() {
		 drive = new Drive(2,3);
		 winch = new Climber(0);
		 elevator = new Elevator(1, 0, 1);
		 timer = new Timer();
		 robitPos = new RobotPosition(0 , 1 , 2 , 3 , 1 , 19.75 * 76/74.87255859375);//18.5
		 autonomous = new Autonomous(drive, robitPos);
		 cam.startCamera();
		// cam.detectObjects();
		// cam.enableObjectDetection(focalLength, actualHeight, FOV, erode_size, dialate_size, upper, lower);	
	}

	@Override
	public void autonomousInit() {
			autonomous.reset();
	}

	@Override
	public void autonomousPeriodic() {
		autonomous.ITSALIVE();
	}
	

	
	@Override
	public void teleopPeriodic() {
		drive.parabolicArcade(xbox.getLeftStick().getX(), xbox.getLeftStick().getY(), .75);
		robitPos.updateAnglePos();
/*		
		if(xbox.getToggle(5)){
			speedMultiplier = .75;
		}else{
			speedMultiplier = .5;
		}
*/	
	//	drive.speedCap(xbox.getToggle(5), .75);
		elevator.setLift(gamepad.getAxis(1));
		elevator.setArms(gamepad.getButton(0));
		winch.set(gamepad.getButton(2), gamepad.getButton(1));
		
		if(timer.wait(105 * 1000)){
			xbox.setRumble(RumbleType.kRightRumble, 1);
			xbox.setRumble(RumbleType.kLeftRumble, 1);
	}
	}

	@Override
	public void testPeriodic() {
	
	}
}