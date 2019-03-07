package main;

public class Machin implements IBidule {

	@Override
	public void setValue(int value) {
		MySingleton.getInstance().setValeur(value);
	}

	@Override
	public int getValue() {
		return MySingleton.getInstance().getValeur();
	}

	@Override
	public void display() {
		MySingleton.getInstance().display();
	}
	
}
