package wrapper;

import edu.wpi.first.wpilibj.*;

public class PIDMotor {
	
	public PIDController controller;
	public PWMSpeedController motorController;
	public Encoder encoder;
	
	public PIDMotor(PWMSpeedController motorController, Encoder encoder, PIDController controller, boolean isInverted) {
		this.motorController = motorController;
		this.encoder = encoder;
		this.controller = controller;
		motorController.setInverted(isInverted);
		
	}
	
	public void set(double speed) {
		motorController.set(speed + controller.calcP(encoder.getSpeed() / Constants.MAX_SPEED, speed));
	}

}
