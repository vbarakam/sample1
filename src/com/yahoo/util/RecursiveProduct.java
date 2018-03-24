package com.yahoo.util;

public class RecursiveProduct {
	public static void main(String args[]) {
		System.out.println(prod(4, 4));
	}
	
	// 4 * 5
	public static int prod(int i, int j) {
		if (j == 0) {
			return 0;
		}
		return (i + prod(4, j-1));
	}
}
