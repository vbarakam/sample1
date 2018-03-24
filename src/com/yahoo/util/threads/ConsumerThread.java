package com.yahoo.util.threads;

public class ConsumerThread extends Thread {

	PC pc;
	
	public ConsumerThread(PC pc) {
		this.pc = pc;
	}
	
	public void run() {
		try {
			this.pc.consume();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
