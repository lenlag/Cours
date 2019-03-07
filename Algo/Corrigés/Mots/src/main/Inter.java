package main;

public class Inter {
	private Character carac;
	private double value;
	
	
	public Inter(Character carac, double value) {
		super();
		this.carac = carac;
		this.value = value;
	}
	public Inter() {
	}
	public Character getCarac() {
		return carac;
	}
	public void setCarac(Character carac) {
		this.carac = carac;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

}
