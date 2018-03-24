package com.yahoo.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;

public class ReentrantLockExample {
	public static void main(String args[]) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		ReentrantLock rLock = new ReentrantLock();
		
		service.submit(new Worker("Thread 1", rLock));
		service.submit(new Worker("Thread 2", rLock));
		service.submit(new Worker("Thread 3", rLock));
		service.submit(new Worker("Thread 4", rLock));
		service.submit(new Worker("Thread 5", rLock));
		service.submit(new Worker("Thread 6", rLock));
		service.shutdown();
		service.awaitTermination(100, TimeUnit.SECONDS);
	}
}

class Worker implements Runnable {
	private ReentrantLock rLock;
	private String name;

	public Worker(String name, ReentrantLock lock) {
		this.name = name;
		this.rLock = lock;
	}

	public void run() {
		boolean done = false;
		while (!done) {
			boolean lock = rLock.tryLock();
			if (lock) {
				try {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.format("task name - %s  outer lock acquired at %s Doing outer work%n", name,
							ft.format(d));
					Thread.sleep(1500);
					// Getting Inner Lock
					rLock.lock();
					try {
						d = new Date();
						ft = new SimpleDateFormat("hh:mm:ss");
						System.out.println("task name - " + name + " inner lock acquired at " + ft.format(d)
								+ " Doing inner work");
						System.out.println("Lock Hold Count - " + rLock.getHoldCount());
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						// Inner lock release
						System.out.println("task name - " + name + " releasing inner lock");

						rLock.unlock();
					}
					System.out.println("Lock Hold Count - " + rLock.getHoldCount());
					System.out.println("task name - " + name + " work done");

					done = true;
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				} finally {
					rLock.unlock();
				}
			} else {
				try {
					System.out.format("task {name} waiting for lock", name);
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}
}
