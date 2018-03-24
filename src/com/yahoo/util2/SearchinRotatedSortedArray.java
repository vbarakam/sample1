package com.yahoo.util2;

public class SearchinRotatedSortedArray {
	public static void main(String args[]) {
		int data [] = {4, 5, 6, 7, 0, 1, 2};
		int lo = 0, hi = data.length -1;
		while (lo < hi) {
			int mid = (lo + hi)/2;
			if (data[mid] > data[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		System.out.println(" lo " + lo);
	}
}
