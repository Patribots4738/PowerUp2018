
package autonomous;

public class Trigulator {

	// this finds the distance in a straight line between two points, use this as
	// the "distance" input for the move command in MoveCommands
	public static double distance(Position a, Position b) {
		double x = b.getX() - a.getX(), y = b.getY() - a.getY();
		return Math.sqrt((Math.pow((x), 2)) + (Math.pow((y), 2)));
	}

	// this finds the angle of a right triangle formed by two points
	public static double angle(Position a, Position b) {
		double x = b.getX() - a.getX(), y = b.getY() - a.getY();
		return Math.toDegrees(Math.atan2(x, y));
	}

	public static double deltaAngle(Position a, Position b) {
		double angle = angle(a, b);
		return angle - a.getTheta();
	}

	public static void angleTest(Position a, Position b) {
<<<<<<< HEAD
<<<<<<< HEAD
		System.out.println("the delta angle is: " + deltaAngle(a, b));
=======
		System.out.print("the delta angle is: " + deltaAngle(a, b) + "  ");
>>>>>>> 74a321d8aafe0bfe4a00143cc13e8a0bbe9fd04d
=======
		System.out.print("the delta angle is: " + deltaAngle(a, b) + "  ");
>>>>>>> 74a321d8aafe0bfe4a00143cc13e8a0bbe9fd04d
	}
}
