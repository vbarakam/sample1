package com.yahoo.util;

import java.util.*;

public class MinimumWindowSubstring {
	public static void main(String args[]) {
		String str = "a";
		String tr = "b";
		// "of_characters_and_as"
		// "aas"
		System.out.println(minWindow22(str, tr));
	}

	public static String minWindow22(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		int start = 0, end = 0, counter = t.length(), min = Integer.MAX_VALUE, head = 0;
		int counts[] = new int[256];
		for (char x : t.toCharArray()) {
			counts[x]++;
		}
		for (char x : s.toCharArray()) {
			if (counts[x] > 0) {
				counter--;
			}
			counts[x]--;
			end++;

			while (counter == 0) {
				if (min > end - start) {
					min = end - start;
					head = start;
				}

				if (counts[s.charAt(start++)]++ == 0) {
					counter++;
				}
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
	}

	public static String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>(128);
		for (char c : s.toCharArray())
			map.put(c, 0);

		for (char c : t.toCharArray()) {
			if (!map.containsKey(c))
				return "";
			map.compute(c, (k, v) -> (v + 1));
		}

		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();

		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map.get(c1) > 0)
				counter--;
			map.compute(c1, (key, val) -> val - 1);
			end++;

			while (counter == 0) {
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}

				final char startChar = s.charAt(start);
				map.compute(startChar, (key, val) -> val + 1);
				if (map.get(startChar) > 0)
					counter++;
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	public static String minWindow3(String s, String t) {
		int start = 0, end = 0, counter = t.length(), n = s.length(), head = 0;
		int min = Integer.MAX_VALUE;
		int counts[] = new int[256];
		for (char c : t.toLowerCase().toCharArray()) {
			counts[c]++;
		}

		while (end < n) {
			// increment the counter
			if (counts[s.charAt(end)] > 0) {
				counter--;
			}
			counts[s.charAt(end)]--;
			end++;

			while (counter == 0) {
				// min
				if (min > end - start) {
					min = end - start;
					head = start;
				}

				// update start
				// counts[s.charAt(start) - 'a']++;
				// start++;

				if (counts[s.charAt(start++)]++ == 0) {
					counter++;
				}
				// start++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
	}

	public static String minWindow2(String s, String t) {
		int start = 0, end = 0, minLength = Integer.MAX_VALUE, counter = t.length();
		int minStart = 0;
		int c[] = new int[256];
		for (int i = 0; i < t.length(); i++) {
			c[t.charAt(i)]++;
		}

		while (end < s.length()) {
			if (c[s.charAt(end)] > 0) {
				counter--;
			}
			c[s.charAt(end)]--;
			end++;

			while (counter == 0) {
				if ((end - start) < minLength) {
					minLength = end - start;
					minStart = start;
				}

				if (t.contains(new String(s.charAt(start) + ""))) {
					c[s.charAt(start)]++;
				}
				if (c[s.charAt(start)] > 0) {
					counter++;
				}
				start++;
			}
		}

		if (minLength != Integer.MAX_VALUE) {
			return s.substring(minStart, minStart + minLength);
		}
		return "";
	}
}
