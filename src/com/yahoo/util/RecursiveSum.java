package com.yahoo.util;

public class RecursiveSum {
	public static void main(String args []) {
		System.out.println(sum(10,5));
	}
	
	// 4, 2
	public static int sum(int i, int j) {
		if (j == 0) {
			return i;
		}
		
		return 1 + sum(i, j -1);
	}
}
