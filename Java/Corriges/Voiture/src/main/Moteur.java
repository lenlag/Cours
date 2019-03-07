package main;

public class Moteur {
	private boolean started = false;

	public Moteur() {
		started = false;
		Log.log("Moteur arr�t� � la construction");
	}
	public void start() {
		if (!started) {
			started = true;
			Log.log("Moteur d�marr�");
		} else {
			Log.log("Moteur d�j� d�marr�");
		}
	}
	public void stop() {
		if (started) {
			started = false;
			Log.log("Moteur arr�t�");
		} else {
			Log.log("Moteur d�j� arr�t�");
		}
	}
	public void accelere() {
		if (started) {
			Log.log("Moteur accelere");
		} else {
			Log.log("impossible d'accel�rer : le moteur est arr�t�");
		}
	}
	public void d�celere() {
		if (started) {
			Log.log("Moteur d�celere");
		} else {
			Log.log("impossible de d�celerer : le moteur est arr�t�");
		}
	}
}
