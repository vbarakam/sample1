package com.yahoo.util;

public class ReverseWithoutSpecialChars {
	public static void main(String args[]) {
		String str = "a!!!b.c.d,e'f,ghi";
		//i!!!h.g.f,e'd,cba
		char strchar [] = str.toCharArray();
		int start = 0;
		int end = str.length() -1;
		while (start < end) {
			// check start is valid char
			if (!isValidChar(strchar[start])  ) {
				start++;
				continue;
			}
			
			// check end is valid char
			if (!isValidChar(strchar[end])  ) {
				end--;
				continue;
			}
			
			// swap
			char temp = strchar[start];
			strchar[start] = strchar[end];
			strchar[end] = temp;
			start++;
			end--;
		}
		
		System.out.println(new String(strchar));
	}
	
	public static boolean isValidChar(char c) {
		if ((c >= 'a' && c <= 'z') 
				|| (c >= 'A' && c <= 'Z')  ) {
			return true;
		}
		return false;
	}
}
