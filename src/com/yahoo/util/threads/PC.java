package com.yahoo.util.threads;

import java.util.LinkedList;

public class PC {

	private LinkedList<Integer> data = new LinkedList<>();
	int capacity = 5;

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				if (data.size() == capacity) {
					wait();
				}
				
				System.out.println("Producer produced-"
                        + value);
				
				data.add(value++);
				
				notify();
			}
				Thread.sleep(2000);
			
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (data.size() == 0) {
					wait();
				}
				
				int val = data.removeFirst();
				
				System.out.println("Consumer consumed-"
                        + val);
				notify();
			}
				Thread.sleep(1000);
			
		}
	}
}
