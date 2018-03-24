package com.yahoo.util.threads;

public class PCMain {
	public static void main(String args[]) throws InterruptedException {
		PC pc = new PC();
		Thread producer = new ProducerThread(pc);
		Thread consumer = new ConsumerThread(pc);
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
	}
}
