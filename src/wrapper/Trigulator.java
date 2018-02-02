package autonomous;


import autonomous.MoveCommands;
import edu.wpi.first.wpilibj.DriverStation;

public class Trigulator {

	static double destX, destY, moveX, moveY, distance;
	static double destXCoord, destYCoord;
	static Position position = new Position();
	static MoveCommands move = new MoveCommands();

	public static void main(String[] args) {
		// multiply all values in inches by conversionFactor to get them in encoder units

		// this is the distance (in inches) from the robot to the centerline of the
		// field
		double conversionFactor = 128 / (6 * Math.PI);
		double startPosX = 18;
		double rightX = startPosX * conversionFactor;
		double leftX = -(rightX);

		double normalSpeed = 75.0;
		double rammingSpeed = 90.0;
		// set as "Left" , "Middle" , "Right" depending on where the robot starts

		String startPos = "Right";
		if (startPos.equals("Right")) {
			position.setX(rightX);
			position.setY(0);
			position.setTheta(0);
		} else if (startPos.equals("Middle")) {
			position.setX(0);
			position.setY(0);
			position.setTheta(0);
		} else if (startPos.equals("Left")) {
			position.setX(leftX);
			position.setY(0);
			position.setTheta(0);
		}
		String switchSide;
		switchSide = DriverStation.getInstance().getGameSpecificMessage();
		if (switchSide.charAt(0) == 'L' && startPos.equals("Left")) {
			destXCoord = -(66 * conversionFactor); 
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord = -(66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), rammingSpeed);
		}

		if (switchSide.charAt(0) == 'L' && startPos.equals("Right")) {
			destXCoord = (100 * conversionFactor);
			destYCoord = (210 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord = -(66 * conversionFactor);
			destYCoord = (210 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord =-(66 * conversionFactor) ;
			destYCoord =(196 * conversionFactor) ;
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), rammingSpeed);
		}
		if (switchSide.charAt(0) == 'R' && startPos.equals("Right")) {
			destXCoord = (66 * conversionFactor);
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord = (66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), rammingSpeed);
		}
		if (switchSide.charAt(0) == 'R' && startPos.equals("Left")) {
			//EDIT THIS DATA TO MATCH THE COORDINATES ON GRID
			destXCoord = -(100 * conversionFactor);
			destYCoord = (210 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord = (66 * conversionFactor);
			destYCoord = (210 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord =(66 * conversionFactor) ;
			destYCoord =(196 * conversionFactor) ;
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), rammingSpeed);
		
		}
		if (switchSide.charAt(0) == 'R' && startPos.equals("Middle")) {
			destXCoord = (66 * conversionFactor);
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord = (66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), rammingSpeed);
		}
		if (switchSide.charAt(0) == 'L' && startPos.equals("Middle")) {
			destXCoord = -(66 * conversionFactor);
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), normalSpeed);
			destXCoord = -(66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), normalSpeed);
			move.move(distance(destXCoord, destYCoord), rammingSpeed);
		}
		
	}

	public static double distance(double x, double y) {
		destX = x;  // finds the distance to destination in a straight line
		destY = y;
		moveX = destX - position.getX();
		moveY = destY - position.getY();
		distance = Math.sqrt(((Math.pow((moveX), 2)) + (Math.pow((moveY), 2))));
		return distance;
	}

	public static double angle(double x, double y) {
		destX = x; // finds the angle the robot needs to rotate before it can move
		destY = y;
		moveX = destX - position.getX();
		moveY = destY - position.getY();
		double degrees = moveY / moveX;
		double finalTheta = Math.atan(degrees) - position.getTheta();
		return finalTheta;
	}
}