package com.yahoo.util.strings;

public class ZAlgorithm {
	public static void main(String args[]) {
		String text = "xabcabzabc";
		String pattern = "abc";
		int results[] = calculateZ(text.toCharArray());
		for (int r : results) {
			System.out.print(" " + r);
		}
		System.out.println(" match :: " + match(text, pattern));
	}
	
	public static int match(String text, String pattern) {
		// combine text and pattern
		char [] ztext = new char[text.length() + pattern.length() + 1];
		int index = 0;
		for (char c : pattern.toCharArray()) {
			ztext[index++] = c;
		}
		ztext[index++] = '$';
		for (char c : text.toCharArray()) {
			ztext[index++] = c;
		}
		
		// calculate z index
		int [] results = calculateZ(ztext);
		
		// check for results
		int j = -1;
		for (int i = 0; i < results.length; i++) {
			if (results[i] == pattern.length()) {
				j = (i - pattern.length()  -1);
				System.out.println(j);
			}
		}
		return j;
	}
	
	public static int [] calculateZ(char data[]) {
		int [] results = new int[data.length];
		int left = 0, right = 0;
		for (int k = 1; k < data.length; k++) {
			if (k > right) {
				left = right = k;
				while (right < data.length && data[right] == data[right - left]) {
					right++;
				}
				results[k] = right -left;
				right--;
			} else {
				int k1 = k - left;
				if (results[k1] < right - k + 1) {
					results[k] = results[k1];
				} else {
					left = k;
					while (right < data.length && data[right] == data[right - left]) {
						right++;
					}
					results[k] = right -left;
					right--;
				}
			}
		}
		
		return results;
	}
}
