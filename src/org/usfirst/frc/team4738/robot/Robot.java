package org.usfirst.frc.team4738.robot;

import autonomous.Autonomous;
import autonomous.Smashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import enums.XboxButtons;
import utils.MovingAverage;
import vision.Camera;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.Timer;
import wrapper.ToggleButton;
import wrapper.XboxController;
import org.usfirst.frc.team4738.robot.RobotPosition;

public class Robot extends IterativeRobot {
	Gamepad gamepad;
	XboxController xbox;
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
		 robitPos = new RobotPosition(0 , 1 , 2 , 3 , 1 , 18.5 );//19.75 * 76/74.87255859375
		 autonomous = new Autonomous(drive, robitPos);
		 
		 xbox = new XboxController(1);
		 gamepad = new Gamepad(0);
		 cam.startCamera();
	}

	@Override
	public void autonomousInit() {
			autonomous.reset();
	}

	MovingAverage left = new MovingAverage(250), right = new MovingAverage(250);
	
	@Override
	public void autonomousPeriodic() {
		//autonomous.ITSALIVE();
		drive.linearTank(1, 1);
		System.out.println("left = " + left.average(robitPos.encoderL.getSpeed()));
		System.out.println("right = " + right.average(robitPos.encoderR.getSpeed()));
		
	}
	

	double speedMultiplier = .75;
	double direction = 1;
	@Override
	public void teleopPeriodic() {
		if(xbox.getButtonDown(XboxButtons.B)) {
			direction *= -1;
		}
		
		drive.parabolicArcade(xbox.getRightStick().getX(), xbox.getLeftStick().getY() * direction, speedMultiplier);
		robitPos.updateAnglePos();
		
		if(xbox.getToggle(XboxButtons.A)){
			speedMultiplier = .75;
		}else{
			speedMultiplier = .5;
		};
		
		elevator.setLift(-gamepad.getAxis(1));
		elevator.setArms(gamepad.getButton(0));
		winch.set(gamepad.getButton(2), gamepad.getButton(1));
	}
	

	@Override
	public void testPeriodic() {
	
	}
}