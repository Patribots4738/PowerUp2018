package autonomous;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Encoder;


public class Position {
	Gyro gyro;
	
	private double x, y, theta;

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
