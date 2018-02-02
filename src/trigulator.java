package autonomous;


import autonomous.moveCommands;
import edu.wpi.first.wpilibj.DriverStation;

public class trigulator {

	static double destX, destY, moveX, moveY, distance;
	static double destXCoord, destYCoord;
	static position position = new position();
	static moveCommands move = new moveCommands();

	public static void main(String[] args) {
		// multiply all values in inches by conversionFactor to get them in encoder units

		// this is the distance (in inches) from the robot to the centerline of the
		// field
		double conversionFactor = 128 / (6 * Math.PI);
		double startPosX = 18;
		double rightX = startPosX * conversionFactor;
		double leftX = -(rightX);

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
			destXCoord = -(66 * conversionFactor); // team is
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 75.0);
			destXCoord = -(66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 90.0);
		}

		if (switchSide.charAt(0) == 'L' && startPos.equals("Right")) {

		}
		if (switchSide.charAt(0) == 'R' && startPos.equals("Right")) {
			destXCoord = (66 * conversionFactor);
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 75.0);
			destXCoord = (66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 90.0);
		}
		if (switchSide.charAt(0) == 'R' && startPos.equals("Left")) {
				//Zaq has big gay
		}
		if (switchSide.charAt(0) == 'R' && startPos.equals("Middle")) {
			destXCoord = (66 * conversionFactor);
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 75.0);
			destXCoord = (66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 90.0);
		}
		if (switchSide.charAt(0) == 'L' && startPos.equals("Middle")) {
			destXCoord = -(66 * conversionFactor);
			destYCoord = (130 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 75.0);
			destXCoord = -(66 * conversionFactor);
			destYCoord = (139 * conversionFactor);
			move.rotate(angle(destXCoord, destYCoord), 75.0);
			move.move(distance(destXCoord, destYCoord), 90.0);
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
		destX = x;
		destY = y;
		moveX = destX - position.getX();
		moveY = destY - position.getY();
		double degrees = moveY / moveX;
		double finalTheta = Math.atan(degrees) - position.getTheta();
		return finalTheta;
	}
}