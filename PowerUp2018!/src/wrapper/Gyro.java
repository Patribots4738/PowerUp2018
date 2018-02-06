package wrapper;
import edu.wpi.first.wpilibj.AnalogGyro;

 public class Gyro {
	public AnalogGyro gyro;
	MovingAverage average;
	double offset= 0;
	
	public Gyro(int port){
		//gyro = new ADXRS450_Gyro(Port.kMXP);
		gyro = new AnalogGyro(0);
		gyro.reset();
		average = new MovingAverage(5);
	}
	
	public double getAngle(){
		double angle = gyro.getAngle();
		
		//return angle;
		average.average(angle);
		angle =(Math.abs(angle / 360) - (int) (Math.abs(angle / 360))); //ASK JACOB what the "int" portion of the code does
		return average.average(angle * 360);
		
	}
	
	public double getOffsetAngle(){
		return getAngle() + offset;
	}
	
	public void reset(){
		offset += getAngle();
		gyro.reset();
	}
}
