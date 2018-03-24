package com.yahoo.util;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

public class Test12 {
	public static void main(String[] args) {
		Runnable task = () -> {
			try {
			String threadName = Thread.currentThread().getName();
			System.out.println(" Thread start " + threadName);
			TimeUnit.SECONDS.sleep(10);
			System.out.println(" Thread end " + threadName);
			} catch (InterruptedException ie) {
				System.out.println(" i " + ie.getLocalizedMessage());
			}
		};
		//task.run();
		//Thread thread = new Thread(task);
		//thread.start();
		System.out.println("Done");
		ExecutorService service = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10).forEach(i->{System.out.println(" count " + i);});
	}
}
