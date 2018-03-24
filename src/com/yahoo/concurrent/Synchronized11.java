package com.yahoo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class Synchronized11 {

	private static final int NUM_INCREMENTS = 10000;

	//private AtomicInteger count = new AtomicInteger();
	private int count = 0;
	ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) throws Exception {
		Synchronized11 sync = new Synchronized11();
		sync.increment2();
		System.out.println("After direct increment " + sync.count);
		sync.testSyncIncrement();
		System.out.println("After sync increment " + sync.count);
		sync.testNonSyncIncrement();
		System.out.println("After Non Sync increment " + sync.count);
		sync.testLockIncrement();
		System.out.println("After Lock increment " + sync.count);
		System.out.println("End");
	}

	private void increment2() {
		//count.set(0);
		count = 0;

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> incrementSync());

		System.out.println("  simple Sync: " + count);
	}

	private void testSyncIncrement() throws InterruptedException {
		count = 0;

		ExecutorService executor = Executors.newFixedThreadPool(10);

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> {
			executor.submit(()->incrementSync());
		});
		executor.awaitTermination(10, TimeUnit.SECONDS);
		// ConcurrentUtils.stop(executor);

		System.out.println("   Sync: " + count);
	}
	
	private void testLockIncrement() throws InterruptedException {
		count = 0;

		ExecutorService executor = Executors.newSingleThreadExecutor();

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> {
			executor.submit(()->lockincrement());
		});
		executor.awaitTermination(10, TimeUnit.SECONDS);

		// ConcurrentUtils.stop(executor);

		System.out.println("  Lock Sync: " + count);
	}

	
	private void lockincrement() {
	    lock.lock();
	    try {
	        //count.incrementAndGet();
	    	count++;
	    } finally {
	        lock.unlock();
	    }
	}
	
	private void testNonSyncIncrement() throws InterruptedException {
		count = 0;

		ExecutorService executor = Executors.newFixedThreadPool(10);

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> executor.submit(this::increment));
		// ConcurrentUtils.stop(executor);
		executor.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("NonSync: " + count);
	}

	private synchronized void incrementSync() {
		// System.out.println(count);
		//synchronized (Synchronized11.class) {
			//System.out.println(count);
			//count.incrementAndGet();
		count++;
		
	}

	private void increment() {
		//count.incrementAndGet();
		count++;
	}

}