package com.yahoo.util.search;

public class BinarySearch {

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;
		int result = binarySearch(arr, 0, arr.length - 1, x);
		System.out.println(result);
	}
	
	public static int binarySearch(int arr[], int start, int end, int val) {
		if (start <= end) {
			int mid = (start + end)/2;
			if (arr[mid] == val) {
				return mid;
			}
			if (val > arr[mid]) {
				return binarySearch(arr, mid + 1, end, val);
			} else {
				return binarySearch(arr, start, mid -1, val);
			}
		}
		
		return -1;
	}

}
