package business.entity;

public class Voiture {
	private long id;
	private String marque;
	private String modele;
	private Frein frein;
	private Moteur moteur;

	public Voiture(long id, String marque, String modele, Frein frein, Moteur moteur) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.frein = frein;
		this.moteur = moteur;
	}
	public Voiture(String marque, String modele, Frein frein, Moteur moteur) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.frein = frein;
		this.moteur = moteur;
	}
	public Voiture() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public Frein getFrein() {
		return frein;
	}
	public void setFrein(Frein frein) {
		this.frein = frein;
	}
	public Moteur getMoteur() {
		return moteur;
	}
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}
	
	
}
