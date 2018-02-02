package autonomous;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class moveCommands {
//alec stop leaving early
// fuq oofff
VictorSP rightMotor1, rightMotor2, leftMotor1, leftMotor2;
Encoder encoder1, encoder2;
Gyro gyro;


	public void move(double distance, double speed) {
	/*	rightMotor1.set(((speed)/100));
		rightMotor2.set(((speed)/100));
		leftMotor1.set(((speed)/100)); // may need to invert left motor sign, depending on how nice build is.
		leftMotor2.set(((speed)/100));
	*/
		move(distance,((speed)/100));
	}
	
	public void rotate(double finaltheta, double speed) {
		rotate(finaltheta, ((speed)/100));
	}
}