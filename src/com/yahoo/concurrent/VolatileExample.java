package com.yahoo.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

public class VolatileExample {
	private boolean status = false;
	private int  counter = 1;
	
	public static void main(String args[]) {
		VolatileExample example = new VolatileExample();
		Runnable runnable1 = ()-> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(2);
					example.increment();
					System.out.println(" status 1 " + example.status + " " + example.counter);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};
		Runnable runnable2 = ()-> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(2);
					if (example.counter == 5) {
						System.out.println("Changed the status value *****");
						example.status = true;
					}
					example.increment();
					System.out.println(" status 2 " + example.status  + " " + example.counter);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(runnable2);
		service.submit(runnable1);
	}
	
	private void increment() {
		counter++;
	}
	
	private int getCounter() {
		return counter;
	}
	
}
