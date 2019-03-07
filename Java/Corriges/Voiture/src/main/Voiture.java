package main;

public class Voiture {
	private String couleur;
	private Moteur motor;
	private Frein brake;
	private boolean started = false;
	
	public Voiture() {
		couleur = "noir"; // par d�faut
		motor = new Moteur();
		brake = new Frein();
	}
	
	public void demarre() {
		if (!started) {
			motor.start();
			started = true;
			Log.log("Voiture d�marr�e");
		} else {
			Log.log("Voiture d�j� d�marr�e");
		}
	}
	
	public void arrete() {
		if (started) {
			motor.stop();
			started = false;
			Log.log("Voiture arr�t�e");
		} else {
			Log.log("Voiture d�j� arr�t�e");
		}
	}
	public void avance() {
		brake.relacher();
		motor.accelere();
		Log.log("La voiture avance");
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
}
