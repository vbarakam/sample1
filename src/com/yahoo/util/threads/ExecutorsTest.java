package com.yahoo.util.threads;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorsTest {
	public static void main(String args[]) {
		final Test1 test2 = new Test1();
		test2.i = 4;
	}
	public static void main2(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();

		executor.submit(() -> {
		    lock.lock();
		    try {
		        Thread.sleep(1);
		    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        lock.unlock();
		    }
		});

		executor.submit(() -> {
			while (true) {
		    System.out.println("Locked: " + lock.isLocked());
		    System.out.println("Held by me: " + lock.isHeldByCurrentThread());
		    boolean locked = lock.tryLock();
		    System.out.println("Lock acquired: " + locked);
		    Thread.sleep(100);
			}
		});

		executor.shutdown();
	}
}

class Test1 {
	   int i = 10;
	}
