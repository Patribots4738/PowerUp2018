package wrapper;

public class PIDController {

	public double kP, kI, kD;
	
	Timer timer;
	
	public PIDController(double kP, double kI, double kD) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		
		timer = new Timer();
	}
	
	public double getLocalDeltaTime() {
		return timer.getDeltaTime();
	}
	
	public double calcP(double input, double setPoint) {
		double error = setPoint - input;
		return error;
	}
	
	double integral = 0; 
	public double calcI(double error, double deltaTime) {
		integral += error * deltaTime;
		return integral;
	}
	
	double lastError = 0;
	public double calcD(double error, double deltaTime) {
		double derivitive = (error - lastError) / deltaTime;
		lastError = error;
		return derivitive;
	}
	
	public double calcPI(double input, double setPoint, double deltaTime) {
		double error = calcP(input, setPoint);
		return error * kP + calcI(error, deltaTime) * kI;
	}
	
	public double calcPID(double input, double setPoint, double deltaTime) {
		double error = calcP(input, setPoint);
		return error * kP + calcI(error, deltaTime) * kI + calcD(error, deltaTime) * kD;
	}
	
	
	
}
