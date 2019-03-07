package main;

import java.util.ArrayList;
import java.util.List;

public class Sujet implements ISujet {

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
}
