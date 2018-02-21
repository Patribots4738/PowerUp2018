package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Timer;
import org.usfirst.frc.team4738.robot.*;

public class Autonomous {
	
	int pointOnPath = 0;
	double RAMMINGSPEED = 0.9;
	double normalSpeed = 0.5;
	double safeSpeed = 0.4;
	double wheelCircumfrence = 19.75 * 76/74.87255859375;
	double slowSpeed = 0.3;
	int moveState = 0;
	Position rightStart = new Position(115, 19, normalSpeed);
	Position leftStart = new Position(-115, 19, normalSpeed);
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
	Position testing[] = {new Position(60, 0, normalSpeed) , new Position(60, 60, normalSpeed), new Position(0, 60 , normalSpeed), new Position(-10,0, normalSpeed) , new Position(-10 , 5 , 0)};
	Position backwardsTest[] = {new Position(0,  -170, normalSpeed)};
	Position destPos = backwardsTest[0]; // we need to have it get the destPos from the smashboard

	RobotPosition robitPos;
	MoveCommands move;
	Timer timer;

	

	public Autonomous(Drive drive , RobotPosition robitPos) {
		move = new MoveCommands(drive);
		this.robitPos = robitPos;
		reset();
	}
 
	public void reset() {
	//	robitPos.reset(rightStart);
		robitPos.zeroReset();
		pointOnPath = 0;
	}

	
	public void fullDebug() {
		System.out.println("the delta angle is: " + Trigulator.deltaAngle(robitPos, destPos));
		System.out.println("the distance is: " + Trigulator.distance(robitPos, destPos));
	//	System.out.println("the absolute angle is: " + Trigulator.angle(robitPos, destPos));
	//	robitPos.angleTest();
	//	System.out.println("the the point on path is: " + pointOnPath);
	//	System.out.println("the robitPos x is: " + robitPos.getX() + "\nthe robitPos y is: " + robitPos.getY() + "\nthe robitPos theta is: " + robitPos.getTheta() + "\n");
	//	System.out.println("the destPos X is: " + destPos.getX() + "the destPos y is: " + destPos.getY() );
	//	robitPos.encoderLTest();
	//	robitPos.encoderRTest();
		System.out.println("");
	}

	// this makes the robot move where we want it to, and then tells it that it's
		// where we told it to go
	public void ITSALIVE() {
/*
		Position switchSide = new Position(0, -150);
		if(Math.signum(switchSide.getY()) == Math.signum(robitPos.getY())) {
			robitPos.updateAnglePos();
			move.move(Trigulator.distance(robitPos, destPos), normalSpeed, move.moveDirection(robitPos, destPos));
		}
		if(Math.signum(switchSide.getY()) == Math.signum(robitPos.getY())) {
			robitPos.updateAnglePos();
			move.move(Trigulator.distance(robitPos, destPos), slowSpeed, move.moveDirection(robitPos, destPos));
		}
*/		
		
		
		fullDebug();
		robitPos.updateAnglePos();
		move.move(Trigulator.distance(robitPos, destPos), destPos.getTheta(), move.moveDirection(robitPos, destPos));
/*		
		if(pointOnPath >= testing.length) {
			System.out.println("Auto is over");
			move.stop();
			return;
		}
		
		robitPos.updateAnglePos();
		double distance = Trigulator.distance(robitPos, destPos);
		double deltaAngle = Trigulator.deltaAngle(robitPos, destPos);
		Smashboard.sendDestPos(destPos);
		Smashboard.sendRobotPos(robitPos);
		
		
	//	fullDebug();

		move.rotate(deltaAngle, destPos.getTheta());
		if(Math.abs(deltaAngle) < 7) {
			move.move(distance, destPos.getTheta(), move.moveDirection(robitPos, destPos));
			if(distance < 2) {
				if(pointOnPath < testing.length - 1) {
					pointOnPath++;
					destPos = testing[pointOnPath];
				}
			}
		}
		*/
	}
}