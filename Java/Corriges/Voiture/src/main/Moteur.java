package main;

public class Moteur {
	private boolean started = false;

	public Moteur() {
		started = false;
		Log.log("Moteur arrété à la construction");
	}
	public void start() {
		if (!started) {
			started = true;
			Log.log("Moteur démarré");
		} else {
			Log.log("Moteur déjà démarré");
		}
	}
	public void stop() {
		if (started) {
			started = false;
			Log.log("Moteur arrété");
		} else {
			Log.log("Moteur déjà arrété");
		}
	}
	public void accelere() {
		if (started) {
			Log.log("Moteur accelere");
		} else {
			Log.log("impossible d'accelérer : le moteur est arrété");
		}
	}
	public void décelere() {
		if (started) {
			Log.log("Moteur décelere");
		} else {
			Log.log("impossible de décelerer : le moteur est arrété");
		}
	}
}
