package main;

public class MyObserver2 implements IObserver {

	public MyObserver2(ISujet sujet) {
		super();
		sujet.addObserver(this);
	}

	@Override
	public void actualiser(int temperature, int humidity) {
		System.out.println("----OBSERVER2------- temperature = "+temperature+" humidity = "+humidity);
	}

}
