package com.yahoo.util.strings;

import java.util.*;

public class BoyerMoore {
	public static int SIZE = 500;
	public static int table[] = new int[SIZE];

	public static void main(String args[]) {
		String text1 = "GEEKS FOR GEEKS";
		String pattern1 = "GEEKS";
		String text = "MANPANAMANAP";
		String pattern = "ANAMPNAM";
		int bc[] = badChar(pattern);
		int charTable[] = makeCharTable(pattern.toCharArray());
		// System.out.println(match(text, pattern, bc));

		shifttable(pattern);
		System.out.println(horspool(text, pattern));
		
	}

	private static List<Integer> match(String text, String pattern, int[] bc) {
		List<Integer> results = new ArrayList<>();
		for (int i = pattern.length() - 1; i < text.length();) {
			int index = -1;
			for (int j = pattern.length() - 1; text.charAt(i) == pattern.charAt(j) && j < pattern.length(); i--, j--) {
				if (j == 0) {
					System.out.println("match :: " + i);
					index = i;
					break;
				}
			}
			if (index != -1) {
				results.add(i);
				i += 2 * pattern.length();
			} else {
				i += bc[text.charAt(i)];
			}
		}
		return results;
	}

	public static int BMG(String T, String P) {
		int[] lastOcc;
		int i0, j, m, n;

		n = T.length();
		m = P.length();

		lastOcc = computeLastOcc(P); // Find last occurence of all characters in
										// P

		i0 = 0; // Line P up at T[0]

		while (i0 < (n - m)) {
			j = m - 1; // Start at the last char in P

			while (P.charAt(j) == T.charAt(i0 + j)) {
				j--; // Check "next" (= previous) character

				if (j < 0)
					return (i0); // P found !
			}

			if (j < lastOcc[T.charAt(
					i0 + j)]) { /*
								 * ======================================= Bad
								 * character caveat detected
								 * =======================================
								 */
				i0++; // Slide P 1 char further (Goodrich)
			} else {
				i0 = i0 + j - lastOcc[T.charAt(i0 + j)];
				// Bad char + Looking glass heuristic
			}
		}

		return -1; // no match
	}

	public static void shifttable(String pattern) {

		int i, j, m;
		char p[] = pattern.toCharArray();
		m = pattern.length();

		for (i = 0; i < SIZE; i++)
			table[i] = m;
		for (j = 0; j < m; j++)
			table[p[j]] = m - 1 - j;
	}

	public static int horspool(String source, String pattern) {
		int i, k, pos, m;
		char s[] = source.toCharArray();
		char p[] = pattern.toCharArray();
		m = pattern.length();

		for (i = m - 1; i < source.length();) {
			k = 0;
			while ((k < m) && (p[m - 1 - k] == s[i - k]))
				k++;
			if (k == m) {
				pos = i - m + 2;
				return pos;
			} else
				i += table[s[i]];
		}
		return -1;
	}

	public static int[] computeLastOcc(String P) {
		int[] lastOcc = new int[128]; // assume ASCII character set

		for (int i = 0; i < 128; i++) {
			lastOcc[i] = -1; // initialize all elements to -1
		}

		for (int i = 0; i < P.length(); i++) {
			lastOcc[P.charAt(i)] = i; // The LAST value will be store
		}

		return lastOcc;
	}

	public static int[] badChar(String pattern) {
		int bc[] = new int[256];
		for (int i = 0; i < bc.length; i++) {
			bc[i] = pattern.length();
		}

		for (int j = 0; j < pattern.length() - 1; j++) {
			bc[pattern.charAt(j)] = pattern.length() - 1 - j;
		}
		return bc;
	}

	/**
	 * Returns the index within this string of the first occurrence of the
	 * specified substring. If it is not a substring, return -1.
	 * 
	 * @param haystack
	 *            The string to be scanned
	 * @param needle
	 *            The target string to search
	 * @return The start index of the substring
	 */
	public static int indexOf(char[] haystack, char[] needle) {
		if (needle.length == 0) {
			return 0;
		}
		int charTable[] = makeCharTable(needle);
		int offsetTable[] = makeOffsetTable(needle);
		for (int i = needle.length - 1, j; i < haystack.length;) {
			for (j = needle.length - 1; needle[j] == haystack[i]; --i, --j) {
				if (j == 0) {
					return i;
				}
			}
			// i += needle.length - j; // For naive method
			System.out.println(" offsetTable[needle.length - 1 - j] = " + offsetTable[needle.length - 1 - j]);
			System.out.println(" [needle.length - 1 - j] = " + (needle.length - 1 - j));
			System.out.println(" charTable[haystack[i]] = " + charTable[haystack[i]]);
			System.out.println(" haystack[i] =" + haystack[i]);
			i += Math.max(offsetTable[needle.length - 1 - j], charTable[haystack[i]]);
		}
		return -1;
	}

	/**
	 * Makes the jump table based on the mismatched character information.
	 */
	public static int[] makeCharTable(char[] needle) {
		final int ALPHABET_SIZE = 256;
		int[] table = new int[ALPHABET_SIZE];
		for (int i = 0; i < table.length; ++i) {
			table[i] = needle.length;
		}
		for (int i = 0; i < needle.length - 1; ++i) {
			table[needle[i]] = needle.length - 1 - i;
		}
		return table;
	}

	/**
	 * Makes the jump table based on the scan offset which mismatch occurs.
	 */
	private static int[] makeOffsetTable(char[] needle) {
		int[] table = new int[needle.length];
		int lastPrefixPosition = needle.length;
		/*
		 * for (int i = needle.length - 1; i >= 0; --i) { if (isPrefix(needle, i
		 * + 1)) { lastPrefixPosition = i + 1; } table[needle.length - 1 - i] =
		 * lastPrefixPosition - i + needle.length - 1; }
		 */
		for (int i = 0; i < needle.length - 1; ++i) {
			int slen = suffixLength(needle, i);
			System.out.println(" " + slen);
			System.out.println(i + " : " + (needle.length - 1 - i));
			table[slen] = needle.length - 1 - i + slen;
		}
		return table;
	}

	/**
	 * Is needle[p:end] a prefix of needle?
	 */
	private static boolean isPrefix(char[] needle, int p) {
		for (int i = p, j = 0; i < needle.length; ++i, ++j) {
			if (needle[i] != needle[j]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the maximum length of the substring ends at p and is a suffix.
	 */
	private static int suffixLength(char[] needle, int p) {
		int len = 0;
		for (int i = p, j = needle.length - 1; i >= 0 && needle[i] == needle[j]; --i, --j) {
			len += 1;
		}
		return len;
	}
}
