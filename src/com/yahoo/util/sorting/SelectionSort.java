package com.yahoo.util.sorting;

public class SelectionSort {
	public static void main(String [] args) {
		//int A[] = {5,2,4,6,1,3};
		int A[] = {5,1,4,6,1,1};
		//int A[] = {9,8,7,6,5,4,3,2,1,11,11,1};
		sort(A);
		for (int i =0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	
	public static void sort(int values[]) {
		int aLength = values.length;
		int counter = 0;
		for (int i = 0; i < aLength; i++) {		
			for (int j = i; j < aLength; j++) {
				counter++;
				if (values[j] < values[i]) {
					int temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
			}
		}
		System.out.println(" counter " + counter);
	}
}
