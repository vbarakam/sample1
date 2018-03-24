package com.yahoo.util.strings;

import java.util.*;

public class StringPermutations {

	public static void main(String args[]) {
		String input = "AABC";
		permutations(input);
	}

	public static void permutations(String str) {
		//
		Map<Character, Integer> chars = new HashMap<>();
		for (int c = 0; c < str.length(); c++) {
			Integer count = chars.get(str.charAt(c));
			if (count == null) {
				count = new Integer(0);
			}
			count += 1;
			chars.put(str.charAt(c), count);
		}

		int[] counts = new int[chars.size()];
		char[] chs = new char[chars.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			counts[index] = entry.getValue();
			chs[index++] = entry.getKey();
		}
		
		char[] results = new char[str.length()];
		perms(results, chs, counts, 0, str.length());
	}
	
	public static void perms(char prefix[], char[] chs, int[] counts, int level, int max) {
		if (max == level) {
			System.out.println(" prefix " + new String(prefix));
			return;
		}
		
		for (int i = 0; i < chs.length; i++) {
			if (counts[i] > 0) {
				counts[i] = counts[i] - 1;
				prefix[level] = chs[i];
				perms(prefix, chs, counts, level + 1, max);
				counts[i] = counts[i] + 1;
			}
		}
	}
}