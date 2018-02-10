<<<<<<< HEAD
<<<<<<< HEAD
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
		System.out.print("the delta angle is: " + deltaAngle(a, b) + "  ");
	}
}
=======
package autonomous;

public class Trigulator {

	// this finds the distance in a straight line between two points, use this as
	// the "distance" input for the move command in MoveCommands
	public static double distance(Position a, Position b) {
		double x = a.getX() - b.getX(), y = a.getY() - b.getY();
		//System.out.println("the distance is: " + (Math.sqrt((Math.pow((x), 2)) + (Math.pow((y), 2)))));
		return Math.sqrt((Math.pow((x), 2)) + (Math.pow((y), 2)));

	}

	// this finds the angle of a right triangle formed by two points
	public static double angle(Position a, Position b) {
		double x = b.getX() - a.getX(), y = b.getY() - a.getY();
	//	System.out.println("the Angle is: " + Math.toDegrees((Math.atan2(x, y))));
		return Math.toDegrees(Math.atan2(x, y));
	}
	
	public static double deltaAngle(Position a, Position b) {
		double angle = angle(a, b);
		
		return angle - a.getTheta();
	}
	
	
	
	
	public static void angleTest(Position a , Position b) {
		System.out.print("the angle is: " + deltaAngle(a, b) + "  ");
	}
}
>>>>>>> 1b23ae31dc1bd6f5c252f5e1881d54bb5c874b65
=======
package autonomous;

public class Trigulator {

	// this finds the distance in a straight line between two points, use this as
	// the "distance" input for the move command in MoveCommands
	public static double distance(Position a, Position b) {
		double x = a.getX() - b.getX(), y = a.getY() - b.getY();
		//System.out.println("the distance is: " + (Math.sqrt((Math.pow((x), 2)) + (Math.pow((y), 2)))));
		return Math.sqrt((Math.pow((x), 2)) + (Math.pow((y), 2)));

	}

	// this finds the angle of a right triangle formed by two points
	public static double angle(Position a, Position b) {
		double x = b.getX() - a.getX(), y = b.getY() - a.getY();
	//	System.out.println("the Angle is: " + Math.toDegrees((Math.atan2(x, y))));
		return Math.toDegrees(Math.atan2(x, y));
	}
	
	public static double deltaAngle(Position a, Position b) {
		double angle = angle(a, b);
		
		return angle - a.getTheta();
	}
	
	
	
	
	public static void angleTest(Position a , Position b) {
		System.out.print("the angle is: " + deltaAngle(a, b) + "  ");
	}
}
>>>>>>> 1b23ae31dc1bd6f5c252f5e1881d54bb5c874b65
