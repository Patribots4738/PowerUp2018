package autonomous;

public class Trigulator {

	
	// this finds the distance in a straight line between two points, use this as the "distance" input for the move command in MoveCommands
	public static double distance(Position a, Position b) {
		double x = a.getX() - b.getX(), y = a.getY() - b.getY();
		return Math.sqrt((Math.pow((x), 2)) + (Math.pow((y), 2)));
	
	}

	// this finds the angle of a right triangle formed by two points
	public static double angle(Position a, Position b) {
		double x = a.getX() - b.getX(), y = a.getY() - b.getY();
		System.out.println("the angle is: " + Math.atan2(x, y));
		return Math.atan2(x, y);
		
	}

	
	// this finds the actual amount the robot needs to turn, use this as the "theta" input for the rotate command in MoveCommands
	public static double deltaAngle(Position a, Position b) {
		return (angle(a, b) - a.getTheta());

	}
}
