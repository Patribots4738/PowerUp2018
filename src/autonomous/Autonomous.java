<<<<<<< HEAD

<<<<<<< HEAD
package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;
import autonomous.Smashboard;

public class Autonomous {

	// DO NOT CTRL-SHIFT-F THIS DOCUMENT!!!!!!

	// these coordinates are for when the switch
	// side we want to go to is on the right
	// for left switch side just make the 66s (and only the 66s) negative
	// these are for when we are in the middle or when the switch is on the same
	// side
	Position straightSwitch[] = { new Position(66, 130), new Position(66, 140) };

	// these are (shockingly enough) for when we have to go around the switch to get
	// to our side
	Position goingAround[] = { new Position(100, 210), new Position(66, 210), new Position(66, 196) };

	// and these are for testing the autonomous
	Position autonomousTestingStuff[] = { /* this if for 45 degree turns */new Position(50, 50),
			/* this is for moving straight forward */ new Position(0, 50),
			/* this is for 90 degree turns */ new Position(50, 0),
			/* this is for when you don't want it to move or rotate */ new Position(0, 0) };

	Position destPos = autonomousTestingStuff[2], // we need to have it get the destPos from the smashboard
			robitPos = new Position();

	MoveCommands move;

	Gyro gyro;
	Encoder encoderL;
	Encoder encoderR;
	Timer timer;

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);
		this.encoderL = new Encoder(0, 1, 3);
		this.encoderR = new Encoder(2, 3, 3);
		this.gyro = new Gyro(0);
		this.timer = new Timer();

		reset();
	}

	public void reset() {
		robitPos.setX(0);
		robitPos.setY(0);
		robitPos.setTheta(0);
		gyro.reset();
		encoderL.reset();
	}

	// this makes the robot move where we want it to, and then tells it that its
	// where we told it to go

	public void gyroTest() {
		System.out.println("the gyro angle is: " + gyro.getAngle() + "  ");
	}

	public void ITSALIVE() {

		// these commands will have the driver station give you values
		System.out.println("the distance is: " + Trigulator.distance(robitPos, destPos));
		Trigulator.angleTest(robitPos, destPos);
		System.out.println("the move direction is: " + move.moveDirection(robitPos, destPos));
		gyroTest();

		Smashboard.sendRobotPos(robitPos);
		if (encoderL.getSpeed() <= 0.5 && encoderL.getSpeed() >= -0.5) {
			updateAngle();
			move.rotate(Trigulator.deltaAngle(robitPos, destPos), 0.25);
		}
		if (encoderL.getSpeed() <= 0.5 && encoderL.getSpeed() >= -0.5 && Trigulator.deltaAngle(robitPos, destPos) <= 1 && Trigulator.deltaAngle(robitPos, destPos) >= -1) {
						
			move.move(Trigulator.distance(robitPos, destPos), 0.25, move.moveDirection(robitPos, destPos));
			updatePos();
		}

	}

	// this tells the robot where it is
	public void updatePos() {
		// double encoderSpeedAverage = (encoderL.getSpeed() + encoderR.getSpeed()) / 2;
		double deltaTime = timer.getDeltaTime();
		robitPos.setY(robitPos.getY() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.cos(0)));
		robitPos.setX(robitPos.getX() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.sin(0)));
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		robitPos.setTheta(gyro.getAngle());
=======
package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;

public class Autonomous {
	
	
	// DO NOT CTRL-SHIFT-F THIS DOCUMENT!!!!!!
	
	
	// these coordinates are for when the switch
	// side we want to go to is on the right
	// for left switch side just make the 66s (and only the 66s) negative
	// these are for when we are in the middle or when the switch is on the same
	// side
	Position straightSwitch[] = { new Position(66, 130), new Position(66, 140) };

	// these are (shockingly enough) for when we have to go around the switch to get
	// to our side
	Position goingAround[] = { new Position(100, 210), new Position(66, 210), new Position(66, 196) };

	
	//and these are for testing the autonomous
	Position autonomousTestingStuff[]= { /* this if for 45 degree turns*/new Position(50 , 50)
			, /* this is for moving straight forward*/ new Position( 0, 50 ) 
			, /* this is for 90 degree turns*/ new Position( 50 , 0) 
			,/* this is for when you don't want it to move or rotate */ new Position(0,0) };

	Position destPos = autonomousTestingStuff[2], // we need to have it get the destPos from the smashboard
			robitPos = new Position();

	MoveCommands move;

