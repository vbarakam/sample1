package com.yahoo.mediam;

import java.util.*;

public class GenerateParentheses {
	public static void main(String args[]) {
		List<String> result = new ArrayList<>();
		paren(result, "", 0, 0, 3);
		System.out.println(result);
	}
	
	private static void paren(List<String> results, String str, int open, int close, int max) {
		if (str.length() == max * 2) {
			results.add(str);
			return;
		}
		
		if (open < max) {
			paren(results, str + "(", open + 1, close, max);
		}
		
		if (close < open) {
			paren(results, str + ")", open, close + 1, max);
		}
	}
}
