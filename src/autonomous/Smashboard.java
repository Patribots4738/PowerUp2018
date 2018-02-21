package autonomous;

import edu.wpi.first.wpilibj.DriverStation;
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
	
	public static int getRobotStartPosInt(){
		return (int) Math.round(SmartDashboard.getNumber("start", 0));
	}

	// -1 for left, 1 for right
	public static int[] getSwitchPos(){
		String data = DriverStation.getInstance().getGameSpecificMessage();
		int[] returnData = new int[data.length()];
		for(int i = 0; i < data.length(); i++){
			if(data.charAt(i) == 'R'){
				returnData[i] = 1;
			} else if(data.charAt(i) == 'L'){
				returnData[i] = -1;
			}
		}
		return returnData;
	}

}
