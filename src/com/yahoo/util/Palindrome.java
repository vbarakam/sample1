package com.yahoo.util;

public class Palindrome {
	public static void main(String args []) {
		String str = "acaq";
		System.out.println(palin(str, 0, str.length() -1));
	}
	
	public static boolean palin(String str, int start, int end) {
		if (!(start < end)) {
			return true;
		}
		
		if (str.charAt(start) == str.charAt(end)) {
			return palin(str, start+1, end -1);
		} else {
			return false;
		}
	}
}
