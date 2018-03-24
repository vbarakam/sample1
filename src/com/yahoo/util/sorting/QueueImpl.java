package com.yahoo.util.sorting;

public class QueueImpl {

	public static void main(String args[]) {
		Queue queue = new Queue(4);
		queue.print();
		System.out.println("Added 10 to queue");
		queue.enqueue(10);
		queue.print();
		System.out.println("Added 20 to queue");
		queue.enqueue(20);
		queue.print();
		System.out.println("removed one element from queue");
		queue.dequeue();
		queue.print();
		System.out.println("Added 30 to queue");

		queue.enqueue(30);
		queue.print();
		System.out.println("Added 40 to queue");
		queue.enqueue(40);
		queue.print();
		System.out.println("Added 50 to queue");
		queue.enqueue(50);
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		System.out.println("Added 50 to queue");
		queue.enqueue(50);
		queue.print();
		queue.dequeue();
		queue.print();
	}
}

/*
 *  which data structure to be used
 *  
 *  boundary conditions
 *  a) dequeue : 
 *  	* rollover
 *      * empty condition
 *  b) enqueue
 *  	* rollover
 *      * full    
 */

class Queue {
	int head = 0;
	int tail = 0;
	int values [] = null;
	
	public Queue(int size) {
		values = new int[size];
	}
	
	public void enqueue(int value) {
		if ((head == (values.length) ? -1: head) + 1 == tail) {
			return;
		}
		if (head == (values.length)) {
			head = 0;
		}
		values[head] = value;
		head = head + 1;
	}
	
	public int dequeue() {
		// queue is empty
		//if (tail == head-1) {
		//	return -1;
		//}
		
		// roll over to start
		if (tail == values.length) {
			tail = 1;
			values[tail] = -1;
			return values[tail];
		}
		tail = tail + 1;
		int temp = values[tail-1];
		values[tail-1] = -1;
		return temp;
	}
	
	public void print() {
		/*
		System.out.println("tail " + tail + " head : " +  head);
		for (int index = tail; index < head; index++) {
			if (index == values.length) 
				index = 0;
			System.out.print(values[index]);
		}*/
		for (int value : values ) {
			System.out.print( value + " ");
		}
		System.out.println("**");
	}
}
