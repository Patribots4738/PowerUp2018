package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.Arms;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.ToggleButton;
import wrapper.XboxController;

public class Robot extends IterativeRobot {
	Gamepad gamepad = new Gamepad(0);
	XboxController xbox = new XboxController(1);
	ToggleButton toggledState = new ToggleButton();
	ToggleButton holdButton = new ToggleButton();
	Compressor compressor = new Compressor(0);
	Drive drive;
	Climber winch;
	Elevator elevator;

	@Override
	public void robotInit() {
		 drive = new Drive();
		 winch = new Climber(0);
		 elevator = new Elevator(1, 0, 1);
	}

	@Override
	public void autonomousInit() {
	
	}

	@Override
	public void autonomousPeriodic() {
		
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