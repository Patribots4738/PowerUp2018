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
<<<<<<< HEAD

	public double getAngle() {
		double angle = gyro.getAngle() * conversionFactor;
		// return angle;
		//angle = angle % 360;
		return (average.average(angle)); 

=======
	
	public double getAngle(){
		double angle = gyro.getAngle();
		
		//return angle;
		average.average(angle);
		angle =(Math.abs(angle / 360) - (int) (Math.abs(angle / 360))); //ASK JACOB what the "int" portion of the code does
		return average.average(angle * 360);
		
	}
	
	public double getOffsetAngle(){
		return getAngle() + offset;
>>>>>>> 1b23ae31dc1bd6f5c252f5e1881d54bb5c874b65
	}

	public void reset() {
		gyro.reset();
	}
}