package com.yahoo.util.sorting;

import java.util.Arrays;

public class Heaps {
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

    // int[][] input = {C};
    // int[][] results = {C1};
    int errors = 0;
    int index = 0;
    for (index = 0; index < input.length; index++) {
      int[] copy = Arrays.copyOf(input[index], input[index].length);
      
      System.out.println("Processing " + index);
      sort(copy);
      
      if (!Arrays.equals(copy, results[index])) {
        errors++;
        System.out.println("Input data " + index + " :: ");
        printArray(input[index]);
        System.out.println("Error Sorting " + index + " :: ");
        printArray(copy);
        System.out.println("Expected Results " + index + " :: ");
        printArray(results[index]);
      }



    }

    System.out.println("Errors " + errors + " of " + index);
  }
  
  private static void sort(int[] copy) {
    max_heap(copy, 0);
    
    int end = copy.length;
    int index = 0;
    while (index < end) {
      // swap first and end
      int temp = copy[end-1];
      copy[end-1] = copy[index];
      copy[index] = temp;
      
      // decrement the end
      end--;
      
      // max_heapify the first
      max_heapify(copy, 0, end);
    }
  }
  
  private static void max_heap(int[] copy, int pos) {
    for (int index = (copy.length)/2; index >=0; index--) {
      max_heapify(copy, index, copy.length);
    }
    
  }
  
  private static void max_heapify(int[] copy, int pos, int length) {
    
    int l = left(pos);
    int r = right(pos);
    
    //if (l > (copy.length -1) || r > (copy.length -1)) {
    //  return;
    //}
    
    int largest = pos;
    if (l < length && copy[l] > copy[pos]) {
      largest = l;
    }
    
    if (r < length && copy[r] > copy[largest]) {
      largest = r;
    } 
    
    if (largest != pos) {
      int temp = copy[pos];
      copy[pos] = copy[largest];
      copy[largest] = temp;
      max_heapify(copy, largest, length);
    }
  }
  
  private static int left(int pos) {
    return ((pos +1)*2 -1);
  }
  
  private static int right(int pos) {
    return (pos +1)*2;
  }

  public static void printArray(int a[]) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(" " + a[i]);
    }
    System.out.println(" -- ");

  }
}
