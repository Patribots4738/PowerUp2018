package wrapper;

import edu.wpi.first.wpilibj.AnalogGyro;

public class Gyro {
	public AnalogGyro gyro;
	MovingAverage average;
	
	public double conversionFactor = -90d / 137d;

	public Gyro(int port) {
		// gyro = new ADXRS450_Gyro(Port.kMXP);
		gyro = new AnalogGyro(0);
		gyro.reset();
		average = new MovingAverage(10);
		gyro.setSensitivity(.0011);
	}

	public double getAngle() {
		double angle = gyro.getAngle() * conversionFactor;
		// return angle;
		//angle = angle % 360;
		return (average.average(angle)); 
	}
	
	public void reset() {
		gyro.reset();
	}
}