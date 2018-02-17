package autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Smashboard {

	public static double smashboardHeight = 323.38 / 2d;

	public static void sendRobotPos(Position pos) {
		String data = (pos.getX() + smashboardHeight) + "," + pos.getY() + "," + pos.getTheta();
		SmartDashboard.putString("position", data);
	}
}
