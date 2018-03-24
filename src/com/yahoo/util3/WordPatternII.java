package com.yahoo.util3;

import java.util.*;

public class WordPatternII {
	public static void main(String args[]){
		String pattern = "abab", str = "redblueredblue";
		String pattern1 = "aaaa", str1 = "asdasdasdasd"; //should return true.
		String pattern2 = "aabb", str2 = "xyzabcxzyabc"; //should return false.
		String pattern3 = "abba", str3 = "dogcatcatdog";
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		System.out.println(isMatch(pattern, 0, str, 0, map, set));
		map.clear();
		set.clear();
		System.out.println(isMatch(pattern1, 0, str1, 0, map, set));
		map.clear();
		set.clear();
		System.out.println(isMatch(pattern2, 0, str2, 0, map, set));
		map.clear();
		set.clear();
		System.out.println(isMatch(pattern3, 0, str3, 0, map, set));
	}
	
	private static boolean isMatch(String pattern, int pStart, String str, int sStart,
				Map<Character, String> map, Set<String> set) {
		
		if (pStart == pattern.length() && sStart == str.length()) {
			return true;
		}
		if (pStart == pattern.length() || sStart == str.length()) {
			return false;
		}
		
		char ch = pattern.charAt(pStart);
		if (map.containsKey(ch)) {
			String inner = map.get(ch);
			
			if (!str.startsWith(inner, sStart)) {
				return false;
			}
			
			return isMatch(pattern, pStart + 1, str, sStart + inner.length(), map, set);
		}
		
		for (int i = sStart; i < str.length(); i++ ) {
			System.out.println(str + " " + sStart + " ==> " + sStart + i);
			String match = str.substring(sStart, 1+i);
			
			if (set.contains(match)) {
				continue;
			}
			
			set.add(match);
			map.put(ch, match);
			
			if (isMatch(pattern, pStart + 1, str, 1+i, map, set)) {
				return true;
			}
			set.remove(match);
			map.remove(ch);
		}
		return false;
	}
}
