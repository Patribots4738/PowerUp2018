package autonomous;

// this is any point on the field, it can be the robot's location or a destination 

public class Position {
	private double x, y, theta;
	
	public Position(double x, double y, double theta) {
		this.x = x;
		this.y = y;
		this.theta = theta;
	}
	
	public Position(double x, double y) {
		this(x, y, 0);
	}
	
	public Position() {
		this(0,0,0);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getTheta() {
		return this.theta;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
}
