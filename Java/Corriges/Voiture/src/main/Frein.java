package main;

public class Frein {
	private boolean enclenche = true;
	
	public void enclencher() {
		if (enclenche) {
			Log.log("Frein d�j� enclench�");
		} else {
			Log.log("Frein enclench�");
			enclenche = true;
		}
	}
	public void relacher() {
		if (!enclenche) {
			Log.log("Frein d�j� relach�");
		} else {
			enclenche = false;
			Log.log("Frein relach�");
		}
	}
}
