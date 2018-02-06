package wrapper;

import java.util.ArrayList;

public class MovingAverage {

	int size;
	ArrayList<Double> values = new ArrayList<>();
	double average = 0;

	public MovingAverage(int size) {
		this.size = size;

	}

	public double average(double value) {
		if (values.size() >= size) {
			values.remove(0);
		}
		values.add(value);
		average = 0;
		
		for (int i = 0; i < values.size(); i++) {
			average += values.get(i);
		}
		average = average / values.size();
		return average;

	}
	public double getAverage(){
		return average;
	}
}//zach here commenting to inform you that i actually did something useful! i feel accomplished!
