package com.yahoo.util.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {

	    int A[] = {5, 2, 4, 6, 1, 3};
	    int A1[] = {1, 2, 3, 4, 5, 6};

	    int B[] = {5, 1, 4, 6, 1, 1};
	    int B1[] = {1, 1, 1, 4, 5, 6};

	    int C[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 11, 1};
	    int C1[] = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 11};
	    
	    int D[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    int D1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	    int E[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
	    int E1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	    int F[] = {1, 2, 3, 4, 5, 5, 7, 5, 9};
	    int F1[] = {1, 2, 3, 4, 5, 5, 5, 7, 9};

	    int G[] = {3, 7, 8, 5, 2, 1, 9, 5, 4};
	    int G1[] = {1, 2, 3, 4, 5, 5, 7, 8, 9};
	    
	    int H[] = {35, 1003, 31, 45};
	    int H1[] = {31, 35, 45, 1003};

	       int[][] input = {A, B, C, D, E, F, G, H};
	        int[][] results = {A1, B1, C1, D1, E1, F1, G1, H1};

	    
	    int errors = 0;
	    int index = 0;
	    for (index = 0; index < input.length; index++) {
	     int [] copy = Arrays.copyOf(input[index], input[index].length);
	     System.out.println("Processing " + index);
	     //System.out.println("Input data " + index + " :: ");
	     //printArray(copy);
	     
	     sort(input[index], 0, input[index].length -1);
	     //System.out.println("Output data " + index + " :: ");
	     //printArray(input[index]);
	    
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

	public static void sort(int[] a, int start, int end) {
		if (start < end) {
			int pivot = partition(a, start, end);
			sort(a, start, pivot -1);
			sort(a, pivot + 1, end);
		}
	}
	
	// 5 2 4 6 1 3 
	// i = -1, j = 0, high = 5, pivot = 3;
	// 2 5 4 6 1 3 ==> i = 0, j = 1, high = 5, pivot = 3;
	// 2 1 4 6 5 3 ==> i = 1, j = 1, high = 5, pivot = 3;
	// 2 1 3 6 5 4 ==> i = 2, j = 4
	public static int partition(int a[], int low, int high) {
		int pivot = a[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				swap(a, i,j);
				i = 1 + i;
			}
		}
		
		// swap i and high
		swap(a, i, high);
		return i;
	}
	
	public static void swap(int a[], int low, int high) {
		int temp = a[low];
		a[low] = a[high];
		a[high] = temp;
	}
	
	 public static void printArray(int a[]) {
	    for (int i = 0; i < a.length; i++) {
	      System.out.print(" " + a[i]);
	    }
	    System.out.println(" -- ");

	  }
}
