package wrapper;

import java.util.*;
import edu.wpi.first.wpilibj.*;

/**
 * @author Everyone
 */
public class Drive {

	public ArrayList<VictorSP /* Spark */> motors = new ArrayList<>();

	/**
	 * This is a constructor you idiot - <3 Jacob
	 * 
	 * @author Stephen Barrack (who forgot what a constructor was)
	 * @param ports
	 *            switches between left and right motors for each input
	 */
	public Drive(int... ports) {
		for (int port : ports) {
			VictorSP /* Spark */ motor = new VictorSP /* Spark */(port);
			motors.add(motor);
		}
	}

	/**
	 * @param xAxis
	 *            x-axis of the joystick
	 * @param yAxis
	 *            y-axis of the joystick
	 */
	public void linearArcade(double xAxis, double yAxis) {
		for (int i = 0; i < motors.size(); i++) {
			if (i % 2 == 0) {
				motors.get(i).set((yAxis + xAxis));
			} else {
				motors.get(i).set(-(yAxis - xAxis));
			}
		}
	}

	/**
	 * @param leftStick
	 *            y-axis for left joystick
	 * @param rightStick
	 *            y-axis for left joystick
	 */
	public void linearTank(double leftStick, double rightStick) {
		for (int i = 0; i < motors.size(); i++) {
			if (i % 2 == 0) {
				motors.get(i).set(leftStick);
			} else {
				motors.get(i).set(rightStick);
			}
		}
	}

	/**
	 * @param leftStick
	 *            y-axis for left joystick
	 * @param rightStick
	 *            x-axis for right joystick
	 */
	public void parabolicTank(double leftStick, double rightStick, double speedMultiplier) {
		for (int i = 0; i < motors.size(); i++) {
			if (i % 2 == 0) {
				motors.get(i).set(leftStick * Math.abs(leftStick) * speedMultiplier);
			} else {
				motors.get(i).set(rightStick * Math.abs(rightStick) * speedMultiplier);
			}
		}
	}

	/**
	 * @param xAxis
	 *            x-axis for the joystick
	 * @param yAxis
	 *            y-axis for the joystick
	 */
	public void parabolicArcade(double xAxis, double yAxis, double speedMultiplier) {
		for (int i = 0; i < motors.size(); i++) {
			if (i % 2 == 0) {
				motors.get(i).set(-((yAxis + xAxis)) * Math.abs(yAxis + xAxis) * speedMultiplier);
			} else {
				motors.get(i).set(((yAxis - xAxis)) * Math.abs((yAxis - xAxis)) * speedMultiplier);
			}
		}
	}
}
