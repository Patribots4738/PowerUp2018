package wrapper;

/**
 * Gotta have da 4matting! :)
 * @author Stephen (AKA: Barry)
 */
public class Constants {

	public static final int[]
	DIO_PORT={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25},
	RELAY_PORT={0,1,2,3},
	ANALOG_PORT={0,1,2,3},
	PWM_PORT={0,1,2,3,4,5,6,7,8,9},
	PCM_PORT ={0,1,2,3,4,5,6,7},
	CAN_ID= {0,1,2,3,4,5,6,7,8,9,10},
	DRIVER_STATION_PORT={0,1,2,3,4,5};
	
	public static final double 
		CLICKS_PER_ROTATION = 256,
		WHEEL_CIRCUMFERENCE = 19.75 * 76/74.87255859375,
		MAX_SPEED = 0,
		GYRO_CONVERSION_FACTOR = 90d / 137d,
		DISTANCE_TILL_DECELERATION = 70,
		THETA_TILL_DECELERATION = 60;
	
	public static final int
		LEFT_ENCODER_PORTS[] = {DIO_PORT[0], DIO_PORT[1]},
		RIGHT_ENCODER_PORTS[] = {DIO_PORT[2], DIO_PORT[3]},
		GYRO_PORT = ANALOG_PORT[1],
		LEFT_MOTOR = 2,
		RIGHT_MOTOR = 3,
		
		CLIMBER = PWM_PORT[0],
		ELEVATOR[] = {PWM_PORT[1], PCM_PORT[0], PCM_PORT[1]};
}
