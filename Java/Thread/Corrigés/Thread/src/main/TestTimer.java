package main;

import java.util.Timer;

public class TestTimer {

	public static void main(String[] args) {
		long timerInterval = 1000;
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), timerInterval,timerInterval);
		System.out.println("Fin du Thread principal");
	}

}
