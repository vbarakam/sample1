package com.yahoo.concurrent;

import java.util.concurrent.TimeUnit;

public class Example {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);

		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println("c " + counter.getCount());
	}
}

class Counter {

	private long count = 0;

	public synchronized void add(long value) {
		this.count += value;
		//System.out.println(count);
	}
	
	public long getCount() {
		return count;
	}
}

class CounterThread extends Thread {

	protected Counter counter = null;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.add(1);
		}
	}
}
