package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Timer;
import org.usfirst.frc.team4738.robot.*;

public class Autonomous {
	
	int pointOnPath = 0;
	double RAMMINGSPEED = -0.9;
	double normalSpeed = 0.5;
	
	// DO NOT CTRL-SHIFT-F THIS DOCUMENT!!!!!!

	// these coordinates are for when the switch
	// side we want to go to is on the right
	// for left switch side just make the 66s (and only the 66s) negative
	// these are for when we are in the middle or when the switch is on the same
	// side
	Position straightSwitch[] = { new Position(115, 168, normalSpeed), new Position(66, 168, RAMMINGSPEED) };

	// these are (shockingly enough) for when we have to go around the switch to get
	// to our side
	Position goingAround[] = { new Position(115, 210, normalSpeed), new Position(-100, 210, normalSpeed), new Position(-100, 168, normalSpeed), new Position(-66,168,RAMMINGSPEED) };
	
	Position destPos =straightSwitch[pointOnPath]; // we need to have it get the destPos from the smashboard
	RobotPosition robitPos = new RobotPosition(0, 1, 2, 3, 1, 19.75 * 76/74.87255859375);

	MoveCommands move;
	Timer timer;

	

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);
		reset();
	}
 
	public void reset() {
		//115 for right starting position, -115 for left starting position and 0 for middle (if drive team did it right....)
		robitPos.reset(115);
	}

	public void fullDebug() {
		//System.out.println("The delta angle is: " + Trigulator.deltaAngle(robitPos, destPos));
		//System.out.println("the absolute angle is: " + Trigulator.angle(robitPos, destPos) );
		//System.out.println("the distance is: " + Trigulator.distance(robitPos, destPos));
		//System.out.println("the robots angle is: " + robitPos.getTheta());
		//robitPos.encoderTest();
		//System.out.println("the move direction is: " + move.moveDirection(robitPos,destPos));
		//robitPos.angleTest();
		//robitPos.encoderTest();
		//System.out.println("");
	}

	// this makes the robot move where we want it to, and then tells it that it's
	// where we told it to go
	public void ITSALIVE() {
		double distance = Trigulator.distance(robitPos, destPos);
		double deltaAngle = Trigulator.deltaAngle(robitPos, destPos);
		Smashboard.sendDestPos(destPos);
		robitPos.updateAngle();
		//fullDebug();
		move.rotate(deltaAngle, destPos.getTheta());
		
		if(Math.abs(deltaAngle) <= 0.1) {
			robitPos.updatePos();
			move.move(distance, destPos.getTheta(), move.moveDirection(robitPos, destPos));
			if(distance <= 0.1) {
				if (pointOnPath < straightSwitch.length) {
					pointOnPath++;
					destPos = straightSwitch[pointOnPath];
				}
			}
		}
	}
}