package main;

import java.util.ArrayList;
import java.util.List;

public class SujetSingle implements ISujet {
	// used as singleton
	private static SujetSingle instance = null;
	private SujetSingle() {};
	public static SujetSingle getInstance() {
		if (instance == null) {
			instance = new SujetSingle();
		}
		return instance;
	}
	
	private List<IObserver> observers = new ArrayList<>();
	private int temperature;
	private int humidity;
	
	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (IObserver o:observers) {
			o.actualiser(temperature, humidity);
		}
	}
	
	public void miseAJour(int temperature,int humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
		notifyObservers();
	}
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		MyObserver o = new MyObserver(SujetSingle.getInstance());
		@SuppressWarnings("unused")
		MyObserver2 o2 = new MyObserver2(SujetSingle.getInstance());
		Thread.sleep(1000);
		SujetSingle.getInstance().miseAJour(32, 50);
		Thread.sleep(1000);
		SujetSingle.getInstance().miseAJour(33, 47);
	}
	
}
