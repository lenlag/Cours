package main;

public class Test {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		System.out.println("Fin du Thread principal");
	}

}
