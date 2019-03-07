package main;

import java.util.TimerTask;

public class AlphaReadTask extends TimerTask {
	private MultiThread mt;
	public AlphaReadTask(MultiThread mt) {
		this.mt = mt;
	}
	@Override
	public void run() {
		mt.fromAlphaReadTimer();
	}

}
