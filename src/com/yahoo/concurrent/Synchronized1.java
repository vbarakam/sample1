package com.yahoo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class Synchronized1 {
	static int count = 0;

	public static void main(String args[]) {
		testSyncIncrement();
	}

	public static void testSyncIncrement() {
		System.out.println("start ");
		ExecutorService service = Executors.newFixedThreadPool(10);
		IntStream.range(0, 100).forEach(i->service.submit(Synchronized1::incrementSync));
		System.out.println("end " + count);
	}

	private static synchronized void incrementSync() {
        count = count + 1;
    }

    private static void increment() {
        count = count + 1;
    }
}
