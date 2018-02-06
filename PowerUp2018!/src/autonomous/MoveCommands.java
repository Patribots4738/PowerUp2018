package autonomous;

import wrapper.Drive;
import autonomous.Autonomous;

public class MoveCommands {
	Drive drive;              	
	double distTillDecceleration = 48.0 ;
	//You have to make sure that one of these has finished before you run the next one, or everything dies
	
	public MoveCommands(Drive drive) {
		this.drive = drive;
	}
	
	
	// this makes the robot move, but only in a straight line
	public void move(double distance, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, distance / distTillDecceleration)) * speedMultiplier;
		drive.linearArcade( speed, -speed);
	}

	public double distanceToSpeed(double x) {
		return  ((Math.sin((Math.PI * 0.5) *(Math.sqrt((Math.abs(x)))))) * (x / (Math.abs(x))));
	}

	// this makes the robot rotate a certain amount, in degrees
	public void rotate(double theta, double gyroAngle, double speed) {
		if (gyroAngle < theta) {
			drive.linearTank(speed, (speed));
		}
		
		if(gyroAngle > theta) {
			drive.linearTank(-(speed), -speed);
		}
		
	}
	
	public void stop(){
		drive.linearTank(0 , 0);
	}

}