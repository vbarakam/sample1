package com.yahoo.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test6 {
	public static void main(String args[]) {
		String aa = "abcabcbb";

		System.out.println(longest2(aa));

		int results[] = compute(aa.toCharArray());

		for (int c : results) {
			System.out.print(c);
		}

	}
	
	public static int longest2(String s) {
        Set<Character> chars = new HashSet<>();
        int j = -1;
        String previous = null;
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < s.length(); index++) {
            if (!chars.contains(s.charAt(index))) {
                builder.append(s.charAt(index));
                
                if (j == -1) {
                    j = index;
                }
            } else {
                if (builder.length() > 0) {
                    if (previous != null && builder.toString().length() >= previous.length()) {
                        previous = builder.toString();
                    } else if (previous == null) {
                        previous = builder.toString();
                    }
                    builder = new StringBuilder();
                    chars = new HashSet<>();
                    index = j;
                    j = -1;
                } else {
                    
                }
            }
        }
        
        if (previous == null && builder.toString().equals(s)) {
            previous = builder.toString();
        }
        
        return previous != null ? previous.length() : 0;
	}

	public static int longest(String s, int min, int max, int k) {
		if (max - min < k) {
			return 0;
		}
		
		// build a
		int counter[] = new int[26];
		for (int index = min; index < max; index++) {
			counter[s.charAt(index) - 'a'] += 1;
		}
		
		// split the string based on char, which is less that threshold
		for (int i = 0; i < 26; i++) {
			if (counter[i] > 0 && counter[i] < k) {
				for (int kk = min; kk < max; kk++) {
					if (s.charAt(kk) == 'a' + i) {
						int left = longest(s, min, kk, k);
						int right = longest(s,kk+1,max,k);
						return Math.max(left, right);
					}
				}
			}
		}
		
		return (max - min);
	}

	public static int longestSubstring(String s, int k) {

		// map of chars to count
		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : s.toCharArray()) {
			Integer count = charCount.get(c);
			if (count == null) {
				count = new Integer(0);
			}
			count = count + 1;
			charCount.put(c, count);
		}

		// start from the begining
		int ccount = 0;
		boolean wasGood = false;
		Map<Character, Integer> cCharCount = new HashMap<>();
		for (int index = 0; index < s.length(); index++) {
			Integer count = charCount.get(s.charAt(index));
			if (!wasGood && count < k) {
				ccount = 0;
				cCharCount = new HashMap<>();
			}

			// increment the substring lenght
			ccount = ccount + 1;

			// increment the count
			Integer count2 = cCharCount.get(s.charAt(index));
			if (count2 == null) {
				count2 = new Integer(0);
			}
			count2 = count2 + 1;
			cCharCount.put(s.charAt(index), count2);

			boolean good = true;
			// check if all the chars have alteast k values
			for (Character ch : cCharCount.keySet()) {
				Integer cc = cCharCount.get(ch);
				if (cc >= k) {
					good = good && true;
				} else {
					good = false;
				}
			}

			if (wasGood && !good) {
				break;
			}

			if (good) {
				wasGood = true;
			}
		}

		return wasGood ? ccount - 1 : 0;
	}

	public static boolean repeatedSubstringPattern(String str) {
		if (str == null || str.length() <= 1) {
			return false;
		}

		int j = 0;
		int start = 0;
		boolean match = false;
		for (int k = 1; k < str.length(); k++) {
			if (str.charAt(j) == str.charAt(k)) {
				j = j + 1;
				if (start == 0) {
					start = k;
				}
				match = true;
			} else {
				j = 0;
				if (start != 0) {
					k = start;
				}
				start = 0;
				match = false;
			}
		}
		System.out.println(" match " + match);
		return j >= start ? true : false;
	}

	public static int[] compute(char arr[]) {
		int results[] = new int[arr.length];
		int j = 0;
		for (int index = 1; index < arr.length;) {
			if (arr[j] == arr[index]) {
				results[index] = j + 1;
				j = j + 1;
				index = index + 1;
			} else {
				if (j != 0) {
					j = results[j - 1];
				} else {
					index++;
				}
			}
		}

		return results;
	}

	public static boolean repeatedSubstringPattern2(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		// find the distinct elements
		Set<Character> chars = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			chars.add(c);
		}

		if (str.length() % chars.size() != 0) {
			return false;
		}

		int i = 1;
		for (int index = chars.size(); index < str.length(); index++) {
			if (str.charAt(index) != i) {
				return false;
			}
			i = i + 1;
		}
		return true;
	}
}
