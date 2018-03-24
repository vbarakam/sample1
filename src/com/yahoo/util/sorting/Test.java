package com.yahoo.util.sorting;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
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

		// int[][] input = {C};
		// int[][] results = {C1};
		int errors = 0;
		int index = 0;
		for (index = 0; index < input.length; index++) {
			int[] copy = Arrays.copyOf(input[index], input[index].length);
			System.out.println("Processing " + index);
			sort(input[index]);
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

		System.out.println("Errors " + errors + " of " + index);
	}

	// 1 2 3 4 5 6
	// 6 5 4 3 2 1
	// 1 2 6 7 3
	public static void insertionSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			int value = data[i];
			int index = i - 1;
			while (index >= 0 && value < data[index]) {
				data[index + 1] = data[index];
				index--;
			}
			data[index + 1] = value;
		}
	}

	public static void sort(int[] A) {
		insertionSort(A);
	}

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println(" -- ");

	}
}
