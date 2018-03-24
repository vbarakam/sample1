package com.yahoo.util;

import java.util.Arrays;

public class Test11 {
	public static void main(String args[]) {
		// String str = "THIS IS A TEST TEXT";
		String str = "AAAAAAAAAAAAAAAA";
		String pattern = "AAAAAA";
		System.out.println(match(str, pattern));
	}

	public static int match(String text, String pattern) {
		int j = 0;
		int lastMatch = -1;
		for (int i = 0; i < text.length();) {
			if (j < pattern.length()) {
				if (text.charAt(i) == pattern.charAt(j)) {
					if (lastMatch == -1) {
						lastMatch = i;
					}
					i++;
					j++;
				} else {
					if (lastMatch != -1) {
						i = lastMatch + 1;
					} else {
						i++;
					}
					lastMatch = -1;
					j = 0;
				}
			} else {
				System.out.println(" match : " + lastMatch);
				lastMatch = -1;
				j = 0;
			}
		}

		return lastMatch;
	}
}
