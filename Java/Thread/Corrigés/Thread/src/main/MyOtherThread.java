package main;

public class MyOtherThread extends Thread {
	MultiThread mt;
	public MyOtherThread(MultiThread mt) {
		super();
		this.mt = mt;
	}
	public void run() {
		mt.fromSecondaryThread();
	}
}
