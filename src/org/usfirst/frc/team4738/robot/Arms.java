package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Arms {
	Solenoid open, close;
	
		public Arms(int openPort, int closePort){
			open = new Solenoid(openPort);
			close = new Solenoid(closePort);
		}
		public void set(boolean state){
			open.set(state);
			close.set(!state);
		}
	}

