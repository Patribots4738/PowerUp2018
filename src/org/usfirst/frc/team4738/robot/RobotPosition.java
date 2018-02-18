package org.usfirst.frc.team4738.robot;

import autonomous.Position;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;
import autonomous.Smashboard;
import edu.wpi.first.wpilibj.AnalogInput;

public class RobotPosition extends Position {

	Timer timer;
	Encoder encoderL;
	Encoder encoderR;
	Gyro gyro;
	

	public RobotPosition(int encoderLeftPort1, int encoderLeftPort2, int encoderRightPort1, int encoderRightPort2, int gyroPort, double circumfrence ) {
		this.encoderL = new Encoder(encoderLeftPort1, encoderLeftPort2, circumfrence);
		this.encoderR = new Encoder(encoderRightPort1, encoderRightPort2, circumfrence);
		this.timer = new Timer();
		this.gyro = new Gyro(gyroPort);
		
	}

	public void updateAnglePos() {
		double deltaTimer = timer.getDeltaTime() / 1000;
		double deltaTheta = ((encoderR.encoder.getRate() / Encoder.ClicksPerRotation) - (encoderL.encoder.getRate() / Encoder.ClicksPerRotation)) / 2;
		deltaTheta = deltaTheta / 195 * 360;
		double calcR = -(encoderR.getSpeed() + encoderL.getSpeed()) / 2;

		this.setTheta(this.getTheta() + deltaTheta);

		double deltaYPos = calcR * Math.cos(Math.toRadians(this.getTheta())) * deltaTimer;
		double deltaXPos = calcR * Math.sin(Math.toRadians(this.getTheta())) * deltaTimer;

		this.setX(this.getX() + deltaXPos);
		this.setY(this.getY() + deltaYPos);

		Smashboard.sendRobotPos(this);
		
	}

	// this tells the robot where it is
	public void updatePos() {
		double deltaTime = timer.getDeltaTime();
		this.setY(this.getY() + ((encoderL.getSpeed() * (deltaTime / 1000)) * Math.cos(0)));
		this.setX(this.getX() + ((encoderL.getSpeed() * (deltaTime / 1000)) * Math.sin(0)));
		Smashboard.sendRobotPos(this);
	}

	public void reset(double offset) {
		setX(offset);
		setY(19);
		setTheta(0);
		gyro.reset();
		encoderR.reset();
		encoderL.reset();
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		this.setTheta(gyro.getAngle());
		Smashboard.sendRobotPos(this);
	}

	public void angleTest() {
		System.out.println("the gyro angle is: " + gyro.getAngle());
	}

	public void encoderTest() {
		encoderL.encoderTest();
	}

}
