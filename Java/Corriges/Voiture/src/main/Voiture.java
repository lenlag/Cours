package main;

public class Voiture {
	private String couleur;
	private Moteur motor;
	private Frein brake;
	private boolean started = false;
	
	public Voiture() {
		couleur = "noir"; // par défaut
		motor = new Moteur();
		brake = new Frein();
	}
	
	public void demarre() {
		if (!started) {
			motor.start();
			started = true;
			Log.log("Voiture démarrée");
		} else {
			Log.log("Voiture déjà démarrée");
		}
	}
	
	public void arrete() {
		if (started) {
			motor.stop();
			started = false;
			Log.log("Voiture arrétée");
		} else {
			Log.log("Voiture déjà arrétée");
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
