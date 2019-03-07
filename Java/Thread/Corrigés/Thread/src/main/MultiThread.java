package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class MultiThread {
	private static final int ALPHA_WRITE_TIME=100;
	private static final int ALPHA_READ_TIME=1000;
	private static final int MAX_TIMER_COUNTER=10;
	
	private boolean stopMain = false;
	private List<String> list = new ArrayList<>();
	private int timerCounter = 0;
	private Timer timer;
	
	public MultiThread() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void fromSecondaryThread() {
		System.out.println("Debut du thread secondaire");
		try {
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		stopMain = true;
		System.out.println("Fin du thread secondaire");
	}
	public void fromAlphaWriteThread() {
		System.out.println("Debut du thread alpha Write");
		byte b = 'A';
		while(true) {
			if (b > 'Z') {
				break;
			}
			byte[] bs = {b,b,b};
			String s = new String(bs);
			//System.out.println("Alpha avec "+s);
			list.add(s);
			try {
				Thread.sleep(ALPHA_WRITE_TIME);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			b++;
		}
		System.out.println("Fin du thread alpha Write");
	}
	public void fromAlphaReadTimer() {
		if (list.size() > 0) {
			System.out.println(list.get(0));
			list.remove(0);
			// il s'est passé un truc, on remet le compteur à zero
			timerCounter = 0;
		} else {
			// il ne s'est rien passé, on incrémente le compteur.
			timerCounter++;
		}
		// dans le cas où rien ne s'est passé durant un certain temps on sort.
		if (timerCounter >= MAX_TIMER_COUNTER) {
			timer.cancel();
			System.out.println("Fin du Timer Alpha Read");
		}
	}
	public void main() throws Exception {
		MyOtherThread mot = new MyOtherThread(this);
		mot.start();
		while(!stopMain) {
			System.out.println("Thread principal");
			Thread.sleep(1000);
		}
		System.out.println("Fin du Thread principal");
	}
	public void alphaMain() throws Exception {
		AlphaWriteThread at = new AlphaWriteThread(this);
		at.start();
		timer = new Timer();
		timer.schedule(new AlphaReadTask(this),ALPHA_READ_TIME,ALPHA_READ_TIME);
	}
	
}
