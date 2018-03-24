package com.yahoo.util;

public class RotateString {
	public static void main(String args[]) {
		String str = "the sky isa blu";
		char [] ch = str.toCharArray();	
		reverse(ch, 0, str.length() -1);
		int start = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				reverse(ch, start, i-1);
				start = i + 1;
			}
		}
		reverse(ch, start, ch.length - 1);
		System.out.println(new String(ch));
	}
	
	public static void reverse(char[] s, int start, int end) {
	    while (start < end) {
	        char temp = s[start];
	        s[start] = s[end];
	        s[end] = temp;
	        start++;
	        end--;
	    }
	}
	
	public static void main2(String args[]) {
		String str = "the sky isa blue";
		char [] ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			// get the last char
			char temp = ch[str.length() -1];
			// shit all the chars by 1
			for (int l = str.length() -2; l >=0; l--) {
				ch[l+1] = ch[l];
			}
			ch[0] = temp;
		}
		System.out.println(new String(ch));
	}
	
	public static void main3(String args[]) {
		int x = 10, y = 5;
		 
		  // Code to swap 'x' and 'y'
		  x = x ^ y;  // x now becomes 15
		  System.out.println(" x " + x);
		  y = x ^ y;  // y becomes 10
		  x = x ^ y;
		  
		  System.out.println(" x " + x);
		  System.out.println(" y " + y);
		String str = "the sky is blue";
		char [] ch = str.toCharArray();
		
		int start = 0;
		while (true) {
			// find the list of last word
			int lastWordLength = lengthOfLastword(ch);
			if (lastWordLength == -1) {
				break;
			}
			// rotate by word length
			int limit =  start + lastWordLength;
			int rlimit = start;
			for (; start < limit; start++) {
				// get the last char
				char temp = ch[str.length() -1];
				// shit all the chars by 1
				for (int l = str.length() -2; l >=rlimit; l--) {
					ch[l+1] = ch[l];
				}
				ch[rlimit] = temp;
			}
			// insert additional space
			for (int l = str.length() -2; l >= start; l--) {
				ch[l+1] = ch[l];
			}
			
			if (start + 1 > str.length()) {
				break;
			}
			
			ch[start++] = ' ';
			
			// blue the sky is
		}
		
		System.out.println(new String(ch));
	}
	
	public static int lengthOfLastword(char [] ch) {
		int len = 0;
		for (int l = ch.length - 1; l >=0; l--) {
			if (ch[l] == ' ') {
				return len;
			}
			len++;
		}
		return -1;
	}
}
