package com.yahoo.util.sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RedixSort2 {
	public static void main(String args[]) {
		int A[] = { 5, 2, 4, 6, 1, 3 };
		int A1[] = { 1, 2, 3, 4, 5, 6 };

		int B[] = { 5, 1, 4, 6, 1, 1 };
		int B1[] = { 1, 1, 1, 4, 5, 6 };

		int C[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 11, 1 };
		int C1[] = { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 11 };

		int D[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int D1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int E[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int E1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int F[] = { 1, 2, 3, 4, 5, 5, 7, 5, 9 };
		int F1[] = { 1, 2, 3, 4, 5, 5, 5, 7, 9 };

		int G[] = { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
		int G1[] = { 1, 2, 3, 4, 5, 5, 7, 8, 9 };

		int H[] = { 35, 1003, 31, 45 };
		int H1[] = { 31, 35, 45, 1003 };
		
		int I[] = {3, 30, 34, 5, 9};
		
		int I2[] = {3, 5, 9, 30, 34};

		int[][] input = { H, A, B, C, D, E, F, G, I};
		int[][] results = { H1, A1, B1, C1, D1, E1, F1, G1,I2 };

		int errors = 0;
		int index = 0;
		for (index = 0; index < input.length; index++) {
			int[] copy = Arrays.copyOf(input[index], input[index].length);
			System.out.println("Processing " + index);
			System.out.println("Input data " + index + " :: ");
			printArray(copy);

			sort(input[index]);
			System.out.println("Output data " + index + " :: ");
			printArray(input[index]);

			if (!Arrays.equals(input[index], results[index])) {
				errors++;
				System.out.println("Input data " + index + " :: ");
				printArray(copy);
				System.out.println("<b>ERROR SORTING <b>" + index + " :: ");
				printArray(input[index]);
				System.out.println("Expected Results " + index + " :: ");
				printArray(results[index]);
			}

		}
	}

	public static void sort(int nums[]) {
		Queue<Integer> queues[] = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			queues[i] = new LinkedList<Integer>();
		}
		boolean swapped = true;
		int div = 1;
		while (swapped) {
			swapped = false;
			for (int num : nums) {
				int index = num/div % 10;
				queues[index].add(num);
				if (num/div > 0) {
					swapped = true;
				}
			}
			div *= 10;
			int index = 0;
			for (Queue<Integer> queue : queues) {
				while (queue != null && !queue.isEmpty()) {
					nums[index++] = queue.poll();
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	public static void sort3(int nums[]) {
		Queue<Integer> queues[] = new LinkedList[10];
		for (int i = 0; i < queues.length; i++) {
			queues[i] = new LinkedList<Integer>();
		}
		int exp = 1;
		boolean sorted = true;
		while (sorted) {
			sorted = false;
			for (int num : nums) {
				int radix = (num/exp) % 10;
				if (num/exp > 0) {
					sorted = true;
				}
				queues[radix].add(num);
			}
			
			exp *= 10;
			int index = 0;
			for (Queue<Integer> queue : queues) {
				while (!queue.isEmpty()) {
					nums[index++] = queue.poll();
				}
			}
		}
	}

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println(" -- ");

	}
}
