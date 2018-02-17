package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4738.robot.Arms;
import wrapper.Timer;

public class Elevator {
	Arms arms;
	Spark lift;
	
	
	double elevatorSpeed = 1, elevatorPosition = 0;
	Timer timer;
	
	public Elevator(int port, int openPort, int closePort){
		lift = new Spark(port);
		arms = new Arms(openPort, closePort);
		timer = new Timer();
	}
	
	public void setArms(boolean button){
		arms.set(button);	
	}
	
	public void setLift(double value){
		lift.set(value);
		elevatorPosition += value * elevatorSpeed * timer.getDeltaTime();
		elevatorPosition = Math.min(1, Math.max(0, elevatorPosition));
		SmartDashboard.putNumber("elevator", elevatorPosition);
	}
}
