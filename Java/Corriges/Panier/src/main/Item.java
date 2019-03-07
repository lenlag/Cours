package main;

public class Item {
	private int id;
	private String nom;
	private double prixHT;
	
	public Item(int id, String nom, double prixHT) {
		super();
		this.id = id;
		this.nom = nom;
		this.prixHT = prixHT;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "id=" + id + " nom=" + nom + " prixHT=" + prixHT;
	}
	
	
}
