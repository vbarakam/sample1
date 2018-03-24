package com.yahoo.util;

import java.util.Queue;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String args[]) {
		Queue<Integer> queue  = new PriorityQueue<>();
		
		queue.add(10);
		queue.add(10);
		queue.add(5);
		queue.add(6);
		queue.add(6);
		queue.add(3);
		
		queue.forEach((Integer t) -> System.out.println(t));
		System.out.println("pop");
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
}
