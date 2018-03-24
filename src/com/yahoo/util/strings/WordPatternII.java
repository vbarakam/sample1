package com.yahoo.util.strings;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
	public static boolean wordPatternMatch(String pattern, String str) {
		return isMatch(pattern, 0, str, 0, new HashMap<Character, String>(), new LinkedHashSet<String>());
	}

	private static boolean isMatch(String pattern, int pStart, String str, int sStart, Map<Character, String> map, Set<String> set) {
		if (pStart == pattern.length() && sStart == str.length()) {
			return true;
		}
		
		if (pStart == pattern.length() || sStart == str.length()) {
			return false;
		}
		
		char ch = pattern.charAt(pStart);
		if (map.containsKey(ch)) {
			String temp = map.get(ch);
			if (!str.startsWith(temp, sStart)) {
				return false;
			}
			return isMatch(pattern, pStart + 1, str, sStart+temp.length(), map, set);
		}
		
		for (int i = sStart; i < str.length(); i++) {
			String match = str.substring(sStart, i+1);
			if (set.contains(match)) {
				continue;
			}
			map.put(ch, match);
			set.add(match);
			
			if (isMatch(pattern, pStart+1, str, i+1, map, set)) {
				return true;
			}
			
			map.remove(ch);
			set.remove(match);
		}
		
		return false;
	}

	public static void main(String args[]) {
		long epoch = System.currentTimeMillis()/1000;
		System.out.println(epoch);
		String pattern = "abab", str = "redblueredblue";// should return true.
		System.out.println(wordPatternMatch(pattern, str));
		pattern = "aaaa";
		str = "asdasdasdasd";// should return true.
		System.out.println(wordPatternMatch(pattern, str));
		pattern = "aabb";
		str = "xyzabcxzyabc";// should return false.
		System.out.println(wordPatternMatch(pattern, str));
	}
}
