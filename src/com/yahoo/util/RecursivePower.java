package com.yahoo.util;

public class RecursivePower {
	public static void main(String args []) {
		System.out.println(power(2, 1));
	}
	
	public static double power(int i, int j) {
		if (j == 0) {
			return 1;
		}
		
		if (j >= 0) {
			return i * power(i, j-1);
		} else {
			if (j < 0) {
				j = j * -1;
			}
			return (1.0/i) * power(i, j-1);
		}
	}
}
