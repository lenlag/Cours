package main;

public class Frein {
	private boolean enclenche = true;
	
	public void enclencher() {
		if (enclenche) {
			Log.log("Frein déjà enclenché");
		} else {
			Log.log("Frein enclenché");
			enclenche = true;
		}
	}
	public void relacher() {
		if (!enclenche) {
			Log.log("Frein déjà relaché");
		} else {
			enclenche = false;
			Log.log("Frein relaché");
		}
	}
}
