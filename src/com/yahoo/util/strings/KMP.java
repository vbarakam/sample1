package com.yahoo.util.strings;

public class KMP {

	
	public static int[] prefixFuction3(String pattern) {
		int [] table = new int[pattern.length()];
		int j = 0;
		for (int k = 1; k < pattern.length();) {
			if (pattern.charAt(j) == pattern.charAt(k)) {
				table[k] = j + 1;
				j++;
				k++;
			} else {
				if (j != 0) {
					j = table[j-1];
				} else {
					j = 0;
					table[k] = 0;
					k++;
				}
			}
		}
		return table;
	}
	
	
	public static void main(String args[]) {
		String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
		String pattern = "aaaaabc";
		int[] results2 = prefixFuction3(pattern);
		int i = 0, j = 0;
		while (i < text.length() && j < results2.length) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = results2[j-1];
				} else {
					i++;
				}
			}
		}
		
		if (j == pattern.length()) {
			System.out.println(" match " + (i - j));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] prefixFuction(String pattern) {
		int r[] = new int[pattern.length()];
		int j = 0;
		for (int k = 1; k < pattern.length();) {
			if (pattern.charAt(k) == pattern.charAt(j)) {
				r[k] = j + 1;
				j++;
				k++;
			} else {
				if (j != 0) {
					j = r[j - 1];
				} else {
					j = 0;
					r[k] = 0;
					k++;
				}
			}
		}
		return r;
	}

	public static void main3(String args[]) {
		String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
		String pattern = "aaaaabc";
		int[] results2 = prefixFuction(pattern);
		int i = 0, j = 0;
		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = results2[j - 1];
				} else {
					i++;
				}
			}
		}

		if (j == pattern.length()) {
			System.out.println(" match " + (i - j));
		}
	}

	// ababaca
	public static int[] computePrefixFuction(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return (new int[0]);
		}

		int results[] = new int[prefix.length()];
		int j = 0;
		for (int k = 1; k < prefix.length();) {
			if (prefix.charAt(j) == prefix.charAt(k)) {
				j = j + 1;
				results[k] = j;
				k = k + 1;
			} else {
				if (j > 0) {
					j = results[j - 1];
				} else {
					k = k + 1;
					j = 0;
				}
			}
		}
		return results;
	}

	public static int[] computeTemporaryArray2(char pattern[]) {
		int[] lps = new int[pattern.length];
		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static int[] computePrefixFuction3(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return (new int[0]);
		}

		int results[] = new int[prefix.length()];
		results[0] = 0;
		int i = 0;
		for (int index = 1; index < prefix.length(); index++) {
			if (prefix.charAt(i) == prefix.charAt(index)) {
				i = i + 1;
			} else {
				if ((i - 1) > 0) {
					i = results[i - 1];
				} else {
					i = 0;
				}
			}
			results[index] = i;

		}

		return results;
	}
}
