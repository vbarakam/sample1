package com.yahoo.util;

public class Binary {
	public static void main(String args []) {
		int n = 6;
		for (int i = 0; i< 1 << n; i++) {
			System.out.println( i + " :: " + Integer.toBinaryString(i) + " :: " + countOnes(Integer.toBinaryString(i)));
		}
	}
	
	public static int countOnes(String str) {
		int k = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				k++;
			}
		}
		return k;
	}
}
