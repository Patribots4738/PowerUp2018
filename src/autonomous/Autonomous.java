package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Timer;
import org.usfirst.frc.team4738.robot.*;

public class Autonomous {
	
	int pointOnPath = 0;
	double RAMMINGSPEED = -0.9;
	double normalSpeed = 0.5;
	double safeSpeed = 0.25;
	double wheelCircumfrence = 18.849;//19.75 * 76/74.87255859375;
	int moveState = 0;
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
	Position testing[] = {new Position(0, 30, safeSpeed) , new Position(30, 30, safeSpeed)  /*, new Position(30, 0 , safeSpeed) */, new Position(0,0, safeSpeed)};
	
	Position destPos = testing[pointOnPath]; // we need to have it get the destPos from the smashboard

	RobotPosition robitPos;
	MoveCommands move;
	Timer timer;

	

	public Autonomous(Drive drive , RobotPosition robitPos) {
		move = new MoveCommands(drive);
		this.robitPos = robitPos;
		reset();
	}
 
	public void reset() {
		//115 for right starting position, -115 for left starting position and 5 for middle (if drive team did it right....)  
		//robitPos.reset(115);
		moveState = 0;
		robitPos.zeroReset();
		pointOnPath = 0;
		destPos = testing[pointOnPath];
	}

	// this makes the robot move where we want it to, and then tells it that it's
	// where we told it to go

	
	public void ITSALIVE() {
		if(pointOnPath >= testing.length - 1) {
			return;
		}
		
		
		double distance = Trigulator.distance(robitPos, destPos);
		double deltaAngle = Trigulator.deltaAngle(robitPos, destPos);
		Smashboard.sendDestPos(destPos);
		//System.out.println("the delta angle is: " + deltaAngle);
		//System.out.println("the absolute angle is: " + Trigulator.angle(robitPos, destPos));
		Smashboard.sendRobotPos(robitPos);
		//System.out.println("the move state is: " + moveState);
		//System.out.println("the robitPos x is: " + robitPos.getX() + "\nthe robitPos y is: " + robitPos.getY() + "\nthe robitPos theta is: " + robitPos.getTheta() + "\n");
		
		robitPos.updateAnglePos();
		
		
		move.rotate(deltaAngle, destPos.getTheta());
		if(Math.abs(deltaAngle) < 1) {
			move.moveRotate(robitPos, destPos, destPos.getTheta());
			if(distance < 1) {
				if(pointOnPath < testing.length - 1) {
					pointOnPath++;
					destPos = testing[pointOnPath];
				}
			}
		}
/*		
		if(moveState == 0) {
		//	robitPos.angleTest();
			move.rotate(deltaAngle, destPos.getTheta());
		//	System.out.println(1);
			if(Math.abs(deltaAngle) < 12) {
				if(!robitPos.isMoving()) {
					moveState = 1;
		//			System.out.println("the move state is: " + moveState);
				}
			}
		}
		
		if(moveState == 1) {
			//robitPos.updateAnglePos();
		//	System.out.println("distance is: " + distance);
			move.move(distance, destPos.getTheta(), move.moveDirection(robitPos, destPos));
		//	System.out.println("2");
			if(distance < 5) {
				if(!robitPos.isMoving()) {
					moveState = 0;
					if(pointOnPath < testing.length) {
						pointOnPath++;
						destPos = testing[pointOnPath];
					}
				}
			}
		}
	*/
	}
}