	Gyro gyro;
	Encoder encoderL;
	Encoder encoderR;
	Timer timer;

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);
		this.encoderL = new Encoder(0, 1, 3);
		this.encoderR = new Encoder(2, 3, 3);
		this.gyro = new Gyro(0);
		this.timer = new Timer();

		reset();
	}

	public void reset() {
		robitPos.setX(0);
		robitPos.setY(0);
		robitPos.setTheta(0);
		gyro.reset();
		encoderL.reset();
	}

	// this makes the robot move where we want it to, and then tells it that its
	// where we told it to go
	
	public void gyroTest() {
		System.out.print("the gyro angle is: " +gyro.getAngle() + "  ");
	}
	public void ITSALIVE() {
		
		updateAngle();
		//updatePos();
		Trigulator.angleTest(robitPos, destPos);
		
		gyroTest();
		System.out.print(Math.min(1, Trigulator.deltaAngle(robitPos, destPos) / 90) + "  ");
		System.out.println(Trigulator.deltaAngle(robitPos, destPos) / 90);

		move.rotate(Trigulator.deltaAngle(robitPos, destPos), 0.5);
		//System.out.println(Trigulator.deltaAngle(robitPos,  destPos));
		// System.out.println("Gyro " + robitPos.getTheta());
		// if (Math.abs(Trigulator.deltaAngle(robitPos, destPos)) <= Trigulator.angle(robitPos, destPos) +1 &&(Math.abs(Trigulator.deltaAngle(robitPos , destPos)) - 1) >= Trigulator.angle(robitPos, destPos) - 1) {
		// move.move(Trigulator.distance(robitPos, destPos), 0.25);
		// }
		
	}

	// this tells the robot where it is
	public void updatePos() {
		// double encoderSpeedAverage = (encoderL.getSpeed() + encoderR.getSpeed()) / 2;
		double deltaTime = timer.getDeltaTime();
		robitPos.setY(robitPos.getY() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.cos(0)));
		robitPos.setX(robitPos.getX() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.sin(0)));
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		robitPos.setTheta(gyro.getAngle());
>>>>>>> 74a321d8aafe0bfe4a00143cc13e8a0bbe9fd04d
=======

package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;

public class Autonomous {
	
	
	// DO NOT CTRL-SHIFT-F THIS DOCUMENT!!!!!!
	
	
	// these coordinates are for when the switch
	// side we want to go to is on the right
	// for left switch side just make the 66s (and only the 66s) negative
	// these are for when we are in the middle or when the switch is on the same
	// side
	Position straightSwitch[] = { new Position(66, 130), new Position(66, 140) };

	// these are (shockingly enough) for when we have to go around the switch to get
	// to our side
	Position goingAround[] = { new Position(100, 210), new Position(66, 210), new Position(66, 196) };

	
	//and these are for testing the autonomous
	Position autonomousTestingStuff[]= { /* this if for 45 degree turns*/new Position(50 , 50)
			, /* this is for moving straight forward*/ new Position( 0, 50 ) 
			, /* this is for 90 degree turns*/ new Position( 50 , 0) 
			,/* this is for when you don't want it to move or rotate */ new Position(0,0) };

	Position destPos = autonomousTestingStuff[2], // we need to have it get the destPos from the smashboard
			robitPos = new Position();

	MoveCommands move;

	Gyro gyro;
	Encoder encoderL;
	Encoder encoderR;
	Timer timer;

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);
		this.encoderL = new Encoder(0, 1, 3);
		this.encoderR = new Encoder(2, 3, 3);
		this.gyro = new Gyro(0);
		this.timer = new Timer();

		reset();
	}

	public void reset() {
		robitPos.setX(0);
		robitPos.setY(0);
		robitPos.setTheta(0);
		gyro.reset();
		encoderL.reset();
	}

	// this makes the robot move where we want it to, and then tells it that its
	// where we told it to go
	
	public void gyroTest() {
		System.out.print("the gyro angle is: " +gyro.getAngle() + "  ");
	}
	public void ITSALIVE() {
		
		updateAngle();
		//updatePos();
		Trigulator.angleTest(robitPos, destPos);
		
		gyroTest();
		System.out.print(Math.min(1, Trigulator.deltaAngle(robitPos, destPos) / 90) + "  ");
		System.out.println(Trigulator.deltaAngle(robitPos, destPos) / 90);

		move.rotate(Trigulator.deltaAngle(robitPos, destPos), 0.5);
		//System.out.println(Trigulator.deltaAngle(robitPos,  destPos));
		// System.out.println("Gyro " + robitPos.getTheta());
		// if (Math.abs(Trigulator.deltaAngle(robitPos, destPos)) <= Trigulator.angle(robitPos, destPos) +1 &&(Math.abs(Trigulator.deltaAngle(robitPos , destPos)) - 1) >= Trigulator.angle(robitPos, destPos) - 1) {
		// move.move(Trigulator.distance(robitPos, destPos), 0.25);
		// }
		
	}

	// this tells the robot where it is
	public void updatePos() {
		// double encoderSpeedAverage = (encoderL.getSpeed() + encoderR.getSpeed()) / 2;
		double deltaTime = timer.getDeltaTime();
		robitPos.setY(robitPos.getY() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.cos(0)));
		robitPos.setX(robitPos.getX() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.sin(0)));
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		robitPos.setTheta(gyro.getAngle());
>>>>>>> 74a321d8aafe0bfe4a00143cc13e8a0bbe9fd04d
	}
}