
package autonomous;

import wrapper.Drive;

public class MoveCommands {
	double rotateSpeed;
	double straightSpeed;
	public Drive drive;
	double distTillDecceleration = 40.0;
	double thetaTillDecceleration = 60.0;

	
	// You have to make sure that one of these has finished before you run the next
	// one, or everything dies

	public MoveCommands(Drive drive) {
		this.drive = drive;
	}

	// this makes the robot move, but only in a straight line
	public void move(double distance, double speedMultiplier, double direction) {
		double speed = (Math.min(1, distanceToSpeed(Math.max(-1, distance / distTillDecceleration)))) * speedMultiplier;
		drive.linearArcade(0, speed * direction);
		//drive.linearTank(speed * direction, (direction) * speed);
	}

	public double moveDirection(Position a, Position b) {
		return Math.signum(90 - Trigulator.deltaAngle(a, b));
	}

	public double distanceToSpeed(double x) {
		return Math.sin((Math.PI / 4) * Math.sqrt(Math.pow(Math.abs(x), (2.6 / 5)))) * (1.2 * x / Math.abs(x));
		//return x;
	}

	// this makes the robot rotate a certain amount, in degrees
	public void rotate(double theta, double speedMultiplier) {
		double speed = Math.min(1, distanceToSpeed(Math.max(-1, theta / thetaTillDecceleration))) * speedMultiplier;
		//System.out.println("the motor speed is: " + speed);
		drive.linearArcade(speed, 0);
		//drive.linearTank(speed, speed);
	}
	
	public void moveRotate(Position a, Position b, double speedMultiplier) {
		double x = distanceToSpeed(Math.min(1, Trigulator.deltaAngle(a, b) / thetaTillDecceleration) );
		double y = distanceToSpeed(Math.min(1, Trigulator.distance(a, b) / distTillDecceleration));
		drive.linearArcade(x / 2, y * moveDirection(a, b));
	}

	public void stop() {
		drive.linearArcade(0, 0);
	}
	
	public void move(double distance, double direction , String uselessValue) {
		straightSpeed = ((Math.min(1, distanceToSpeed(Math.max(-1, distance / distTillDecceleration))))) * direction;
	}
	
	public void rotate(double theta, String uselssValue) {
		rotateSpeed = (Math.min(1, distanceToSpeed(Math.max(-1, theta / thetaTillDecceleration))));
	}

	public void updateMove(double speedMultiplier) {
		drive.parabolicArcade(rotateSpeed, straightSpeed, speedMultiplier);
	}
}