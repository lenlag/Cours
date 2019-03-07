package main;

public class AlphaWriteThread extends Thread {
	MultiThread mt;
	public AlphaWriteThread(MultiThread mt) {
		super();
		this.mt = mt;
	}
	public void run() {
		mt.fromAlphaWriteThread();
	}
}
