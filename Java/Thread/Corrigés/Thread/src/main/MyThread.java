package main;

public class MyThread extends Thread implements Runnable {

	@Override
	public void run() {
		super.run();
		System.out.println("Fin du Thread à part");
	}

}
