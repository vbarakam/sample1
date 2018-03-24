package com.yahoo.concurrent;

import java.util.concurrent.*;
import java.util.*;

public class Consumer implements Runnable {
	private final BlockingQueue<Long> queue;
	private Random rand;
	private int num;

	public Consumer(BlockingQueue<Long> aQueue, int index) {
		this.queue = aQueue;
		rand = new Random();
		this.num = index;
	}

	public void run() {
		while (true) {
			try {
				long value = queue.take();
				System.out.println("Consumer " + num + " ==> " + value);
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
