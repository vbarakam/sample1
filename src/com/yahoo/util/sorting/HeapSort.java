package com.yahoo.util.sorting;

import java.util.Arrays;

public class HeapSort {
  public static void main(String args[]) {
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
    
    int[][] input = {A, B, C, D, E, F, G};
    int[][] results = {A1, B1, C1, D1, E1, F1, G1};

    int errors = 0;
    int index = 0;
    for (index = 0; index < input.length; index++) {
     int [] copy = Arrays.copyOf(input[index], input[index].length);
     System.out.println("Processing " + index);
     //System.out.println("Input data " + index + " :: ");
     printArray(copy);
     
     sort(input[index]);
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
  
  public static void sort (int a []) {
   // build max heap
   build_max_heap(a);
   
   int length = a.length -1;
   while (length >= 0) {
	   int temp = a[length];
	   a[length] = a[0];
	   a[0] = temp;
	   max_heapify(a, 0, length);
	   length -= 1;
   }
  }
  
  public static void build_max_heap(int a[]) {
	  for (int index = a.length/2; index >= 0; index--) {
		  max_heapify(a, index, a.length);
	  }
  }
  
  public static void max_heapify(int a[], int index, int length) {
	int l = left(index);
	int r = right(index);
	int largest = index;
	if (l < length && a[l] > a[index]) {
		largest = l;
	}
	if (r < length && a[r]> a[largest]) {
		largest = r;
	}
	if (largest != index) {
		int temp = a[index];
		a[index] = a[largest];
		a[largest] = temp;
		max_heapify(a, largest, length);
	}
  }
  
  public static int parent(int i) {
	  return i/2;
  }
  
  public static int left(int i) {
	  return (i + 1) * 2 -1;
  }
  
  public static int right(int i) {
	  return (i + 1) * 2;
  }
  
  public static void printArray(int a[]) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(" " + a[i]);
    }
    System.out.println(" -- ");

  }
}
