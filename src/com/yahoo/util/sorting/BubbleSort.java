package com.yahoo.util.sorting;

public class BubbleSort {

	public static void main(String args[]) {
		//int A[] = { 5, 2, 4, 6, 1, 3 };
		//int A[] = {5,1,4,6,1,1};
		//int A[] = {9,8,7,6,5,4,3,2,1,11,11,1};
		int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//int A[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		sort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	public static void sort(int[] values) {
		boolean swapped = true;
		int counter = 0;
		int i =0;
		//for (int i = 0; i < values.length; i++) {
		while (swapped)	{
			swapped = false;
			for (int j = 0; j < (values.length -i-1); j++) {
				counter++;
				if (values[j] > values[j+1]) {
					int temp = values[j];
					values[j] = values[j+1];
					values[j+1] = temp;
					swapped = true;
				}
			}
			i++;
			//if (!swapped) {
			//	break;
			//}
		}
		System.out.println(" counter **** " + counter);
	}
}
