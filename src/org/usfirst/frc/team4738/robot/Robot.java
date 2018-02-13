package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.ToggleButton;
import wrapper.XboxController;

public class Robot extends IterativeRobot {
	Gamepad gamepad = new Gamepad(0);
	XboxController xbox = new XboxController(1);
	Compressor compressor = new Compressor(0);
	Drive drive;
	Climber winch;
	Elevator elevator;
	//Autonomous autonomous;
	
	@Override
	public void robotInit() {
		 drive = new Drive(2, 3);
		 winch = new Climber(0);
		 elevator = new Elevator(1, 1, 0);
		 //this.autonomous = new Autonomous(drive);
		// autonomous.reset();
	}

	@Override
	public void autonomousInit() {
	//	autonomous.reset();
	
	}

	@Override
	public void autonomousPeriodic() {
		//autonomous.ITSALIVE();
	}
	

	@Override
	public void teleopPeriodic() {
		drive.parabolicArcade(xbox.getAxis(4), xbox.getAxis(1));
		elevator.setLift(gamepad.getAxis(1));
		elevator.setArms(gamepad.getButton(0));
		winch.set(gamepad.getButton(2), gamepad.getButton(1));
	}

	@Override
	public void testPeriodic() {
		
	}
}