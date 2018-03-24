package com.yahoo.util;

import java.util.*;

public class RabinKarp {

	public int patternSearch(char[] text, char[] pattern) {
		if (pattern.length > text.length) {
			return -1;
		}
		
		// create the pattern hash
		int patterHash = createHash(pattern, 0, pattern.length);
		int textHash = createHash(text, 0, pattern.length);
		
		for (int start = 0; start < text.length - pattern.length + 1; start++) {

			// check if hash is same, if so check the pattern and text
			if (patterHash == textHash) {
				char textMatch[] = Arrays.copyOfRange(text, start, start + pattern.length);
				if (new String(pattern).equals(new String(textMatch))) {
					return start;
				}
			}
			
			if ((start + 1) < (text.length - pattern.length + 1)) {
				// calculate rolling hash
				textHash -= (text[start] - 'a');
				textHash = textHash/101;
				textHash += (text[start + pattern.length] - 'a') * Math.pow(101, pattern.length -1);
			}
		}
		return -1;
	}

	public int createHash(char[] text, int start, int l) {
		double hash = 0;
		int counter = 0;
		for (int i = start; i < start +l; i++) {
			hash = hash + (text[i] - 'a') * Math.pow(101, counter++);
		}

		return (int) hash;
	}

	public static void main(String args[]) {
		RabinKarp rks = new RabinKarp();
		//i < 9-7 + 1 = 2
		//0
		//System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "sharRoy".toCharArray()));
		System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "Roy".toCharArray()));
		//System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "shas".toCharArray()));
		//System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "usha".toCharArray()));
		//System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));
	}
}
