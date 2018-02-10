<<<<<<< HEAD
<<<<<<< HEAD
package autonomous;

import wrapper.Drive;

public class MoveCommands {
	Drive drive;
	double distTillDecceleration = 48.0;
	double thetaTillDecceleration = 10.0;

	// You have to make sure that one of these has finished before you run the next
	// one, or everything dies

	public double distanceToSpeed(double x, double speedMultiplier) {
		double t = 0.7; // this is the taughtness of the line
		return (x * (Math.pow(((Math.exp(1))), (Math.abs(x / t))))) * speedMultiplier; // this needs tweaking

	}

	public MoveCommands(Drive drive) {
		this.drive = drive;
	}

	// this makes the robot move, but only in a straight line
	public void move(double distance, double speedMultiplier , double direction) {
		double speed = distanceToSpeed(Math.min(1, distance / distTillDecceleration), speedMultiplier);
		drive.linearArcade(0, (direction) * speed);
	}
	
	public double moveDirection(Position a, Position b) {
		return Math.signum(1 - Trigulator.deltaAngle(a, b));
	}

	// this makes the robot rotate a certain amount, in degrees
	public void rotate(double theta, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, theta / thetaTillDecceleration), speedMultiplier);
		drive.linearArcade(speed, 0);
	}

	public void stop() {
		drive.linearArcade(0, 0);
	}

=======
package autonomous;

import wrapper.Drive;

public class MoveCommands {
	Drive drive;
	double distTillDecceleration = 48.0;
	double thetaTillDecceleration = 90.0;

	// You have to make sure that one of these has finished before you run the next
	// one, or everything dies

	public MoveCommands(Drive drive) {
		this.drive = drive;
	}

	// this makes the robot move, but only in a straight line
	public void move(double distance, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, distance / distTillDecceleration), speedMultiplier);
		drive.linearArcade(0, speed);
	}

	public double distanceToSpeed(double x, double s) {
		return (((Math.sin((Math.PI * 0.5) * (Math.sqrt(Math.pow((Math.abs(x)), (2d/3d))))))) * ((Math.abs(x) / x))) * s;
		//return (((x * x) + (0.11 / (s)) / 1.1 ) * ( x / (Math.abs(x)))) * s;
	}

	// this makes the robot rotate a certain amount, in degrees
	public void rotate(double theta, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, theta / thetaTillDecceleration), speedMultiplier);
		//double speedTest = (Math.min(1, (theta / thetaTillDecceleration))) * speedMultiplier;
		drive.linearArcade(speed, 0);
	}

	public void stop() {
		drive.linearArcade(0, 0);
	}

>>>>>>> 1b23ae31dc1bd6f5c252f5e1881d54bb5c874b65
=======
package autonomous;

import wrapper.Drive;

public class MoveCommands {
	Drive drive;
	double distTillDecceleration = 48.0;
	double thetaTillDecceleration = 90.0;

	// You have to make sure that one of these has finished before you run the next
	// one, or everything dies

	public MoveCommands(Drive drive) {
		this.drive = drive;
	}

	// this makes the robot move, but only in a straight line
	public void move(double distance, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, distance / distTillDecceleration), speedMultiplier);
		drive.linearArcade(0, speed);
	}

	public double distanceToSpeed(double x, double s) {
		return (((Math.sin((Math.PI * 0.5) * (Math.sqrt(Math.pow((Math.abs(x)), (2d/3d))))))) * ((Math.abs(x) / x))) * s;
		//return (((x * x) + (0.11 / (s)) / 1.1 ) * ( x / (Math.abs(x)))) * s;
	}

	// this makes the robot rotate a certain amount, in degrees
	public void rotate(double theta, double speedMultiplier) {
		double speed = distanceToSpeed(Math.min(1, theta / thetaTillDecceleration), speedMultiplier);
		//double speedTest = (Math.min(1, (theta / thetaTillDecceleration))) * speedMultiplier;
		drive.linearArcade(speed, 0);
	}

	public void stop() {
		drive.linearArcade(0, 0);
	}

>>>>>>> 1b23ae31dc1bd6f5c252f5e1881d54bb5c874b65
}