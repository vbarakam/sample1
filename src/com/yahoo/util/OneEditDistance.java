package com.yahoo.util;

import java.util.*;

public class OneEditDistance {
	
	public static void main(String args[]) {
		System.out.println(isOneEditDistance("ab", "cab"));
	}

	public static boolean isOneEditDistance(String word1, String word2) {

		// simple check to decide based on length
		if (Math.abs(word1.length() - word2.length()) > 1) {
			return false;
		}

		// if length of words are equal
		if (word1.length() == word2.length()) {
			int d = 0;
			for (int i = 0; i < word1.length(); i++) {
				if (word1.charAt(i) != word2.charAt(i)) {
					d += 1;
					if (d > 1) {
						return false;
					}
				}
			}
			if (d == 1) {
				return true;
			} else {
				return false;
			}
		}

		// bigger
		String bigger = word1.length() > word2.length() ? word1 : word2;
		String smaller = word1.length() < word2.length() ? word1 : word2;

		if (smaller.length() == 0 && bigger.length() == 1) {
			return true;
		}

		int d = 0;
		int j = 0;
		for (int i = 0; i < smaller.length(); i++) {
            //for (int j = 0; j < smaller.length(); j++) {
                if (bigger.charAt(j) != smaller.charAt(i)) {
                    j = j + 1;
                    i = i -1;
                    d += 1;
                    if (d > 1) {
                        return false;
                    }
                } else {
                    j = j + 1;
                }
            //}
        }
        
        if (d <= 1 || (d == 0 && ((j + 2) == bigger.length()))) {
                return true;
            } else {
                return false;
            } 

	}
}
