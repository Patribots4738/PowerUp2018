package wrapper;

public class Encoder {
	private final double ClicksPerRotation = 2048;
	public edu.wpi.first.wpilibj.Encoder encoder;
	private double radius, circumference, conversionFactor;
	
	public Encoder(int port1, int port2){
		encoder = new edu.wpi.first.wpilibj.Encoder(port1, port2);
		//encoder.setDistancePerPulse(0.0001);
	}
	
	public Encoder(int port1, int port2, double radius){
		this(port1, port2);
		circumference = radius * 2 * Math.PI;
		conversionFactor = ClicksPerRotation / 360;
	}
	
	public double getDistance(){
		return circumference * (encoder.getDistance() / ClicksPerRotation);
	}
	
	public double getSpeed(){
		return circumference * (encoder.getRate() / ClicksPerRotation);
	}
	
	public double getAngle(){
		double clicks = encoder.getDistance();
		clicks = (Math.abs(clicks / ClicksPerRotation) - (int)(Math.abs(clicks / ClicksPerRotation)));
		return (clicks * ClicksPerRotation) / conversionFactor;
	}
	
	public void reset(){
		encoder.reset();
	}
}
