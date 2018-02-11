package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Spark;

public class Climber {
	Spark winch;
	
	public Climber(int port){
		winch = new Spark(port);
}
	
	public void set(boolean up, boolean down){
		if (up == true){
			winch.set(.5);
		}else if (down == true){
			winch.set(-.5);
		}
	}
}