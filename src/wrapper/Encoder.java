package wrapper;

public class Encoder {
	public static final double ClicksPerRotation = 2048;// 256
	public edu.wpi.first.wpilibj.Encoder encoder;
	private double circumference, conversionFactor;

	public Encoder(int port1, int port2) {
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
		// encoder.setDistancePerPulse(0.0001);
	}

	public Encoder(int port1, int port2, double circumfrence) {
		this(port1, port2);
		this.circumference = circumfrence ;//radius * 2 * Math.PI;
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
	
	public double getDeltaDistance(){
		//TODO :: Write this function
		return 0;
	}

	public void reset() {
		encoder.reset();
	}
	
	public void encoderTest() {
		System.out.println("the distance is: " +  this.getDistance());
	}
}
