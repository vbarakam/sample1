package com.yahoo.util;

import java.util.concurrent.*;
import java.util.*;

public class ProducerConsumerProblem {
    public static void main(String args[]) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(2);
        Runnable producer = new ProducerThread(queue);
        Runnable consumer = new ConsumerThread(queue);
        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);
        pThread.start();
        cThread.start();
    }
}

class ProducerThread implements Runnable {
    private BlockingQueue<Message> queue;
    private Random rand;
    private int counter;
    
    public ProducerThread(BlockingQueue<Message> queue) {
        this.queue = queue;
        counter = 1;
        rand = new Random();
    }
    
    public void run() {
        try {
        	for (int i = 0; i < 10; i++) {
        		System.out.println("Trying to produce message");
        		Message msg = new Message(Integer.toString(i));
        		System.out.println("adding msg " + msg.getMessage());
        		queue.put(msg);
        		TimeUnit.SECONDS.sleep(i);
        	}
        	Message msg2 = new Message("exit");
        	queue.put(msg2);
        	
        } catch (InterruptedException ie) {
        } 
    }
}

class ConsumerThread implements Runnable {
	private BlockingQueue<Message> queue;
    private Random rand;
    
    public ConsumerThread(BlockingQueue<Message> queue) {
        this.queue = queue;
        rand = new Random();
    }
    
    public void run() {
        try {
        	while (true) { 
	        	System.out.println("Trying to comsume message");
	            Message msg = queue.take();
	            if (msg.getMessage().equals("exit")) {
	            	break;
	            }
	            System.out.println("consumed message " + msg.getMessage());
	            TimeUnit.SECONDS.sleep(rand.nextInt(10));
        	}
        } catch (InterruptedException ie) {
        }
    }
}

class Message {
    private String str;
    
    public Message(String str) {
        this.str = str;
    }
    
    public String getMessage() {
        return str;
    }
}