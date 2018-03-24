package com.yahoo.util;

public class Test9 {
	public static void main(String args[]) {
		String pattern = "ANAMPNAM";
		String pattern2 = "NAMPNAM";
		for (int i = 0; i < pattern.length(); i++) {
			System.out.println( i + " :: " + suffixLength2(pattern.toCharArray(), i));
		}
		for (int i = pattern2.length() -1; i >= 0 ; i--) {
			System.out.println( i + " prefix :: " + isPrefix(pattern2.toCharArray(), i));
		}
	}
	
	
	
	public static int suffixLength2(char c[], int p) {
		int len = 0;
		for (int i = p, j = c.length -1; i >= 0 && c[i] == c[j]; i--, j--) {
			len++;
		}
		return len;
	}
	
	
	
	
	
	
	
	public static boolean isPrefix(char c[], int p) {
		for (int i = p, j = 0; i < c.length; i++,j++) {
			if (c[i] != c[j]) {
				return false;
			}
		}
		return true;
	}
	
	public static int suffixLength(char c[], int p) {
		int len = 0;
		for (int i = p, j = c.length -1; i>= 0 && c[i] == c[j]; i--, j--) {
			len++;
		}
		return len;
	}
	
}
