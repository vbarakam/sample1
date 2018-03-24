package com.yahoo.util3;

public class TestBinarySearch {
	public static void main(String args[]) {
		int d1[] = {10, 30, 20, 5, 50, 100};
		int d2[] = {10,10,10,20,30,40,60};
		System.out.println(search(d2, 0, d2.length -1, 10));
	}
	
	private static int search(int [] data, int start, int end, int val) {
		System.out.println(" start " + start + " end " + end);
		if (start > end) {
			return start;
		}
		int mid = (start + end)/2;
		if (data[mid] == val) {
			return mid;
		}
		if (val < data[mid]) {
			return search(data, start, mid-1, val);
		} else {
			return search(data, mid+1, end, val);
		}
	}
}
