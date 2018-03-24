package com.yahoo.util.sorting;

import java.util.Arrays;

public class MergeSort1 {
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

	public static void sort(int[] A) {
		mergeSort(A, 0, A.length - 1);
	}

	private static void mergeSort(int nums[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid + 1, end);
			merge(nums, start, mid, end);
		}
	}

	private static void merge(int nums[], int start, int mid, int end) {
		int first[] = new int[mid - start + 1];
		int second[] = new int[end - mid];
		int oStart = start;
		for (int i = 0; i < first.length; i++) {
			first[i] = nums[start++];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = nums[++mid];
		}
		int f = 0, s = 0;
		while (f < first.length && s < second.length) {
			if (first[f] < second[s]) {
				nums[oStart++] = first[f++];
			} else {
				nums[oStart++] = second[s++];
			}
		}

		while (f < first.length) {
			nums[oStart++] = first[f++];
		}

		while (s < second.length) {
			nums[oStart++] = second[s++];
		}
	}

	private static void mergeSort2(int a[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort2(a, start, mid);
			mergeSort2(a, mid + 1, end);
			merge2(a, start, mid, end);
		}
	}

	private static void merge2(int nums[], int start, int mid, int end) {
		int first[] = new int[mid - start + 1];
		int second[] = new int[end - mid];
		int oStart = start;
		for (int i = 0; i < first.length; i++) {
			first[i] = nums[start++];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = nums[++mid];
		}
		int firstIndex = 0, secondIndex = 0;
		while (firstIndex < first.length && secondIndex < second.length) {
			if (first[firstIndex] < second[secondIndex]) {
				nums[oStart++] = first[firstIndex++];
			} else {
				nums[oStart++] = first[secondIndex++];
			}
		}

		while (firstIndex < first.length) {
			nums[oStart++] = first[firstIndex++];
		}

		while (secondIndex < second.length) {
			nums[oStart++] = first[secondIndex++];
		}
	}

	private static void mergeSort4(int a[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort3(a, start, mid);
			mergeSort3(a, mid + 1, end);
			merge3(a, start, mid, end);
		}
	}

	private static void merge4(int a[], int start, int mid, int end) {
		// create first and second arrays
		int first[] = new int[mid - start + 1];
		int second[] = new int[end - mid];
		int oStart = start;

		// copy data to first and second
		for (int index = 0; index < first.length; index++) {
			first[index] = a[start++];
		}

		for (int index = 0; index < second.length; index++) {
			second[index] = a[++mid];
		}

		// update main array with first and second
		int firstPointer = 0;
		int secondPointer = 0;
		for (int i = oStart; i <= end; i++) {

			if (firstPointer < first.length && secondPointer < second.length) {
				if (first[firstPointer] < second[secondPointer]) {
					a[i] = first[firstPointer];
					firstPointer++;
				} else {
					a[i] = second[secondPointer];
					secondPointer++;
				}

				continue;
			}

			if (firstPointer < first.length) {
				a[i] = first[firstPointer];
				firstPointer++;
				continue;
			}

			if (secondPointer < second.length) {
				a[i] = second[secondPointer];
				secondPointer++;
			}
		}
	}

	private static void mergeSort3(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort3(a, start, mid);
			mergeSort3(a, mid + 1, end);
			merge3(a, start, mid, end);
		}
	}

	private static void merge3(int[] a, int start, int mid, int end) {
		// 4 5 8 2 3 7 : start =0, mid 2, end 5 :: 2, 3, 4, 5, 7, 8
		// 4 5 start =0, mid 0, end 1
		// copy first and second array to temp array
		int first[] = new int[mid - start + 1];
		int second[] = new int[end - mid];
		int sstart = start;

		// copy
		for (int index = 0; index < first.length; index++) {
			first[index] = a[start++];
		}

		mid += 1;
		for (int index = 0; index < second.length; index++) {
			second[index] = a[mid++];
		}

		int firstIndex = 0;
		int secondIndex = 0;
		for (int index = sstart; index < (end + 1); index++) {

			if (firstIndex < first.length && secondIndex < second.length) {
				if (first[firstIndex] < second[secondIndex]) {
					a[index] = first[firstIndex++];
				} else {
					a[index] = second[secondIndex++];
				}
			} else {

				//
				if (firstIndex < first.length) {
					a[index] = first[firstIndex++];
				} else {
					a[index] = second[secondIndex++];
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
