package main;

public class Main {

	public static void main(String[] args) throws Exception {
		Sujet sujet = new Sujet();
		@SuppressWarnings("unused")
		MyObserver o = new MyObserver(sujet);
		@SuppressWarnings("unused")
		MyObserver2 o2 = new MyObserver2(sujet);
		Thread.sleep(1000);
		sujet.miseAJour(32, 50);
		Thread.sleep(1000);
		sujet.miseAJour(33, 47);
	}

}
