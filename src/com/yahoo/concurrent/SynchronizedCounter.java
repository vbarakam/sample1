package com.yahoo.concurrent;

public class SynchronizedCounter {
	public static void main(String args[]) throws InterruptedException {
		ICounter counter = new ICounter();
		ThreadExample example1 = new ThreadExample(counter);
		ThreadExample example2 = new ThreadExample(counter);
		example1.start();
		example2.start();
		example1.join();
		example2.join();
		System.out.println("Count after thread execution " + counter.getCount());

		SyncCounter counter2 = new SyncCounter();
		SyncThreadExample example11 = new SyncThreadExample(counter2);
		SyncThreadExample example12 = new SyncThreadExample(counter2);
		example11.start();
		example12.start();
		example11.join();
		example12.join();
		System.out.println("Count after sync thread execution " + counter2.getCount());
	}
}

class ThreadExample extends Thread {
	private ICounter counter;

	public ThreadExample(ICounter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.increment(1);
		}
	}
}

class SyncThreadExample extends Thread {
	private SyncCounter counter;

	public SyncThreadExample(SyncCounter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.increment();
		}
	}
}

class ICounter {
	private int count = 0;

	public void increment() {
		count = count + 1;
	}

	public void increment(int i) {
		count = count + 1;
	}

	public int getCount() {
		return count;
	}
}

class SyncCounter {
	private int count = 0;

	public synchronized void increment() {
		count = count + 1;
	}

	public synchronized void increment(int i) {
		count = count + 1;
	}

	public int getCount() {
		return count;
	}
}
