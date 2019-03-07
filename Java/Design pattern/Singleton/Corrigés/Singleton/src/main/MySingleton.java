package main;

public class MySingleton {
	private static MySingleton instance = null;
	private MySingleton () {};
	public static MySingleton getInstance() {
		if (instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}
	public void display() {
		System.out.println("DISPLAY : MySingleton");
	}
	// Ca va poser un problème
	private int valeur = 0;
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
