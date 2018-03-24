package com.yahoo.concurrent;

import java.util.concurrent.*;
import java.util.*;

public class Producer implements Runnable {
	private BlockingQueue<Long> queue;
	private Random rand;

	public Producer(BlockingQueue<Long> aQueue) {
		this.queue = aQueue;
		rand = new Random();
	}

	public void run() {
		while (true) {
			// for (int i = 0; i < 500; i++) {

			try {
				long i = System.currentTimeMillis();
				System.out.println("Producer ==> " + i);

				queue.put(i);
				//Thread.sleep(rand.nextInt(5));
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			// }
		}
	}
}
