package com.yahoo.util.sorting;

import java.util.Arrays;

public class MergeSort {
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

    int[][] input = {A, B, C, D, E, F, G};
    int[][] results = {A1, B1, C1, D1, E1, F1, G1};

    //int[][] input = {C};
    //int[][] results = {C1};
    int errors = 0;
    int index = 0;
    for (index = 0; index < input.length; index++) {
     int [] copy = Arrays.copyOf(input[index], input[index].length);
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
    mergeSort(A, 0, A.length -1);
  }

  private static void mergeSort(int[] a, int start, int end) {
    // check for exit criteria
    if (!(start < end)) {
      return;
    }
    
    // calculate the split point
    int mid = (start + end)/2;
    
    // call mergeSort on left
    mergeSort(a, start, mid);
    
    // call mergeSort on right
    mergeSort(a, mid + 1, end);
    
    // merge
    merge(a, start, mid, end);
  }

  private static void merge(int[] a, int start, int mid, int end) {
    // create a temp array to hold the array
    int aux [] = new int[end - start + 1];
    
    // copy the data to temp array
    int i = 0;
    for (int index = start; index <= end; index++) {
      aux[i++] = a[index];
    }
    
    int leftindex = 0;
    int rightindex = mid - start +1;
    int amid =  mid - start;
    int aend = aux.length - 1;
    // compare and update the original array
    for (int index = start; index <= end; index++) {
      // if leftindex crossed mid point, just copy all the right array
      if (leftindex > amid) {
        a[index] = aux[rightindex++];
        continue;
      }
      
      // if rightindex reached end, just copy all the left array elements
      if (rightindex > aend) {
        a[index] = aux[leftindex++];
        continue;
      }
      
      if (aux[leftindex] < aux[rightindex]) {
        a[index] = aux[leftindex++];
      } else {
        a[index] = aux[rightindex++];
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
