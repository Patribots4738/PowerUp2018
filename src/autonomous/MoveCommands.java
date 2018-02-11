
package autonomous;

import wrapper.Drive;

public class MoveCommands {
	Drive drive;
	double distTillDecceleration = 25.0;
	double thetaTillDecceleration = 10.0;

	// You have to make sure that one of these has finished before you run the next
	// one, or everything dies

	public MoveCommands(Drive drive) {
		this.drive = drive;
	}

	// this makes the robot move, but only in a straight line
	public void move(double distance, double speedMultiplier, double direction) {
		double speed = distanceToSpeed(Math.min(1, distance / distTillDecceleration), speedMultiplier);
		drive.linearArcade(0, (direction)*speed);
	}

	public double moveDirection(Position a , Position b) {
		return Math.signum(1 - Trigulator.deltaAngle(a, b));
	}
	
	public double distanceToSpeed(double x, double s) {
		return (((Math.sin((Math.PI * 0.5) * (Math.sqrt(Math.pow((Math.abs(x)), (2d/3d))))))) * ((Math.abs(x) / x))) * s;
	}

	// this makes the robot rotate a certain amount, in degrees
	public void rotate(double theta, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, theta / thetaTillDecceleration), speedMultiplier);
		//double speedTest = (Math.min(1, (theta / thetaTillDecceleration))) * speedMultiplier;
		drive.linearArcade(speed, 0);
	}
	
	public void moveRotate(Position a, Position b, double speedMultiplier) {
		double x = distanceToSpeed(Math.min(1, Trigulator.deltaAngle(a, b) / thetaTillDecceleration), speedMultiplier);
		double y = distanceToSpeed(Math.min(1, Trigulator.distance(a, b) / distTillDecceleration), speedMultiplier);
		drive.linearArcade(x, y * moveDirection(a, b));
	}

	public void stop() {
		drive.linearArcade(0, 0);
	}


}