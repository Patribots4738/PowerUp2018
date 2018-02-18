package autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Smashboard {

	public static double smashboardHeight = 323.38 / 2d;

	public static void sendRobotPos(Position pos) {
		String data = (pos.getX() + smashboardHeight) + "," + pos.getY() + "," + pos.getTheta();
		SmartDashboard.putString("position", data);
	}
	
	public static void sendDestPos(Position pos) {
		String data = (pos.getX() + smashboardHeight) + "," + pos.getY() + "," + pos.getTheta();
		SmartDashboard.putString("destination", data);
	}
	public static Position getRobotStartPos(){
		double startPos = SmartDashboard.getNumber("start", 0);
		Position robotPos = new Position(115 * startPos, 19);
		if (startPos == 0) {
			robotPos.setX(5);
		}
		return robotPos;
		
	}
}
