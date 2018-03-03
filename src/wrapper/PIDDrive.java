package wrapper;

public class PIDDrive {
	
	PIDMotor left, right;
	
	public PIDDrive(PIDMotor left, PIDMotor right) {
		this.right = right;
		this.left = left;
	}
	
	public void tank(double left, double right) {
		this.right.set(right);
		this.left.set(left);
	}
	
	public void parabolicTank(double left, double right, double speedMultiplier) {
		this.right.set(right * Math.abs(right) * speedMultiplier);
		this.left.set(left * Math.abs(left) * speedMultiplier);
	}
	
	public void arcade(double x, double y) {
		left.set(y + x);
		right.set(y - x);
	}
	
	public void parabolicArcade(double x, double y, double speedMultiplier) {
		left.set(((y * Math.abs(y)) + (x * Math.abs(y))) * speedMultiplier);
		right.set(((y * Math.abs(y)) - (x * Math.abs(y))) * speedMultiplier);
	}

}
