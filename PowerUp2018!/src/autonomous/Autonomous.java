package autonomous;

import autonomous.MoveCommands;
import wrapper.Drive;
import wrapper.Encoder;
import wrapper.Gyro;
import wrapper.Timer;


public class Autonomous {
	
	
	// these coordinates are for when the switch
	// side we want to go to is on the right
	// for left switch side just make the 66s (and only the 66s) negative

	// these are for when we are in the middle or when the switch is on the same
	// side
	Position straightSwitch[] = { new Position(66, 130), new Position(66, 140) };
	// these are (shockingly enough) for when we have to go around the switch to get
	// to our side
	Position goingAround[] = { new Position(100, 210), new Position(66, 210), new Position(66, 196) };

	Position destPos = new Position(0 , 200), // we need to have it get the destPos from the smashboard
			robitPos = new Position();
	
	
	MoveCommands move;

	Gyro gyro;
	Encoder encoderL;
	Encoder encoderR;
	Timer timer;

	public Autonomous(Drive drive) {
		move = new MoveCommands(drive);	
		this.encoderL =  new Encoder(0 , 1, 3 );
		this.encoderR = new Encoder(2, 3 ,3);
		this.gyro = new Gyro(0);
		this.timer = new Timer();
	}
	
	public void reset() {
		robitPos.setX(0);
		robitPos.setY(0);
		robitPos.setTheta(0);
	}
	
	// this makes the robot move where we want it to, and then tells it that its
	// where we told it to go
	public void ITSALIVE() {
		
		 
		//move.rotate(Trigulator.deltaAngle(robitPos, destPos), gyro.getAngle(), 0.75);
		//if (robitPos.getTheta() == Trigulator.angle(robitPos, destPos)) {
			move.move(Trigulator.distance(robitPos, destPos), 0.25);
			updatePos();
			System.out.println("the robots y coord is: " + robitPos.getY() + "\nthe robots x coord is: " + robitPos.getX());
		//}
		//updateAngle();
	}

	// this tells the robot where it is
	public void updatePos() {
		//double encoderSpeedAverage = (encoderL.getSpeed() + encoderR.getSpeed()) / 2;
		double deltaTime = timer.getDeltaTime();
		robitPos.setY(robitPos.getY() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.cos(0)));
		robitPos.setX(robitPos.getX() + ((-encoderL.getSpeed() * (deltaTime / 1000)) * Math.sin(0)));
	}

	// this tells the robot where it's facing
	public void updateAngle() {
		robitPos.setTheta(gyro.getAngle());
	}
}