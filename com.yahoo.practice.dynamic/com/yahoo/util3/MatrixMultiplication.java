package com.yahoo.util3;

public class MatrixMultiplication {
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4};
		if (matrix(arr)  != 18) {
			System.out.println("Error");
		}
		arr = new int[]{40, 20, 30, 10, 30};
		if (matrix(arr)  != 26000) {
			System.out.println("Error");
		} else {
			System.out.println("sucess");
		}
		
		arr = new int[] {10, 20, 30, 40, 30};
		if (matrix(arr)  != 30000) {
			System.out.println("Error");
		} else {
			System.out.println("sucess");
		}
		
		arr = new int[] {10, 20, 30};
		if (matrix(arr)  != 6000) {
			System.out.println("Error");
		} else {
			System.out.println("sucess");
		}
	}
	
	private static int matrix(int arr[]) {
		return -1;
	}
}
