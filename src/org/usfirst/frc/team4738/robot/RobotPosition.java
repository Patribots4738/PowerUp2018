package org.usfirst.frc.team4738.robot;

import autonomous.Position;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;
import autonomous.Smashboard;

public class RobotPosition extends Position {

	Timer timer;
	Encoder encoderL;
	Encoder encoderR;
	Gyro gyro;
	
	
	
	public RobotPosition(int encoderLeftPort1 , int encoderLeftPort2 ,int encoderRightPort1 , int encoderRightPort2, int gyroPort, int wheelRadius ) {
		this.encoderL = new Encoder(encoderLeftPort1, encoderLeftPort2, wheelRadius);
		this.encoderR = new Encoder(encoderRightPort1, encoderRightPort2, wheelRadius);
		this.timer = new Timer();
		this.gyro = new Gyro(gyroPort);
	}
	
	
	public void reset() {
		encoderL.reset();
		encoderR.reset();
		gyro.reset();
	}

	public void updateAnglePos() {
		double deltaTimer = timer.getDeltaTime() / 1000;
		double deltaTheta = (encoderR.getSpeed() - encoderL.getSpeed()) / 2;
		double calcY = (encoderR.getSpeed() + encoderL.getSpeed()) / 2;

		this.setTheta(this.getTheta() + deltaTheta);

		double deltaYPos = calcY * Math.sin(this.getTheta()) * deltaTimer;
		double deltaXPos = calcY * Math.cos(this.getTheta()) * deltaTimer;

		this.setX(this.getX() + deltaXPos);
		this.setY(this.getY() + deltaYPos);
		
		Smashboard.sendRobotPos(this);
	}

	// this tells the robot where it is
	public void updatePos() {
		// double encoderSpeedAverage = (encoderL.getSpeed() + encoderR.getSpeed()) / 2;
		double deltaTime = timer.getDeltaTime();
		this.setY(this.getY() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.cos(0)));
		this.setX(this.getX() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.sin(0)));
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		this.setTheta(gyro.getAngle());
		System.out.print("the gyro angle is: " + gyro.getAngle() + "  ");
	}
}
