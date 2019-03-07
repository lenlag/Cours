package entity;

import business.entity.BoutiqueItem;

public class PanierItem {
	private long id;
	private String code;
	private String label;
	private int nb;
	private double price;
	private double soloPrice;
	
	public PanierItem(long id,String code, String label, int nb, double price) {
		super();
		this.code = code;
		this.label = label;
		this.nb = nb;
		this.price = price;
		this.id = id;
	}
	public PanierItem(BoutiqueItem bi) {
		this.id=bi.getId();
		this.code = bi.getCode();
		this.label = bi.getLabel();
		this.nb = 1;
		this.soloPrice = this.price = bi.getPrice();
	}
	public void processPrice() {
		price = nb*soloPrice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
