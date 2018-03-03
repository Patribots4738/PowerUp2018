package org.usfirst.frc.team4738.robot;

import autonomous.Position;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;
import autonomous.Smashboard;

public class RobotPosition extends Position {

	Timer timer;
	public Encoder encoderL;
	public Encoder encoderR;
	Gyro gyro;
	

	public RobotPosition(int encoderLeftPort1, int encoderLeftPort2, int encoderRightPort1, int encoderRightPort2, int gyroPort, double circumfrence ) {
		this.encoderL = new Encoder(encoderLeftPort1, encoderLeftPort2, circumfrence);
		this.encoderR = new Encoder(encoderRightPort1, encoderRightPort2, circumfrence);
		this.timer = new Timer();
		this.gyro = new Gyro(gyroPort);
		
	}

	public void updateAnglePos() {
		double deltaTimer = timer.getDeltaTime() / 1000;
		double deltaTheta = (encoderL.getDeltaDistance() - encoderR.getDeltaDistance()) / 2;
		deltaTheta = deltaTheta / 195 * 360;
		double calcR = (encoderL.getDeltaDistance() + encoderR.getDeltaDistance()) / 2;

		//this.setTheta(this.getTheta() + deltaTheta);
		this.setTheta(gyro.getAngle());
		
		double deltaYPos = calcR * Math.cos(Math.toRadians(this.getTheta()));
		double deltaXPos = calcR * Math.sin(Math.toRadians(this.getTheta()));

		this.setX(this.getX() + deltaXPos);
		this.setY(this.getY() + deltaYPos);

		Smashboard.sendRobotPos(this);
		
	}

	// this tells the robot where it is
	public void updatePos() {
		double encoderAverage = ( -encoderR.getSpeed() + encoderL.getSpeed() ) /2; 
		double deltaTime = timer.getDeltaTime();
		this.setY(this.getY() + ((encoderAverage * (deltaTime / 1000)) * Math.cos(this.getTheta())));
		this.setX(this.getX() + ((encoderAverage * (deltaTime / 1000)) * Math.sin(this.getTheta())));
		Smashboard.sendRobotPos(this);
	}

	public void reset(Position startPos) {
		this.setX(startPos.getX());
		this.setY(startPos.getY());
		this.setTheta(startPos.getTheta());
		gyro.reset();
		encoderR.reset();
		encoderL.reset();
		timer.reset();
	}
	
	public void zeroReset() {
		setX(0);
		setY(0);
		setTheta(0);
		gyro.reset();
		encoderR.reset();
		encoderL.reset();
		timer.reset();
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		this.setTheta(gyro.getAngle());
		Smashboard.sendRobotPos(this);
	}
	
	public boolean isMoving() {
		return (encoderL.getSpeed() + encoderR.getSpeed()) / 2 > .5;
	}

}
