package com.yahoo.util;

public class KMP {
	public static void main(String args[]) {
		
	}
	
	public int[] prefixTable(String pattern) {
		int lps [] = new int[pattern.length()];
		int i = 0;
		for (int index = 0; index < pattern.length();) {
			if (pattern.charAt(i) == pattern.charAt(index)) {
				i++;
				lps[index] = i;
				index++;
			} else {
				if (i != 0) {
					i = lps[i -1];
				} else {
					lps[index] = 0;
					index++;
				}
			}
		}
		return lps;
	}
}
