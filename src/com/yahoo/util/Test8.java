package com.yahoo.util;

import java.util.*;

public class Test8 {
	public static void main(String args[]) {
		String pattern = "bbb";
		String text = "abccbababacabbb";
		
		System.out.println(match(text, pattern));
	}
	
	public static int match(String text, String pattern) {

		if (pattern.isEmpty()) {
			return 0;
		}

		int n = text.length();
		int m = pattern.length();

		if (m > n) {
			return -1;
		}
		
		// get the list of characters O(m)
		Set<Character> chars = new HashSet<>(m);
		for (char c : pattern.toCharArray()) {
			chars.add(c);
		}

		// create a table O(m+1)
		Map<Character, Integer> [] data = new HashMap[m + 1];
		for (int i = 0; i <= m; i++) {
			data[i] = new HashMap<>(chars.size());
		}
		
		// initialize first map O(E)
		data[0] = new HashMap<>(chars.size());
		for (char c : chars) {
			data[0].put(c, 0);
		}
		data[0].put(pattern.charAt(0), 1);
		
		// update other data points O(m) * O(E)
		for (int state = 1, lps = 0; state <= m; state++) {
			for (char c : chars) {
				data[state].put(c, data[lps].get(c));
			}
			
			if (state < m) {
				data[state].put(pattern.charAt(state), state + 1);
				lps = data[lps].get(pattern.charAt(state));
			}
		}
		
		Integer state = 0;
		for (int i = 0; i < n; i++) {
			state = data[state].get(text.charAt(i));
			if (state == null) {
				state = 0;
			}
			if (state == m) {
				// match
				return (i - m + 1);
			}
		}
		return -1;
	}
}
