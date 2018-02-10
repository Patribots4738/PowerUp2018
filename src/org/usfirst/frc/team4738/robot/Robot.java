/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.Drive;
import wrapper.Gamepad;
import wrapper.XboxController;
import autonomous.Autonomous;


public class Robot extends IterativeRobot {
	Drive drive;
	Autonomous autonomous;
	XboxController pad = new XboxController(0);
	

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		this.drive = new Drive(6, 7, 9, 8);
		this.autonomous = new Autonomous(drive);
		autonomous.reset();
	}

	@Override
	public void autonomousInit() {
		autonomous.reset();
	
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		autonomous.ITSALIVE();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		drive.linearArcade(pad.getLeftStick().getX(), 0);
		System.out.println(pad.getLeftStick().getX());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
