package com.yahoo.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSet {

	public static void main(String args[]) {
		List<String> result = new ArrayList<>();
		subset(result, "", "01");
		System.out.println(result);
	}

	public static void subset(List<String> results, String sofar, String rest) {
		if (rest.trim().length() == 0) {
			if (sofar.length() > 0)
			    results.add(sofar);
			return;
		}
		// first char
		if (Integer.parseInt(rest.substring(0,1)) > 0)
		    subset(results, sofar + rest.substring(0, 1), rest.substring(1));
		
		// first two
		if (rest.length() > 1 && Integer.parseInt(rest.substring(0,2)) > 0 && Integer.parseInt(rest.substring(0,2)) <= 26)
			subset(results, sofar + rest.substring(0, 2), rest.substring(2));
	}
	
	public static void permutations(String sofar, String rest) {
		if (rest.trim().length() == 0) {
			System.out.println(sofar);
			return;
		}
		
		for (int i = 0; i < rest.length(); i++ ) {
			String remaining = rest.substring(0, i) + rest.substring(i+1);
			permutations(sofar + rest.charAt(i), remaining);
		}
	}
}
