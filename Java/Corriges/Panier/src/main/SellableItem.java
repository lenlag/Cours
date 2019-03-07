package main;

public class SellableItem extends Item implements ISellableItem {
	private double tva;
	
	public SellableItem(int id, String nom, double prixHT,double tva) {
		super(id, nom, prixHT);
		this.tva = tva;
	}
	public double getPrixTTC() {
		return getPrixHT()*(1.0+tva);
	}
	
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	@Override
	public String toString() {
		String s = super.toString();
		return s+" tva=" + tva+" prixTTC = "+getPrixTTC();
	}
	
}
