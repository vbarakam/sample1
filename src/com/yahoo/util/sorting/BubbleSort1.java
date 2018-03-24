package com.yahoo.util.sorting;

import java.util.Arrays;

public class BubbleSort1 {
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

		int[][] input = { A, B, C, D, E, F, G };
		int[][] results = { A1, B1, C1, D1, E1, F1, G1 };

		int errors = 0;
		int index = 0;
		for (index = 0; index < input.length; index++) {
			int[] copy = Arrays.copyOf(input[index], input[index].length);
			System.out.println("Processing " + index);
			// System.out.println("Input data " + index + " :: ");
			printArray(copy);

			sort(input[index]);
			// System.out.println("Output data " + index + " :: ");
			printArray(input[index]);

			if (!Arrays.equals(input[index], results[index])) {
				errors++;
				System.out.println("Input data " + index + " :: ");
				printArray(copy);
				System.out.println("Error Sorting " + index + " :: ");
				printArray(input[index]);
				System.out.println("Expected Results " + index + " :: ");
				printArray(results[index]);
			}

		}
	}

	public static void sort(int a[]) {
		boolean swapped = true;
		int n = a.length - 1;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < n; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}
			n = n - 1;
		}
	}

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println(" -- ");

	}
}
