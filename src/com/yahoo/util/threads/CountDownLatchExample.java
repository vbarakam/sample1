package com.yahoo.util.threads;

import java.util.concurrent.*;

/**
 * CountDownLatch let one or more thread to wait to complete certain operation
 * @author vbarakam
 *
 */
public class CountDownLatchExample {
	public static void main(String args[]) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(new Waiter(latch)).start();;
		new Thread(new CountDown(latch)).start();;
		//Thread.sleep(100000);
	}
}

class Waiter implements Runnable {
	CountDownLatch latch;
	
	Waiter(CountDownLatch latch) {
		this.latch = latch;
	}
	public void run() {
		System.out.println("Waiter Start");
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Waiter Done");
	}
}

class CountDown implements Runnable {
	CountDownLatch latch;
	
	CountDown(CountDownLatch latch) {
		this.latch = latch;
	}
	public void run() {
		System.out.println("CountDown Start");
		try {
			Thread.sleep(10000);
			latch.countDown();
			System.out.println("CountDown 1");
			Thread.sleep(10000);
			latch.countDown();
			System.out.println("CountDown 2");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CountDown Done");
	}
}
