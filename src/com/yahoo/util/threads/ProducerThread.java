package com.yahoo.util.threads;

public class ProducerThread extends Thread {
	PC pc;

	public ProducerThread(PC pc) {
		this.pc = pc;
	}

	public void run() {
		try {
			this.pc.produce();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
