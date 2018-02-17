package wrapper;

import edu.wpi.first.wpilibj.AnalogGyro;

public class Gyro {
	public AnalogGyro gyro;
	MovingAverage average;
	
	public double conversionFactor = 90d / 137d;

	public Gyro(int port) {
		// gyro = new ADXRS450_Gyro(Port.kMXP);
		gyro = new AnalogGyro(port);
		gyro.reset();
		average = new MovingAverage(5);
		gyro.setSensitivity(0.0011);
	}

	public double getAngle() {
		double angle = gyro.getAngle() * conversionFactor;
		//angle = angle % 360;
		return (average.average(angle));
	}
  
  public void reset() {
		average.reset();
		gyro.reset();
	}
}