package main;

public class MyObserver implements IObserver {

	public MyObserver(ISujet sujet) {
		super();
		sujet.addObserver(this);
	}

	@Override
	public void actualiser(int temperature, int humidity) {
		System.out.println("####OBSERVER1####### temperature = "+temperature+" humidity = "+humidity);
	}

}
