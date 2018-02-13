package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Encoder;
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
			/* this is for moving straight forward */ new Position(0, 50),
			/* this is for 90 degree turns */ new Position(50, 0),
			/* this is for when you don't want it to move or rotate */ new Position(0, 0) };

	Position destPos = autonomousTestingStuff[2]; // we need to have it get the destPos from the smashboard
	RobotPosition robitPos = new RobotPosition(0, 1, 2, 3 ,0 ,3);

	MoveCommands move;
	Encoder encoderL;
	Encoder encoderR;
	Timer timer;

	int pointOnPath = 0;

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);
		reset();
	}

	
	
	public void reset() {
		robitPos.setX(0);
		robitPos.setY(0);
		robitPos.setTheta(0);
		
	}

	// this makes the robot move where we want it to, and then tells it that its
	// where we told it to go
	public void ITSALIVE() {
		move.moveRotate(robitPos, destPos, 0.25);

		
		/*
		 * updateAngle(); move.rotate(Trigulator.deltaAngle(robitPos, destPos), 0.25);
		 * if(Math.abs(Trigulator.deltaAngle(robitPos, destPos)) < 0.5 &&
		 * Math.abs(encoderL.getSpeed()) < 0.5) { updatePos();
		 * move.move(Trigulator.distance(robitPos, destPos), 0.25,
		 * move.moveDirection(robitPos, destPos)); if(Trigulator.distance(robitPos,
		 * destPos) < 0.25d) { destPos = goingAround[++pointOnPath]; } }
		 */
		/*
		 * move.moveRotate(robitPos, destPos, .25); if(Trigulator.distance(robitPos,
		 * destPos) < 0.25){ destPos = goingAround[++pointOnPath]; }
		 */

		/*
		 * if ((encoderL.getSpeed() <= 0.5 && encoderL.getSpeed() >= -0.5) ) {
		 * updateAngle(); move.rotate(Trigulator.deltaAngle(robitPos, destPos), 0.25); }
		 * if (encoderL.getSpeed() <= 0.5 && encoderL.getSpeed() >= -0.5 &&
		 * Trigulator.deltaAngle(robitPos, destPos) <= 1 &&
		 * Trigulator.deltaAngle(robitPos, destPos) >= -1) { updatePos();
		 * move.move(Trigulator.distance(robitPos, destPos), 0.25,
		 * move.moveDirection(robitPos, destPos));
		 * 
		 * }
		 */
	}
}