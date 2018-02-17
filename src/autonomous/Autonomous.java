package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Timer;
import org.usfirst.frc.team4738.robot.*;

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
	Position autonomousTestingStuff[] = { /* this if for 45 degree turns */ new Position(50, 50),
			/* this is for moving straight forward */ new Position(0, 150),
			/* this is for 90 degree turns */ new Position(50, 0),
			/* this is for when you don't want it to move or rotate */ new Position(0, 0),
			/* this is for testing sequencing */new Position(75, 0) };

	Position destPos = autonomousTestingStuff[2]; // we need to have it get the destPos from the smashboard
	RobotPosition robitPos = new RobotPosition(0, 1, 2, 3, 1, 19.75 * 76/74.87255859375);

	MoveCommands move;
	Timer timer;

	int pointOnPath = 0;

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);
		reset();
	}

	public void reset() {
		robitPos.reset();
	}

	public void fullDebug() {
		System.out.println("The delta angle is: " + Trigulator.deltaAngle(robitPos, destPos));
		//System.out.println("the distance is: " + Trigulator.distance(robitPos, destPos));
		System.out.println("the robots angle is: " + robitPos.getTheta());
		//robitPos.encoderTest();
		//System.out.println("the move direction is: " + move.moveDirection(robitPos,destPos));
		robitPos.angleTest();
		//robitPos.encoderTest();
		//System.out.println("");
	}

	// this makes the robot move where we want it to, and then tells it that it's
	// where we told it to go
	public void ITSALIVE() {

		robitPos.updateAngle();
		fullDebug();
	//  move.moveRotate(robitPos, destPos, 0.25);
	//	move.move(Trigulator.distance(robitPos, destPos), 0.25, move.moveDirection(robitPos, destPos));
		move.rotate(Trigulator.deltaAngle(robitPos, destPos), 0.5);
	}
}