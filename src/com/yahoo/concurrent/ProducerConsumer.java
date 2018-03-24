package com.yahoo.concurrent;

import java.util.concurrent.*;

public class ProducerConsumer {
	public static void main(String args[]) {
		BlockingQueue<Long> queue = new ArrayBlockingQueue<>(10);
		Consumer consumer1 = new Consumer(queue, 1);
		Consumer consumer2 = new Consumer(queue, 2);
		Producer producer = new Producer(queue);
		Thread thread1 = new Thread(consumer1);
		Thread thread2 = new Thread(consumer2);
		Thread thread3 = new Thread(producer);
		thread1.start();
		thread2.start();thread3.start();
	}
}
