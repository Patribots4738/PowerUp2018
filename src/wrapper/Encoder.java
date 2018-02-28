package wrapper;

public class Encoder {
	public static final double ClicksPerRotation = Constants.CLICKS_PER_ROTATION;
	public edu.wpi.first.wpilibj.Encoder encoder;
	private double circumference, conversionFactor;

	public Encoder(int port1, int port2) {
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
		// encoder.setDistancePerPulse(0.0001);
	}

	public Encoder(int port1, int port2, double circumfrence) {
		this(port1, port2);
		this.circumference = circumfrence;
		conversionFactor = ClicksPerRotation / 360;
	}

	public double getDistance() {
		return circumference * (encoder.getDistance() / ClicksPerRotation);
	}

	public double getSpeed() {
		return circumference * (encoder.getRate() / ClicksPerRotation);
	}

	public double getAngle() {
		double clicks = encoder.getDistance();
		clicks %= ClicksPerRotation;
		return (clicks * ClicksPerRotation) / conversionFactor;
	}
	
	double lastDist = 0;
	public double getDeltaDistance(){
		double deltaDistance = encoder.getDistance() - lastDist;
		lastDist = encoder.getDistance();
		
		return deltaDistance;
	}

	public void reset() {
		encoder.reset();
	}
}
